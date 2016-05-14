package ast;

public class NodoLeer extends NodoBase {
	private String id;
	private NodoBase array;
	private NodoBase posArray;

	public NodoLeer(String identificador) {
		super();
		this.id = identificador;
	}
	
	public NodoLeer(NodoBase arr) {
		super();
		this.id = ((NodoIdentificador)arr).getNombre();
		this.array = arr;
		this.posArray = ((NodoIdentificador)arr).getExpresion();
	}

	public NodoLeer() {
		super();
		id="";
	}
	
	public NodoBase getPosArray() {
		return this.posArray;
	}

	public String getIdentificador() {
		return id;
	}

	public void setExpresion(String identificador) {
		this.id = identificador;
	}

}
