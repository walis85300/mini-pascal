package ast;

public class NodoProgram extends NodoBase{
	
	private String name_program;
	private NodoBase body_program;
	
	public NodoProgram()
	{
		super();
		this.name_program = "";
		this.body_program = null;
	}
	
	public NodoProgram(String name_program, NodoBase body_program)
	{
		super();
		this.name_program = name_program;
		this.body_program = body_program;
	}

	public String getName_program() {
		return name_program;
	}

	public void setName_program(String name_program) {
		this.name_program = name_program;
	}

	public NodoBase getBody_program() {
		return body_program;
	}

	public void setBody_program(NodoBase body_program) {
		this.body_program = body_program;
	}

}
