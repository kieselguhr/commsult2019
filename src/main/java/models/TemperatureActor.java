package models;

import abstracts.Actor;

public class TemperatureActor extends Actor {

    int temperature = 18;

    public int effectEnviroment(int value) {
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
