package Tiny;

import ast.*;

import java.util.*;

public class Generador {
	/* Ilustracion de la disposicion de la memoria en
	 * este ambiente de ejecucion para el lenguaje Tiny
	 *
	 * |t1	|<- mp (Maxima posicion de memoria de la TM
	 * |t1	|<- desplazamientoTmp (tope actual)
	 * |free|
	 * |free|
	 * |...	|
	 * |x	|
	 * |y	|<- gp
	 * 
	 * */
	
	
	
	/* desplazamientoTmp es una variable inicializada en 0
	 * y empleada como el desplazamiento de la siguiente localidad
	 * temporal disponible desde la parte superior o tope de la memoria
	 * (la que apunta el registro MP).
	 * 
	 * - Se decrementa (desplazamientoTmp--) despues de cada almacenamiento y
	 * 
	 * - Se incrementa (desplazamientoTmp++) despues de cada eliminacion/carga en 
	 *   otra variable de un valor de la pila.
	 * 
	 * Pudiendose ver como el apuntador hacia el tope de la pila temporal
	 * y las llamadas a la funcion emitirRM corresponden a una inserccion 
	 * y extraccion de esta pila
	 */
	private static int desplazamientoTmp = 0;
	private static TablaSimbolos tablaSimbolos = null;
	private static int LineaMain;
	private static boolean GenerarCuerpoMain = false;
	private static ArrayList<Integer> returns = new ArrayList<Integer>();
	private static String nombreProcFunc;
	
	public static void setTablaSimbolos(TablaSimbolos tabla){
		tablaSimbolos = tabla;
	}
	
	public static void generarCodigoObjeto(NodoBase raiz){
		System.out.println();
		System.out.println();
		System.out.println("------ CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------");
		System.out.println();
		System.out.println();
		generarPreludioEstandar();
		generar(raiz, true);
		/*Genero el codigo de finalizacion de ejecucion del codigo*/   
		UtGen.emitirComentario("Fin de la ejecucion.");
		UtGen.emitirRO("HALT", 0, 0, 0, "");
		System.out.println();
		System.out.println();
		System.out.println("------ FIN DEL CODIGO OBJETO DEL LENGUAJE TINY GENERADO PARA LA TM ------");
	}
	
	//Funcion principal de generacion de codigo
	//prerequisito: Fijar la tabla de simbolos antes de generar el codigo objeto 
	private static void generar(NodoBase nodo, boolean generarHermanoDerecho){
	if(tablaSimbolos!=null){
		if (nodo instanceof  NodoProgram){
			generarProgram(nodo);
		}else if (nodo instanceof  NodoMain){
			//if(((NodoMain)nodo).getVars() != null)
				//generar(((NodoMain)nodo).getVars());
			if(((NodoMain)nodo).getFunctions() != null)
				generar(((NodoMain)nodo).getFunctions(),true);
			if(((NodoMain)nodo).getProcedure() != null)
				generar(((NodoMain)nodo).getProcedure(), true);
			
			GenerarCuerpoMain = true;
			generarCuerpo(nodo);
		}else if (nodo instanceof  NodoBegin){
			generarBegin(nodo);
		}else if (nodo instanceof  NodoFor){
			generarFor(nodo);
		}else if (nodo instanceof  NodoVar){
		}else if (nodo instanceof NodoProcedure){
			generarProcedure(nodo);
		}else if(nodo instanceof NodoCallFuncion){
			generarLlamado(nodo);
		}else if (nodo instanceof NodoReturn){
			generarReturn(nodo);
		}else if (nodo instanceof  NodoIf){
			generarIf(nodo);
		}else if (nodo instanceof  NodoRepeat){
			generarRepeat(nodo);
		}else if (nodo instanceof  NodoWhile){
			generarWhile(nodo);
		}else if (nodo instanceof  NodoDoWhile){
			generarDoWhile(nodo);					
		}else if (nodo instanceof  NodoAsignacion){
			generarAsignacion(nodo);
		}else if (nodo instanceof  NodoLeer){
			generarLeer(nodo);
		}else if (nodo instanceof  NodoEscribir){
			generarEscribir(nodo);
		}else if (nodo instanceof NodoValor){
			generarValor(nodo);
		}else if (nodo instanceof NodoIdentificador){
			generarIdentificador(nodo);
		}else if (nodo instanceof NodoOperacion){
			generarOperacion(nodo);
		}else if (nodo instanceof NodoReturn){
			generarReturn(nodo);		
		}else if (nodo instanceof NodoFuncion){
			generarFuncion(nodo);
		}/*else if (nodo instanceof NodoCallFuncion){
			generarCallFuncion(nodo);	
		}*/else{
			System.out.println("BUG: Tipo de nodo a generar desconocido");
		}
		/*Si el hijo de extrema izquierda tiene hermano a la derecha lo genero tambien*/
		if(nodo.TieneHermano())
			if (generarHermanoDerecho)
				generar(nodo.getHermanoDerecha(),true);
	}else
		System.out.println("���ERROR: por favor fije la tabla de simbolos a usar antes de generar codigo objeto!!!");
}
	private static void generarProgram(NodoBase nodo){
		generar(((NodoProgram)nodo).getBody_program(), true);
	}
	private static void generarCuerpo(NodoBase nodo){
		generar(((NodoMain)nodo).getBody(), true);
	}
	private static void generarBegin(NodoBase nodo){
		if(GenerarCuerpoMain){
			int posicionAComenzar = UtGen.emitirSalto(0);
			UtGen.cargarRespaldo(LineaMain);
			UtGen.emitirRM("LDA", UtGen.PC, posicionAComenzar, UtGen.GP, "Salto incondicional al main del programa");
			UtGen.restaurarRespaldo();
			GenerarCuerpoMain = false;
			generar(((NodoBegin)nodo).getBody_begin(), true);
		} else {
			generar(((NodoBegin)nodo).getBody_begin(), true);
		}
	}
	private static void generarProcedure(NodoBase nodo){
		
		 nombreProcFunc=((NodoProcedure)nodo).getName_procedure();
		 int pos=UtGen.emitirSalto(0);
		 tablaSimbolos.setLineaProcFunc(nombreProcFunc, pos);
		 
		NodoProcedure n = (NodoProcedure)nodo;
		if(UtGen.debug)	UtGen.emitirComentario("-> Procedure");
		if(n.getBody_procedure()!= null)
			generar(n.getBody_procedure(), true);
		//Salto incondicional a donde quede
		UtGen.emitirRM("LDA", UtGen.PC, 0,UtGen.NL, "Salto incodicional a donde fue llamado el procedimiento");
	}
	private static void generarFuncion(NodoBase nodo){
		
		nombreProcFunc=((NodoFuncion)nodo).getName_function();
	    int pos=UtGen.emitirSalto(0);
		tablaSimbolos.setLineaProcFunc(nombreProcFunc, pos);
		
		NodoFuncion n = (NodoFuncion)nodo;
		if(UtGen.debug)	UtGen.emitirComentario("-> Funcion");
		if(n.getBody_function()!= null)
			generar(n.getBody_function(), true);
		
		pos = UtGen.emitirSalto(0);
		
		for(int i=0; i<returns.size(); i++){
			UtGen.cargarRespaldo(returns.get(i));
			UtGen.emitirRM("LDA", UtGen.PC, pos, UtGen.GP, "returns");
			UtGen.restaurarRespaldo();
		}
		
		returns.clear();
		
		//Salto incondicional a donde quede
		UtGen.emitirRM("LDA", UtGen.PC, 0,UtGen.NL, "Salto incodicional a donde fue llamada la funcion");
	}
	private static void generarCallFuncion(NodoBase nodo){
		if(UtGen.debug)	UtGen.emitirComentario("-> CALLLLL");
		 nombreProcFunc=((NodoFuncion)nodo).getName_function();
		 int pos=UtGen.emitirSalto(0);
		 tablaSimbolos.setLineaProcFunc(nombreProcFunc, pos);
		 
		tablaSimbolos.ImprimirClaves();
		NodoCallFuncion n = (NodoCallFuncion)nodo;
		if(UtGen.debug)	UtGen.emitirComentario("-> llamando Funcion");
		String nombre = n.getName_function();
		
		if (n.getArgs()!=null){	
			ArrayList<String> lista = tablaSimbolos.getArgumentos(nombre);
			for(String nom: lista) {
				System.out.println(nom);
			}
		}
		UtGen.debug = false;
		//Salto incondicional a donde quede
		UtGen.emitirRM("LDA", UtGen.PC, 0,UtGen.NL, "Salto incodicional a donde fue llamada la funcion");
	}
	private static void generarLlamado(NodoBase nodo){
		//cargar las variables
		NodoCallFuncion n = (NodoCallFuncion)nodo;
		String nombre = n.getName_function();
		
		if (n.getArgs()!=null){	
			ArrayList<String> lista = tablaSimbolos.getArgumentos(nombre);
			nodo = n.getArgs();
			for(String nom: lista) {
				generar(nodo, false);
				int dirMem = tablaSimbolos.getDireccion(nom);
				UtGen.emitirRM("ST", UtGen.AC, dirMem, UtGen.GP, "llamado: guarda el valor del argumento");	
				nodo = nodo.getHermanoDerecha();
			}
		}	
		//Poner en NL la linea actual + 1*/
		if(UtGen.debug)	UtGen.emitirComentario("-> CALLLLL");
		UtGen.emitirRM("LDA", UtGen.NL, 1, UtGen.PC, "");
		
		//saltar a la linea donde empieza la funcion
		int pos = tablaSimbolos.getLineaProcFunc(((NodoCallFuncion)n).getName_function());
		UtGen.emitirRM("LDA", UtGen.PC, pos,UtGen.GP, "Salto a la primera linea de la funcion");
	}
	private static void generarReturn(NodoBase nodo){
		if(((NodoReturn)nodo).getExp()!=null)
		       generar(((NodoReturn)nodo).getExp(), true);
		//la setencia anterior deja en AC el valor retornado		
		//Guargo una posicion para saltar a la linea donde termina la funcion
		returns.add(UtGen.emitirSalto(1));

	}
	private static void generarIf(NodoBase nodo){
    	NodoIf n = (NodoIf)nodo;
		int localidadSaltoElse,localidadSaltoEnd,localidadActual;
		if(UtGen.debug)	UtGen.emitirComentario("-> if");
		/*Genero el codigo para la parte de prueba del IF*/
		generar(n.getPrueba(), true);
		localidadSaltoElse = UtGen.emitirSalto(1);
		UtGen.emitirComentario("If: el salto hacia el else debe estar aqui");
		/*Genero la parte THEN*/
		generar(n.getParteThen(), true);
		localidadSaltoEnd = UtGen.emitirSalto(1);
		UtGen.emitirComentario("If: el salto hacia el final debe estar aqui");
		localidadActual = UtGen.emitirSalto(0);
		UtGen.cargarRespaldo(localidadSaltoElse);
		UtGen.emitirRM_Abs("JEQ", UtGen.AC, localidadActual, "if: jmp hacia else");
		UtGen.restaurarRespaldo();
		/*Genero la parte ELSE*/
		if(n.getParteElse()!=null){
			generar(n.getParteElse(), true);
			localidadActual = UtGen.emitirSalto(0);
			UtGen.cargarRespaldo(localidadSaltoEnd);
			UtGen.emitirRM_Abs("LDA", UtGen.PC, localidadActual, "if: jmp hacia el final");
			UtGen.restaurarRespaldo();
    	}
		
		if(UtGen.debug)	UtGen.emitirComentario("<- if");
	}
	
	private static void generarRepeat(NodoBase nodo){
    	NodoRepeat n = (NodoRepeat)nodo;
		int localidadSaltoInicio;
		if(UtGen.debug)	UtGen.emitirComentario("-> repeat");
			localidadSaltoInicio = UtGen.emitirSalto(0);
			UtGen.emitirComentario("repeat: el salto hacia el final (luego del cuerpo) del repeat debe estar aqui");
			/* Genero el cuerpo del repeat */
			generar(n.getCuerpo(), true);
			/* Genero el codigo de la prueba del repeat */
			generar(n.getPrueba(), true);
			UtGen.emitirRM_Abs("JEQ", UtGen.AC, localidadSaltoInicio, "repeat: jmp hacia el inicio del cuerpo");
		if(UtGen.debug)	UtGen.emitirComentario("<- repeat");
	}
	
	private static void generarWhile(NodoBase nodo){ 
    	NodoWhile n = (NodoWhile)nodo;
		int localidadSaltoInicio,localidadSaltoCondicional,localidadActual;
		/* Genero el codigo de la prueba del while */
		if(UtGen.debug)	UtGen.emitirComentario("-> while");
		localidadSaltoInicio = UtGen.emitirSalto(0);
		UtGen.emitirComentario("while: aqui deberia ir el marcado del inicio del while");
		generar(n.getPrueba(), true);
		localidadSaltoCondicional = UtGen.emitirSalto(1);
		if(UtGen.debug)	UtGen.emitirComentario("-> cuerpo while");
		/* Genero el cuerpo del while */
		generar(n.getCuerpo(), true);
		//Salto al Inicio del while
		UtGen.emitirRM_Abs("LDA", UtGen.PC, localidadSaltoInicio, "if: jmp hacia el final");
		
		//Salto si el while es falso (0) salto al fin
		localidadActual = UtGen.emitirSalto(0);
		UtGen.cargarRespaldo(localidadSaltoCondicional);
		UtGen.emitirRM_Abs("JEQ", UtGen.AC, localidadActual, "if: jmp hacia fin del while si falso (0)");
		UtGen.restaurarRespaldo();
 
	}
	
	private static void generarDoWhile(NodoBase nodo){ 
    	NodoDoWhile n = (NodoDoWhile)nodo;
		int localidadInicioCiclo;
		/* Genero el codigo de la prueba del while */
		if(UtGen.debug)	UtGen.emitirComentario("-> while");
		localidadInicioCiclo = UtGen.emitirSalto(0);
		UtGen.emitirComentario("while: aqui deberia ir el marcado del inicio del while");
		generar(n.getCuerpo(), true);
		generar(n.getPrueba(), true);
		UtGen.emitirRM_Abs("JNE", UtGen.AC, localidadInicioCiclo, "do while: jmp hacia el inicio");
	}		

	private static void generarFor(NodoBase nodo){ 
    	NodoFor n = (NodoFor)nodo;
    	int localidadSaltoInicio,localidadFinal,localidadActual;
    	/* Genero el codigo de la prueba del while */
		if(UtGen.debug)	UtGen.emitirComentario("-> while");
		generar(n.getVariable(), true);
		localidadSaltoInicio = UtGen.emitirSalto(0);
		
			generar(n.getCuerpo(), true);
			UtGen.emitirComentario("while: aqui deberia ir el marcado del inicio del while");
			UtGen.emitirRM("LDC", UtGen.AC, 1, 0, "cargar constante: 1");
			UtGen.emitirRM("LD", UtGen.AC1, ++desplazamientoTmp, UtGen.GP, "op: pop o cargo de la pila el valor izquierdo en AC1");
			UtGen.emitirRO("ADD", UtGen.AC1, UtGen.AC1, UtGen.AC, "op: +");	
			UtGen.emitirRM("ST", UtGen.AC1, 1, UtGen.GP, "leer: almaceno el valor entero leido en el id ");
			generar(n.getValorFinal(), true);
			UtGen.emitirRO("SUB", UtGen.AC, UtGen.AC1, UtGen.AC, "op: ==");
			UtGen.emitirRM("JEQ", UtGen.AC, 2, UtGen.PC, "voy dos instrucciones mas alla if verdadero (AC==0)");
			UtGen.emitirRM("LDC", UtGen.AC, 1, UtGen.AC, "caso de falso (AC=0)");
			UtGen.emitirRM("LDA", UtGen.PC, 1, UtGen.PC, "Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)");
			UtGen.emitirRM("LDC", UtGen.AC, 0, UtGen.AC, "caso de verdadero (AC=1)");
		localidadFinal = UtGen.emitirSalto(1);
		//if(UtGen.debug)	UtGen.emitirComentario("-> cuerpo for");
		/* Genero el cuerpo del for */
		
		//Salto al Inicio del for
		UtGen.emitirRM_Abs("LDA", UtGen.PC, localidadSaltoInicio, "if: jmp hacia el final");
		//Salto si el while es falso (0) salto al fin
		localidadActual = UtGen.emitirSalto(0);
		UtGen.cargarRespaldo(localidadFinal);
		UtGen.emitirRM_Abs("JEQ", UtGen.AC, localidadActual, "if: jmp hacia fin del while si falso (0)");
		UtGen.restaurarRespaldo();
	}
	
	private static void generarAsignacion(NodoBase nodo){
		NodoAsignacion n = (NodoAsignacion)nodo;
		int direccion;
		if(UtGen.debug)	UtGen.emitirComentario("-> asignacion");		
		/* Genero el codigo para la expresion a la derecha de la asignacion */
		generar(n.getExpresion(), true);
		/* Ahora almaceno el valor resultante */
		direccion = tablaSimbolos.getDireccion(n.getIdentificador());
		UtGen.emitirRM("ST", UtGen.AC, direccion, UtGen.GP, "asignacion: almaceno el valor para el id "+n.getIdentificador());
		if(UtGen.debug)	UtGen.emitirComentario("<- asignacion");
	}
	
	private static void generarLeer(NodoBase nodo){
		NodoLeer n = (NodoLeer)nodo;
		int direccion;
		if(UtGen.debug)	UtGen.emitirComentario("-> leer");
		UtGen.emitirRO("IN", UtGen.AC, 0, 0, "leer: lee un valor entero ");
		direccion = tablaSimbolos.getDireccion(n.getIdentificador());
		UtGen.emitirRM("ST", UtGen.AC, direccion, UtGen.GP, "leer: almaceno el valor entero leido en el id "+n.getIdentificador());
		if(UtGen.debug)	UtGen.emitirComentario("<- leer");
	}
	
	private static void generarEscribir(NodoBase nodo){
		NodoEscribir n = (NodoEscribir)nodo;
		if(UtGen.debug)	UtGen.emitirComentario("-> escribir");
		/* Genero el codigo de la expresion que va a ser escrita en pantalla */
		generar(n.getExpresion(), true);
		/* Ahora genero la salida */
		UtGen.emitirRO("OUT", UtGen.AC, 0, 0, "escribir: genero la salida de la expresion");
		if(UtGen.debug)	UtGen.emitirComentario("<- escribir");
	}
	
	private static void generarValor(NodoBase nodo){
    	NodoValor n = (NodoValor)nodo;
    	if(UtGen.debug)	UtGen.emitirComentario("-> constante");
    	UtGen.emitirRM("LDC", UtGen.AC, n.getValor(), 0, "cargar constante: "+n.getValor());
    	if(UtGen.debug)	UtGen.emitirComentario("<- constante");
	}
	
	private static void generarIdentificador(NodoBase nodo){
		NodoIdentificador n = (NodoIdentificador)nodo;
		int direccion;
		if(UtGen.debug)	UtGen.emitirComentario("-> identificador");
		direccion = tablaSimbolos.getDireccion(n.getNombre());
		UtGen.emitirRM("LD", UtGen.AC, direccion, UtGen.GP, "cargar valor de identificador: "+n.getNombre());
		if(UtGen.debug)	UtGen.emitirComentario("-> identificador");
	}

	private static void generarOperacion(NodoBase nodo){
		NodoOperacion n = (NodoOperacion) nodo;
		if(UtGen.debug)	UtGen.emitirComentario("-> Operacion: " + n.getOperacion());
		
		generar(n.getOpIzquierdo(), true);
		/* Almaceno en la pseudo pila de valor temporales el valor de la operacion izquierda */
		UtGen.emitirRM("ST", UtGen.AC, desplazamientoTmp--, UtGen.MP, "op: push en la pila tmp el resultado expresion izquierda");
		/* Genero la expresion derecha de la operacion */
		generar(n.getOpDerecho(), true);
		/* Ahora cargo/saco de la pila el valor izquierdo */
		UtGen.emitirRM("LD", UtGen.AC1, ++desplazamientoTmp, UtGen.MP, "op: pop o cargo de la pila el valor izquierdo en AC1");
		switch(n.getOperacion()){
			case    or:
			case	mas:	UtGen.emitirRO("ADD", UtGen.AC, UtGen.AC1, UtGen.AC, "op: +");		
							break;
			case	menos:	UtGen.emitirRO("SUB", UtGen.AC, UtGen.AC1, UtGen.AC, "op: -");
							break;
			case    and:
			case	por:	UtGen.emitirRO("MUL", UtGen.AC, UtGen.AC1, UtGen.AC, "op: *");
							break;
			case	entre:	UtGen.emitirRO("DIV", UtGen.AC, UtGen.AC1, UtGen.AC, "op: /");
							break;		
			case	menor:	UtGen.emitirRO("SUB", UtGen.AC, UtGen.AC1, UtGen.AC, "op: <");
							UtGen.emitirRM("JLT", UtGen.AC, 2, UtGen.PC, "voy dos instrucciones mas alla if verdadero (AC<0)");
							UtGen.emitirRM("LDC", UtGen.AC, 0, UtGen.AC, "caso de falso (AC=0)");
							UtGen.emitirRM("LDA", UtGen.PC, 1, UtGen.PC, "Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)");
							UtGen.emitirRM("LDC", UtGen.AC, 1, UtGen.AC, "caso de verdadero (AC=1)");
							break;
			case menor_igual:UtGen.emitirRO("SUB", UtGen.AC, UtGen.AC1, UtGen.AC, "op: <=");
							UtGen.emitirRM("JLE", UtGen.AC, 2, UtGen.PC, "voy dos instrucciones mas alla if verdadero (AC<=0)");
							UtGen.emitirRM("LDC", UtGen.AC, 0, UtGen.AC, "caso de falso (AC=0)");
							UtGen.emitirRM("LDA", UtGen.PC, 1, UtGen.PC, "Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)");
							UtGen.emitirRM("LDC", UtGen.AC, 1, UtGen.AC, "caso de verdadero (AC=1)");
							break;
			case mayor_igual:UtGen.emitirRO("SUB", UtGen.AC, UtGen.AC1, UtGen.AC, "op: >=");
							UtGen.emitirRM("JGE", UtGen.AC, 2, UtGen.PC, "voy dos instrucciones mas alla if verdadero (AC>=0)");
							UtGen.emitirRM("LDC", UtGen.AC, 0, UtGen.AC, "caso de falso (AC=0)");
							UtGen.emitirRM("LDA", UtGen.PC, 1, UtGen.PC, "Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)");
							UtGen.emitirRM("LDC", UtGen.AC, 1, UtGen.AC, "caso de verdadero (AC=1)");
							break;
			case    mayor:	UtGen.emitirRO("SUB", UtGen.AC, UtGen.AC1, UtGen.AC, "op: >");
							UtGen.emitirRM("JGT", UtGen.AC, 2, UtGen.PC, "voy dos instrucciones mas alla if verdadero (AC>0)");
							UtGen.emitirRM("LDC", UtGen.AC, 0, UtGen.AC, "caso de falso (AC=0)");
							UtGen.emitirRM("LDA", UtGen.PC, 1, UtGen.PC, "Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)");
							UtGen.emitirRM("LDC", UtGen.AC, 1, UtGen.AC, "caso de verdadero (AC=1)");
							break;
			case  diferente:	UtGen.emitirRO("SUB", UtGen.AC, UtGen.AC1, UtGen.AC, "op: !=");
							UtGen.emitirRM("JNE", UtGen.AC, 2, UtGen.PC, "voy dos instrucciones mas alla if verdadero (AC!=0)");
							UtGen.emitirRM("LDC", UtGen.AC, 0, UtGen.AC, "caso de falso (AC=0)");
							UtGen.emitirRM("LDA", UtGen.PC, 1, UtGen.PC, "Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)");
							UtGen.emitirRM("LDC", UtGen.AC, 1, UtGen.AC, "caso de verdadero (AC=1)");
							break;
			case	igual:	UtGen.emitirRO("SUB", UtGen.AC, UtGen.AC1, UtGen.AC, "op: ==");
							UtGen.emitirRM("JEQ", UtGen.AC, 2, UtGen.PC, "voy dos instrucciones mas alla if verdadero (AC==0)");
							UtGen.emitirRM("LDC", UtGen.AC, 0, UtGen.AC, "caso de falso (AC=0)");
							UtGen.emitirRM("LDA", UtGen.PC, 1, UtGen.PC, "Salto incodicional a direccion: PC+1 (es falso evito colocarlo verdadero)");
							UtGen.emitirRM("LDC", UtGen.AC, 1, UtGen.AC, "caso de verdadero (AC=1)");
							break;	
			default:
							UtGen.emitirComentario("BUG: tipo de operacion desconocida");
		}
		if(UtGen.debug)	UtGen.emitirComentario("<- Operacion: " + n.getOperacion());
	}
	
	//TODO: enviar preludio a archivo de salida, obtener antes su nombre
	private static void generarPreludioEstandar(){
		UtGen.emitirComentario("Compilacion TINY para el codigo objeto TM");
		UtGen.emitirComentario("Archivo: "+ "NOMBRE_ARREGLAR");
		/*Genero inicializaciones del preludio estandar*/
		/*Todos los registros en tiny comienzan en cero*/
		UtGen.emitirComentario("Preludio estandar:");
		UtGen.emitirRM("LD", UtGen.MP, 0, UtGen.AC, "cargar la maxima direccion desde la localidad 0");
		UtGen.emitirRM("ST", UtGen.AC, 0, UtGen.AC, "limpio el registro de la localidad 0");
		
		/*	
		 * Luego de generar el preludio guarda la linea para luego generar un salgo incondicional
		 * hacia donde este declarado el main del programa*/
		LineaMain = UtGen.emitirSalto(1);
	}

}
