package ast;

public class NodoProgram extends NodoBase{
	
	private String name_program;
	private NodoBase vars;
	private NodoBase functions;
	private NodoBase procedures;
	private NodoBase body_program;
	
	public NodoProgram()
	{
		super();
		this.name_program = "";
		this.vars = null;
		this.functions = null;
		this.procedures = null;
		this.body_program = null;
	}
	
	public NodoProgram(String name_program)
	{
		super();
		this.name_program = name_program;
		this.vars = null;
		this.functions = null;
		this.procedures = null;
		this.body_program = null;
	}
	
	public NodoProgram(String name_program, NodoBase vars)
	{
		super();
		this.name_program = name_program;
		this.vars = vars;
		this.functions = null;
		this.procedures = null;
		this.body_program = null;
	}

	public NodoProgram(String name_program, NodoBase vars, NodoBase body_program)
	{
		super();
		this.name_program = name_program;
		this.vars = vars;
		this.functions = null;
		this.procedures = null;
		this.body_program = body_program;
	}

	public NodoProgram(String name_program, NodoBase vars, NodoBase functions, NodoBase body_program)
	{
		super();
		this.name_program = name_program;
		this.vars = vars;
		this.functions = functions;
		this.procedures = null;
		this.body_program = body_program;
	}
	
	public NodoProgram(String name_program, NodoBase vars, NodoBase functions, NodoBase procedures, NodoBase body_program)
	{
		super();
		this.name_program = name_program;
		this.vars = vars;
		this.functions = functions;
		this.procedures = procedures;
		this.body_program = body_program;
	}

	public String getName_program() {
		return name_program;
	}

	public void setName_program(String name_program) {
		this.name_program = name_program;
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

	public NodoBase getProcedures() {
		return procedures;
	}

	public void setProcedures(NodoBase procedures) {
		this.procedures = procedures;
	}

	public NodoBase getBody_program() {
		return body_program;
	}

	public void setBody_program(NodoBase body_program) {
		this.body_program = body_program;
	}
		
}
