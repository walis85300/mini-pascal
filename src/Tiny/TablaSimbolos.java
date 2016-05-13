package Tiny;


import java.util.*;


import ast.NodoAsignacion;
import ast.NodoBase;
import ast.NodoEscribir;
import ast.NodoIdentificador;
import ast.NodoIf;
import ast.NodoOperacion;
import ast.NodoRepeat;
import ast.NodoWhile;
import ast.NodoLeer;
import ast.NodoFor;
import ast.NodoBegin;
import ast.NodoCallFuncion;
import ast.NodoCallProcedure;
import ast.NodoFuncion;
import ast.NodoMain;
import ast.NodoProcedure;
import ast.NodoProgram;
import ast.NodoRepeat;
import ast.NodoVar;
import ast.NodoValor;


public class TablaSimbolos {
	/*
	 * tabla que guarda los identificadores*/
	private HashMap <String, RegistroSimbolo> tabla;	
	/*
	 * Contiene la linea inicial de la ejecucion del proc o func*/
	private HashMap <String, Integer> tablaProcFunc;
	/*
	 * Tabla que me almacena el tipo de retorno de la funcion*/
	private HashMap <String, String> tablaTipo;
	private int direccion;  //Contador de las localidades de memoria asignadas a la tabla
	String tipoVar;
	public boolean error = false;
	
	/*
	 * Me va a almacenar los argumentos que recibe un proc o func
	 * */
	private HashMap <String, ArrayList<String>> tablaDeArgumentos;
	
	public TablaSimbolos() {
		super();
		tabla = new HashMap <String, RegistroSimbolo>();
		tablaProcFunc = new HashMap <String, Integer>();
		direccion=0;
	}

	public void cargarTabla(NodoBase raiz){
		while (raiz != null) {
	    if (raiz instanceof NodoIdentificador){
	    	InsertarSimbolo(((NodoIdentificador)raiz).getNombre(),-1,tipoVar, -1);
	    	//TODO: A�adir el numero de linea y localidad de memoria correcta
	    }

	    /* Hago el recorrido recursivo */
	    if (raiz instanceof  NodoIf){
	    	cargarTabla(((NodoIf)raiz).getPrueba());
	    	cargarTabla(((NodoIf)raiz).getParteThen());
	    	if(((NodoIf)raiz).getParteElse()!=null){
	    		cargarTabla(((NodoIf)raiz).getParteElse());
	    	}
	    }
	    else if (raiz instanceof  NodoRepeat){
	    	cargarTabla(((NodoRepeat)raiz).getCuerpo());
	    	cargarTabla(((NodoRepeat)raiz).getPrueba());
	    }
	    else if (raiz instanceof  NodoAsignacion){
	    	InsertarSimbolo(((NodoAsignacion)raiz).getIdentificador(),-1,tipoVar, -1);
	    	cargarTabla(((NodoAsignacion)raiz).getExpresion());
	    }
	    else if (raiz instanceof  NodoEscribir)
	    	cargarTabla(((NodoEscribir)raiz).getExpresion());
	    else if (raiz instanceof NodoOperacion){
	    	cargarTabla(((NodoOperacion)raiz).getOpIzquierdo());
	    	cargarTabla(((NodoOperacion)raiz).getOpDerecho());
	    }
	    else if (raiz instanceof  NodoWhile)
	    {
	    	cargarTabla(((NodoWhile)raiz).getPrueba());
	    	cargarTabla(((NodoWhile)raiz).getCuerpo());
	    }
	    else if (raiz instanceof NodoBegin){
	    	cargarTabla(((NodoBegin)raiz).getBody_begin());
	    }
	    else if (raiz instanceof NodoCallProcedure){
	    	InsertarSimbolo(((NodoCallFuncion)raiz).getName_function(),-1,tipoVar, -1);
	    	cargarTabla(((NodoCallProcedure)raiz).getArgs());
	    }
	    else if (raiz instanceof NodoCallFuncion){
	    	InsertarSimbolo(((NodoCallFuncion)raiz).getName_function(),-1,tipoVar, -1);
	    	if(((NodoCallFuncion)raiz).getArgs() != null){
	    		cargarTabla(((NodoFuncion)raiz).getArgs());
	    	}
	    	cargarTabla(((NodoCallProcedure)raiz).getArgs());
	    }
	    else if (raiz instanceof NodoFor){
	    	cargarTabla(((NodoFor)raiz).getVariable());
	    	cargarTabla(((NodoFor)raiz).getValorFinal());
	    	cargarTabla(((NodoFor)raiz).getCuerpo());
	    }
	    else if (raiz instanceof NodoProgram){
	    	if(((NodoProgram)raiz).getName_program()!=null){
	    		InsertarSimbolo(((NodoProgram)raiz).getName_program(),-1,null, -1);
	    	}
	    	cargarTabla(((NodoProgram)raiz).getBody_program());
	    }
	    else if (raiz instanceof NodoBegin){
	    	cargarTabla(((NodoBegin)raiz).getBody_begin());
	    }
	    else if (raiz instanceof NodoMain){
	    	if(((NodoMain)raiz).getVars()!=null)
	    		cargarTabla(((NodoMain)raiz).getVars());
	    	if(((NodoMain)raiz).getProcedure()!=null)
	    		cargarTabla(((NodoMain)raiz).getProcedure());
	    	if(((NodoMain)raiz).getFunctions()!=null)
	    		cargarTabla(((NodoMain)raiz).getFunctions());
	    	if(((NodoMain)raiz).getBody()!=null)
	    		cargarTabla(((NodoMain)raiz).getBody());
	    }
	    else if(raiz instanceof NodoVar){
	    	if(((NodoVar)raiz).TieneHermano()){
	    		if( tabla.containsKey(((NodoVar)raiz).getName_var()) ){
	    			System.out.println("Error semantico: Variable ya definida");
	    		}
	    		else{
	    			if(!InsertarSimbolo(((NodoVar)raiz).getName_var(),-1,((NodoVar)raiz).getType_var(),
	    					((NodoVar)raiz).getTamano() ))
	    				cargarTabla(((NodoVar)raiz).getHermanoDerecha());
	    		}
	    	}
	    	else
	    		InsertarSimbolo(((NodoVar)raiz).getName_var(),-1,((NodoVar)raiz).getType_var(), 
	    				((NodoVar)raiz).getTamano());
	    }
	    else if (raiz instanceof NodoFuncion){
	    	InsertarSimbolo(((NodoFuncion)raiz).getName_function(),-1,((NodoFuncion)raiz).getType_function(), -1);
	    	if(((NodoFuncion)raiz).getArgs()!=null)
	    		cargarTabla(((NodoFuncion)raiz).getArgs());
	    	cargarTabla(((NodoFuncion)raiz).getBody_function());
	    }
	    else if (raiz instanceof NodoCallFuncion){
	    	if(((NodoFuncion)raiz).getArgs()!=null)
	    		cargarTabla(((NodoFuncion)raiz).getArgs());
	    }

	    raiz = raiz.getHermanoDerecha();
	  }
	}
	
	//true es nuevo no existe se insertara, false ya existe NO se vuelve a insertar 
	public boolean InsertarSimbolo(String identificador, int numLinea, String tipo, int tamano){
		RegistroSimbolo simbolo;
		boolean array = false;
		if(tabla.containsKey(identificador)){
			return false;
		}else{
			/*
			 * Si el tamaño es != -1 significa que es un array*/
			if (tamano != -1) 
				array = true;
			
			simbolo= new RegistroSimbolo(identificador,numLinea,direccion++,tipo, array);
			tabla.put(identificador,simbolo);					
			
			/*
			 * Se apartan las direcciones de memoria suficientes para que todas las posiciones 
			 * del array puedan ser indexadas*/
			if (array)
				direccion = direccion + tamano;
			
			return true;	
		}
	}
	
	public RegistroSimbolo BuscarSimbolo(String identificador){
		RegistroSimbolo simbolo=(RegistroSimbolo)tabla.get(identificador);
		return simbolo;
	}
	
	public boolean BuscarVariable(String identificador){
		if(tabla.containsKey(identificador)){
			return true;
		}else{
			return false;			
		}
	}
	
	public String getTipo(String identificador) {
		RegistroSimbolo simbolo = this.tabla.get(identificador);
		return simbolo.getTipo();
	}
	
	public void ImprimirClaves(){
		System.out.println("*** Tabla de Simbolos ***");
		for( Iterator <String>it = tabla.keySet().iterator(); it.hasNext();) { 
            String s = (String)it.next();
	    System.out.println("Consegui Key: "+s+" con direccion: " + BuscarSimbolo(s).getDireccionMemoria());
		}
	}

	public int getDireccion(String Clave){
		return BuscarSimbolo(Clave).getDireccionMemoria();
	}
	public boolean getError(){
		return error;
	}
	
	public void setArgumentos(String nomProcFunc, ArrayList<String> args) {
		tablaDeArgumentos.put(nomProcFunc, args);
	}
	
	public ArrayList <String> getArgumentos(String nomProcFunc) {
		return tablaDeArgumentos.get(nomProcFunc);
	}
	
	public String getTipoFuncion(String nomFunc) {
		return tablaTipo.get(nomFunc);
	}
	
	public void setTipoFuncion(String nomFunc, String tipo) {
		tablaTipo.put(nomFunc, tipo);
	}
	
	public void setLineaProcFunc(String nomProcFunc, Integer linea) {
		tablaProcFunc.put(nomProcFunc, linea);
	}
	
	public Integer getLineaProcFunc(String nomProcFunc) {
		return tablaProcFunc.get(nomProcFunc);
	}
	/*
	 * TODO:
	 * 1. Crear lista con las lineas de codigo donde la variable es usada.
	 * */
}
