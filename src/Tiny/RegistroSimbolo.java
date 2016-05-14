package Tiny;

public class RegistroSimbolo {
	private String identificador;
	private String tipo;
	private int NumLinea;
	private int DireccionMemoria;
	private boolean array;
	private int tamano;
	
	public RegistroSimbolo(String identificador, int numLinea, int direccionMemoria, String tipo, boolean array, int tamano) {
		super();
		this.identificador = identificador;
		this.tipo = tipo;
		this.NumLinea = numLinea;
		this.DireccionMemoria = direccionMemoria;
		this.array = array;
		this.tamano = tamano;
	}

	public String getIdentificador() {
		return identificador;
	}

	public int getNumLinea() {
		return NumLinea;
	}
	
	public String getTipo(){
		return tipo;
	}
	
	public int getTamano() {
		return tamano;
	}

	public int getDireccionMemoria() {
		return DireccionMemoria;
	}

	public void setDireccionMemoria(int direccionMemoria) {
		DireccionMemoria = direccionMemoria;
	}
}
