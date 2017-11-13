package models;

import abstracts.Actor;

public class TemperatureActor extends Actor {

    public static final int STARTING_TEMPERATURE = 18;

    int temperature = STARTING_TEMPERATURE;

    public int effectEnvironment(int value) {
        return (value + temperature) / 2;
    }

    public String prepareMessage() {
        return "A/C : " + temperature;

    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
