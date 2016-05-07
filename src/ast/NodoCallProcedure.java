package ast;

public class NodoCallProcedure extends NodoBase{
	
	private String name_procedure;
	private NodoBase args;
	private int numbers_args;
	
	public NodoCallProcedure()
	{
		super();
		this.name_procedure = "";
		this.args = null;
		this.numbers_args = 0;
	}

	public NodoCallProcedure(String name_procedure)
	{
		super();
		this.name_procedure = name_procedure;
		this.args = null;
		this.numbers_args = 0;
	}
	
	public NodoCallProcedure(String name_procedure, NodoBase args, int numbers_args)
	{
		super();
		this.name_procedure = name_procedure;
		this.args = args;
		this.numbers_args = numbers_args;
	}

	public String getName_procedure() {
		return name_procedure;
	}

	public void setName_procedure(String name_procedure) {
		this.name_procedure = name_procedure;
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
