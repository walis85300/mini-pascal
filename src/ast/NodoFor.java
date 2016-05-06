package ast;

public class NodoFor extends NodoBase{
	
	private NodoBase variable;
	private NodoBase valorInicial;
	private NodoBase valorFinal;
	private NodoBase cuerpo;
	
	public NodoFor(){
		super();
		this.variable = null;
		this.valorInicial = null;
		this.valorFinal = null;
		this.cuerpo = null;
	}
	
	public NodoFor(NodoBase variable, NodoBase valorInicial, NodoBase valorFinal, NodoBase cuerpo){
		super();
		this.variable = variable;
		this.valorInicial = valorInicial;
		this.valorFinal = valorFinal;
		this.cuerpo = cuerpo;
	}

	public NodoBase getVariable() {
		return variable;
	}

	public void setVariable(NodoBase variable) {
		this.variable = variable;
	}

	public NodoBase getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(NodoBase valorInicial) {
		this.valorInicial = valorInicial;
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
