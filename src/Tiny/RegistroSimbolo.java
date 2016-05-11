package Tiny;

public class RegistroSimbolo {
	private String identificador;
	private String tipo;
	private int NumLinea;
	private int DireccionMemoria;
	
	public RegistroSimbolo(String identificador, int numLinea, int direccionMemoria, String tipo) {
		super();
		this.identificador = identificador;
		this.tipo = tipo;
		this.NumLinea = numLinea;
		this.DireccionMemoria = direccionMemoria;
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

	public int getDireccionMemoria() {
		return DireccionMemoria;
	}

	public void setDireccionMemoria(int direccionMemoria) {
		DireccionMemoria = direccionMemoria;
	}
}
