package ast;

public class NodoMain extends NodoBase{
	
	private NodoBase vars;
	private NodoBase functions;
	private NodoBase procedure;
	private NodoBase body;
	
	public NodoMain()
	{
		super();
		this.vars = null;
		this.functions = null;
		this.procedure = null;
		this.body = null;
	}
	
	public NodoMain(NodoBase vars, NodoBase functions, NodoBase procedure, NodoBase body)
	{
		super();
		this.vars = vars;
		this.functions = functions;
		this.procedure = procedure;
		this.body = body;
	}

	public NodoBase getVars() {
		return vars;
	}

	public void setVars(NodoBase vars) {
		this.vars = vars;
	}

	public NodoBase getFunctions() {
		return functions;
	}

	public void setFunctions(NodoBase functions) {
		this.functions = functions;
	}

	public NodoBase getProcedure() {
		return procedure;
	}

	public void setProcedure(NodoBase procedure) {
		this.procedure = procedure;
	}

	public NodoBase getBody() {
		return body;
	}

	public void setBody(NodoBase body) {
		this.body = body;
	}

}
