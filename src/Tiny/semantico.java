package Tiny;

import ast.*;

public class semantico {
	private TablaSimbolos tablaSimbolos;
	
	public semantico(TablaSimbolos tablaSimbolos) {
		super();
		this.tablaSimbolos = tablaSimbolos;

	}

	public void recorrerArbol(NodoBase raiz){		
		while (raiz != null) {
			/* Hago el recorrido recursivo */
			if(raiz instanceof NodoProgram){
				System.out.println("probando semantic");
				recorrerArbol(((NodoProgram)raiz).getBody_program());
			}
			if(raiz instanceof NodoMain){
				if(((NodoMain)raiz).getFunctions() != null)
					recorrerArbol(((NodoMain)raiz).getFunctions());
				if(((NodoMain)raiz).getProcedure() != null)
					recorrerArbol(((NodoMain)raiz).getProcedure());
				
				recorrerArbol(((NodoMain)raiz).getBody());
			}
			else if (raiz instanceof NodoBegin){
		    	recorrerArbol(((NodoBegin)raiz).getBody_begin());
		    }
			else if (raiz instanceof NodoIf){
		    	verificarIf(raiz);
		    }
				

		    raiz = raiz.getHermanoDerecha();
	  }
		
	}
	
	private void verificarIf(NodoBase nodo){
		if(verificarTipo(((NodoIf)nodo).getPrueba()) != "Boolean"){
			System.out.println("Imposible realizar esta acción");
		}
		recorrerArbol(((NodoIf)nodo).getParteThen());
		if(((NodoIf)nodo).getParteElse() != null){
			System.out.println("Imposible realizar esta acción");
		}
			
	}
	
}
