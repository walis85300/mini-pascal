package ast;

public class NodoValor extends NodoBase {
	private int valor;
	private int tipo;

	public NodoValor(int valor) {
		super();
		this.valor = valor;
		this.tipo = 0;
	}
	
	public NodoValor(int valor, int tipo) {
		super();
		this.valor = valor;
		this.tipo = tipo;
	}

	public NodoValor() {
		super();
	}
	
	public int getValor() {
		return valor;
	}
	
	public int getTipo(){
		return this.tipo;
	}

}
