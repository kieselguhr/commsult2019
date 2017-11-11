package abstracts;

public class EnvironmentVariable {
	
	int value;
	String unit;
	
	public EnvironmentVariable(int value, String unit) {
		super();
		this.value = value;
		this.unit = unit;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
}
