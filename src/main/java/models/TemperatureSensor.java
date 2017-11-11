package models;

import abstracts.Sensor;

public class TemperatureSensor extends Sensor{

    public TemperatureSensor(int value) {
        super("Outside Temperature", "celcius", value);
    }

    public int effectEnviroment(int value) {
        return (value + this.getValue())/2;
    }

    public TemperatureSensor(String TAG, String unit, int value) {
        super(TAG, unit, value);
    }

    public TemperatureSensor(){
        super("Outside Temperature", "celcius", 30);
    }

    public void effectEnvironment() {

    }

    public int effectEnvironment(int value) {
        return 0;
    }
}
