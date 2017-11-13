package models;

import abstracts.Sensor;

public class WindSensor extends Sensor{

    public int effectEnvironment(int value) {
        return value - this.getValue();
    }

    public WindSensor(String TAG, String unit, int value) {
        super(TAG, unit, value);
    }

    public WindSensor(int value){
        super("Outside Windspeed", "kph", value);
    }

}
