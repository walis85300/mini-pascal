package ast;

public class NodoCallFuncion extends NodoBase{
	
	private String name_function;
	private NodoBase args;
	
	public NodoCallFuncion()
	{
		super();
		this.name_function = "";
		this.args = null;
	}
	
	public NodoCallFuncion(String name_function)
	{
		super();
		this.name_function = name_function;
		this.args = null;
	}
	
	public NodoCallFuncion(String name_function, NodoBase args)
	{
		super();
		this.name_function = name_function;
		this.args = args;
	}

	public String getName_function() {
		return name_function;
	}

	public void setName_function(String name_function) {
		this.name_function = name_function;
	}

	public NodoBase getArgs() {
		return args;
	}

	public void setArgs(NodoBase args) {
		this.args = args;
	}
	
}
