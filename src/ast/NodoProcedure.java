package ast;

public class NodoProcedure extends NodoBase{
	
	private String name_procedure;
	private NodoBase args;
	private NodoBase body_procedure;
	private int numbers_args;
	
	public NodoProcedure()
	{
		super();
		this.name_procedure = "";
		this.args = null;
		this.body_procedure = null;
		this.numbers_args = 0;
	}
	
	public NodoProcedure(String name_procedure)
	{
		super();
		this.name_procedure = name_procedure;
		this.args = null;
		this.body_procedure = null;
		this.numbers_args = 0;
	}
	
	public NodoProcedure(String name_procedure, NodoBase body_procedure)
	{
		super();
		this.name_procedure = name_procedure;
		this.args = null;
		this.body_procedure = body_procedure;
		this.numbers_args = 0;
	}
	
	public NodoProcedure(String name_procedure, NodoBase body_procedure, NodoBase args, int number_args)
	{
		super();
		this.name_procedure = name_procedure;
		this.args = args;
		this.body_procedure = body_procedure;
		this.numbers_args = number_args;
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

	public NodoBase getBody_procedure() {
		return body_procedure;
	}

	public void setBody_procedure(NodoBase body_procedure) {
		this.body_procedure = body_procedure;
	}

	public int getNumbers_args() {
		return numbers_args;
	}

	public void setNumbers_args(int numbers_args) {
		this.numbers_args = numbers_args;
	}
	
}
