package ast;

public class NodoFuncion extends NodoBase{
	
	private String type_function;
	private String name_function;
	private NodoBase args;
	private NodoBase body_function;
	private int number_args;
	
	public NodoFuncion()
	{
		super();
		this.type_function = "";
		this.name_function = "";
		this.args = null;
		this.body_function = null;
		this.number_args = 0;
	}
	
	public NodoFuncion(String type_function, String name_function)
	{
		super();
		this.type_function = type_function;
		this.name_function = name_function;
		this.args = null;
		this.body_function = null;
		this.number_args = 0;
	}
	
	public NodoFuncion(String type_function, String name_function, NodoBase body_function)
	{
		super();
		this.type_function = type_function;
		this.name_function = name_function;
		this.args = null;
		this.body_function = body_function;
		this.number_args = 0;
	}
	
	public NodoFuncion(String type_function, String name_function, NodoBase args, int number_args)
	{
		super();
		this.type_function = type_function;
		this.name_function = name_function;
		this.args = args;
		this.body_function = null;
		this.number_args = number_args;
	}
	
	public NodoFuncion(String type_function, String name_function, NodoBase args, int number_args, NodoBase body_function)
	{
		super();
		this.type_function = type_function;
		this.name_function = name_function;
		this.args = args;
		this.body_function = body_function;
		this.number_args = number_args;
	}

	public String getType_function() {
		return type_function;
	}

	public void setType_function(String type_function) {
		this.type_function = type_function;
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

	public NodoBase getBody_function() {
		return body_function;
	}

	public void setBody_function(NodoBase body_function) {
		this.body_function = body_function;
	}

	public int getNumber_args() {
		return number_args;
	}

	public void setNumber_args(int number_args) {
		this.number_args = number_args;
	}
		
}
