package Tiny;

import java.io.*;

import ast.*;
import java_cup.runtime.*;

public class Compilador {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("deprecation")
		SymbolFactory sf = new DefaultSymbolFactory();
		
		if (args.length == 0) {
			// cuando no se pasa la ruta del codigo fuente
			System.out.println("nada");
		} else {		
			System.out.println("sdfsdf");
			Scanner s = new Scanner(new java.io.FileInputStream(args[0]),sf);
		}
		
	}

}
