package realsimulator;

import abstracts.Sensor;
import com.sun.org.apache.xpath.internal.SourceTree;
import models.*;

import javax.sound.midi.Soundbank;

public class MainController {


    private static final int STARTING_TEMPERATURE = 18 ;
    private static final int STARTING_WINDSPEED = 5;

    public void run(){

        GameTime gt = new GameTime(1000);

        TemperatureActor ac = new TemperatureActor();
        TemperatureSensor outsideTemperature = new TemperatureSensor(STARTING_TEMPERATURE);

        EnvironmentVariable insideTemperature = new EnvironmentVariable(18, "Inside Temperature","celcius", ac, outsideTemperature);
        
        WindActor walls = new WindActor();
        WindSensor outsideWindSpeed = new WindSensor(STARTING_WINDSPEED);

        EnvironmentVariable wallDurability = new EnvironmentVariable(100, "Wall Durability","%" ,walls, outsideWindSpeed);
        
        for(int i = 0;i < 10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i == 5){
                outsideTemperature.setValue(40);
                outsideWindSpeed.setValue(30);
            }
            if(i == 7){
                walls.setWallType(WindActor.WALLTYPE_STICK);
                ac.setTemperature(16);
            }

            gt.printTime();
            System.out.println(makePrint(insideTemperature) + "\t" + makePrint(outsideTemperature) +"\t" +ac.prepareMessage());
            System.out.println(makePrint(wallDurability) + "\t"+ makePrint(outsideWindSpeed)+"\t"+walls.prepareMessage());
            System.out.println();

            insideTemperature.affectValue();
            wallDurability.affectValue();
            gt.progress();
        }

    }

    String makePrint(EnvironmentVariable ev){
        return ev.getTAG() + " : " + ev.getValue() + " " + ev.getUnit();
    }
    String makePrint(Sensor sensor){
        return sensor.getTAG() + " : " + sensor.getValue() + " " + sensor.getUnit();
    }

}
