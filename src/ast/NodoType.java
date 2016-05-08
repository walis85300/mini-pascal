package ast;

public class NodoType extends NodoBase {
	private String tipo;
	
	public NodoType(String tipo) {
		super();
		this.tipo = tipo;
	} 

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
