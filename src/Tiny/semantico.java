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
			else if (raiz instanceof NodoAsignacion) {
				verificarAsignacion(raiz);
			}
			else if (raiz instanceof NodoFor){
				verificarFor(raiz);
			}
			else if (raiz instanceof NodoWhile){
				verificarWhile(raiz);
			}
			else if (raiz instanceof NodoRepeat){
				verificarRepeat(raiz);
			}
			else if (raiz instanceof NodoEscribir){
				verificarEscribir(raiz);
			}
			else if (raiz instanceof NodoLeer){
				verificarLeer(raiz);
			}
			
				

		    raiz = raiz.getHermanoDerecha();
	  }
		
	}
	
	private void verificarIf(NodoBase nodo){
		if(verificarTipo(((NodoIf)nodo).getPrueba()) != "Boolean")
			System.out.println("Imposible realizar esta acción");
		
		recorrerArbol(((NodoIf)nodo).getParteThen());
		if(((NodoIf)nodo).getParteElse() != null){
			recorrerArbol(((NodoIf)nodo).getParteElse());
		}
			
	}
	
	private boolean verificarAsignacion(NodoBase nodo) {
		
		/*
		 * Verifica que el identificador y la expresion retornen
		 * el mismo tipo de dato
		*/
		
		String identificador = ((NodoAsignacion)nodo).getIdentificador();
		
		if(verificarExistencia(identificador)) {
			if(this.tablaSimbolos.getTipo(identificador) 
					== verificarTipo(((NodoAsignacion)nodo).getExpresion())) {
					
					return true;
				
			}
		} else {
			// el identificador no ha sido declarado
			// debe pararse la ejecucion
		}
		// Ocurrio un error y debe pararse la ejecucion
		// type mismatch
		return false;
		
	}
	
	private void verificarFor(NodoBase nodo){
		
		recorrerArbol(((NodoFor)nodo).getVariable());
		if(!verificarAsignacion(((NodoFor)nodo).getVariable()))
			System.out.println("Imposible realizar esta acción: Debe ingresar una expresión de prueba correcta");
		
		recorrerArbol(((NodoFor)nodo).getValorFinal());
		if(verificarTipo(((NodoFor)nodo).getValorFinal()) != "Integer")
			System.out.println("Imposible realizar esta acción: Debe ingresar una valor final correcto");
		
		recorrerArbol(((NodoFor)nodo).getCuerpo());
			
	}
	
	private void verificarWhile(NodoBase nodo){
		
		recorrerArbol(((NodoWhile)nodo).getPrueba());
		if(verificarTipo(((NodoWhile)nodo).getPrueba()) != "Boolean")
			System.out.println("Imposible realizar esta acción: Debe ingresar una expresión de prueba correcta");
		
		recorrerArbol(((NodoWhile)nodo).getCuerpo());
			
	}
	
	private void verificarRepeat(NodoBase nodo){
		
		recorrerArbol(((NodoRepeat)nodo).getCuerpo());
		
		if(verificarTipo(((NodoRepeat)nodo).getPrueba()) != "Boolean")
			System.out.println("Imposible realizar esta acción: Debe ingresar una expresión de prueba correcta");
		
	}
	
	private void verificarEscribir(NodoBase nodo){
		
		if(verificarTipo(((NodoEscribir)nodo).getExpresion()) != "Integer")
			System.out.println("Imposible realizar esta acción: Debe ingresar una expresión de prueba correcta");
		
	}
	
	private void verificarLeer(NodoBase nodo){
		System.out.println(((NodoLeer)nodo).getIdentificador());
		if(!verificarExistencia(((NodoLeer)nodo).getIdentificador()))
			System.out.println("Imposible realizar esta acción: No se ha declarado la variable");
		
	}
	
	private String verificarTipo (NodoBase nodo) {
		
		if (nodo instanceof NodoOperacion) {
			
			String tipoOperadorHI = verificarTipo(((NodoOperacion)nodo).getOpIzquierdo());
			String tipoOperadorHD = verificarTipo(((NodoOperacion)nodo).getOpDerecho());
			tipoOp operador = ((NodoOperacion)nodo).getOperacion();
			
			if(operador == tipoOp.and || operador == tipoOp.or){
				if(tipoOperadorHI == "Boolean" && tipoOperadorHD == "Boolean"){
					return "Boolean";
				} else {
					return "typeError";
				}
			}
			else if (operador == tipoOp.igual || operador == tipoOp.diferente) {
				if(tipoOperadorHD == "Boolean" && tipoOperadorHI == "Boolean") {
					return "Boolean";
				} else if (tipoOperadorHI == "Integer" && tipoOperadorHD == "Integer") {
					return "Boolean";
				}
				else {
					return "typeError";
				}
			}
			else if (  operador == tipoOp.mas 
					|| operador == tipoOp.menos 
					|| operador == tipoOp.entre
					|| operador == tipoOp.por ) {
				
					if(tipoOperadorHI == "Integer" && tipoOperadorHD == "Integer" ) {
						return "Integer";
					} else {
						return "typeError";
					}
				
			} else {
				if(tipoOperadorHI == "Integer" && tipoOperadorHD == "Integer") {
					return "Boolean";
				} else {
					return "typeError";
				}
			}
			
		}
		
		else if (nodo instanceof NodoIdentificador){
			String nombre = ((NodoIdentificador)nodo).getNombre();
			if(verificarExistencia(nombre)){
				
				String tipo = this.tablaSimbolos.getTipo(nombre);
				
				return tipo;
				
			}
			return "typeError";
		}
		
		else if (nodo instanceof NodoValor) {
			
			Integer tipo = ((NodoValor)nodo).getTipo();
			
			if(tipo == 0)
				return "Integer";
			if(tipo == 1)
				return "Boolean";
			
		}
		
		return "typeError";
		
	}
	
	private boolean verificarExistencia(String nombre){
		return this.tablaSimbolos.BuscarVariable(nombre);
	}
	
}
