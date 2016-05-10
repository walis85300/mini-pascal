package ast;

public class NodoArray extends NodoVar{
	
	private Integer RIndex;
	private Integer LIndex;
	
	public NodoArray()
	{
		super();
		this.RIndex = null;
		this.LIndex = null;
	}
	
	public NodoArray(Integer LIndex, Integer RIndex)
	{
		super();
		this.RIndex = RIndex;
		this.LIndex = LIndex;
	}

	public Integer getRIndex() {
		return RIndex;
	}

	public void setRIndex(Integer rIndex) {
		RIndex = rIndex;
	}

	public Integer getLIndex() {
		return LIndex;
	}

	public void setLIndex(Integer lIndex) {
		LIndex = lIndex;
	}
}