package ast;

public class NodoFor extends NodoBase{
	
	private NodoBase asignacion;
	private NodoBase valorFinal;
	private NodoBase cuerpo;
	
	public NodoFor(){
		super();
		this.asignacion = null;
		this.valorFinal = null;
		this.cuerpo = null;
	}
	
	public NodoFor(NodoBase asignacion, NodoBase valorFinal, NodoBase cuerpo){
		super();
		this.asignacion = asignacion;
		this.valorFinal = valorFinal;
		this.cuerpo = cuerpo;
	}

	public NodoBase getVariable() {
		return asignacion;
	}

	public void setVariable(NodoBase asignacion) {
		this.asignacion = asignacion;
	}

	public NodoBase getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(NodoBase valorFinal) {
		this.valorFinal = valorFinal;
	}

	public NodoBase getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(NodoBase cuerpo) {
		this.cuerpo = cuerpo;
	}
	
	

}
