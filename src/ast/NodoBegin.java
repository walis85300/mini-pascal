package ast;

public class NodoBegin extends NodoBase{
	
	private NodoBase body_begin;
	
	public NodoBegin()
	{
		super();
		this.body_begin = null;
	}
	
	public NodoBegin(NodoBase body_begin)
	{
		super();
		this.body_begin = body_begin;
	}

	public NodoBase getBody_begin() {
		return body_begin;
	}

	public void setBody_begin(NodoBase body_begin) {
		this.body_begin = body_begin;
	}

}
