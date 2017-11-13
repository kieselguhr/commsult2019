package models;

import abstracts.Actor;
import abstracts.Sensor;

public class EnvironmentVariable {
	
	int value;
	String unit;
	String TAG;

	Actor actor;
	Sensor sensor;

	public EnvironmentVariable(int value, String TAG, String unit, Actor actor, Sensor sensor) {
		this.value = value;
		this.unit = unit;
		this.actor = actor;
		this.sensor = sensor;
		this.TAG = TAG;
	}

	public void affectValue(){
		this.value = sensor.effectEnvironment(value);
		this.value = actor.effectEnvironment(value);
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
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

	public String getTAG() {
		return TAG;
	}

	public void setTAG(String TAG) {
		this.TAG = TAG;
	}
}
