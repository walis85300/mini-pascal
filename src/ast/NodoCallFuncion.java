package ast;

public class NodoCallFuncion extends NodoBase{
	
	private String name_function;
	private NodoBase args;
	private int numbers_args;
	
	public NodoCallFuncion()
	{
		super();
		this.name_function = "";
		this.args = null;
		this.numbers_args = 0;
	}
	
	public NodoCallFuncion(String name_function)
	{
		super();
		this.name_function = name_function;
		this.args = null;
		this.numbers_args = 0;
	}
	
	public NodoCallFuncion(String name_function, NodoBase args, int numbers_args)
	{
		super();
		this.name_function = name_function;
		this.args = args;
		this.numbers_args = numbers_args;
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
	
	public int getNumbers_args() {
		return numbers_args;
	}

	public void setNumbers_args(int numbers_args) {
		this.numbers_args = numbers_args;
	}
	
}
