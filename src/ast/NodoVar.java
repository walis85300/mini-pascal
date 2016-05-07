package ast;

public class NodoVar extends NodoBase{
	
	private String name_var;
	private String type_var;
	
	public NodoVar()
	{
		super();
		this.name_var = "";
		this.type_var = "";
	}
	
	public NodoVar(String name_var, String type_var)
	{
		super();
		this.name_var = name_var;
		this.type_var = type_var;
	}

	public String getName_var() {
		return name_var;
	}

	public void setName_var(String name_var) {
		this.name_var = name_var;
	}

	public String getType_var() {
		return type_var;
	}

	public void setType_var(String type_var) {
		this.type_var = type_var;
	}

}
