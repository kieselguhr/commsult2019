package realsimulator;

import abstracts.Sensor;
import models.EnvironmentVariable;
import models.TemperatureActor;
import models.TemperatureSensor;

public class MainController {



    public void run(){

        TemperatureActor ac = new TemperatureActor();
        TemperatureSensor outsideTemperature = new TemperatureSensor(30);

        EnvironmentVariable insideTemperature = new EnvironmentVariable(18, "Inside Temperature","celcius", ac, outsideTemperature);

        for(int i = 0;i < 10;i++){
            if(i == 5){
                outsideTemperature.setValue(40);
            }
            if(i == 7){
                ac.setTemperature(16);
            }
            System.out.println(makePrint(insideTemperature) + "\t" + makePrint(outsideTemperature) +"\t" +ac.prepareMessage());
            insideTemperature.affectValue();
        }

    }

    String makePrint(EnvironmentVariable ev){
        return ev.getTAG() + " : " + ev.getValue() + " " + ev.getUnit();
    }
    String makePrint(Sensor sensor){
        return sensor.getTAG() + " : " + sensor.getValue() + " " + sensor.getUnit();
    }

}
