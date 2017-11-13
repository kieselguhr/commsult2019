package abstracts;

import interfaces.ISensor;

public abstract class Sensor implements ISensor{

	public abstract int effectEnvironment(int value);

	String TAG;
	String unit;
	int value;

	public Sensor(String TAG, String unit, int value) {
		this.TAG = TAG;
		this.unit = unit;
		this.value = value;
	}

	public String getTAG() {
		return TAG;
	}

	public void setTAG(String TAG) {
		this.TAG = TAG;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
