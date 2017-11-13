package realsimulator;

import abstracts.Sensor;
import com.sun.org.apache.xpath.internal.SourceTree;
import models.*;

import javax.sound.midi.Soundbank;

public class MainController implements Runnable {


    public static final int STARTING_TEMPERATURE = 18 ;
    public static final int STARTING_WINDSPEED = 5;

    public MainViewer mv;

    public MainController(MainViewer mv){
        this.mv = mv;
    }

    EnvironmentVariable insideTemperature;
    EnvironmentVariable wallDurability;
    TimeVariable timeVariable = new TimeVariable();

    boolean autopilot;

    public boolean isAutopilot() {
        return autopilot;
    }

    public void setAutopilot(boolean autopilot) {
        this.autopilot = autopilot;
    }

    public void run(){

        GameTime gt = new GameTime(2300);

        mv.setSecurityLevel(timeVariable.determineSecurityLevel(gt.getTime()));
        timeVariable.setCurrentState(timeVariable.determineSecurityLevel(gt.getTime()));

        TemperatureActor ac = new TemperatureActor();
        TemperatureSensor outsideTemperature = new TemperatureSensor(STARTING_TEMPERATURE);

        insideTemperature = new EnvironmentVariable(18, "Inside Temperature","celcius", ac, outsideTemperature);
        
        WindActor walls = new WindActor();
        WindSensor outsideWindSpeed = new WindSensor(STARTING_WINDSPEED);

        wallDurability = new EnvironmentVariable(100, "Wall Durability","%" ,walls, outsideWindSpeed);

        int i = 0;

        while(true){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            gt.printTime();
            mv.setTime(gt.prepareString());
            mv.setInsideTemperature(insideTemperature.getValue()+"");
            mv.setDurabilityValue(wallDurability.getValue());

            mv.setSecurityLabel(timeVariable.isSafe(gt.getTime()));

            System.out.println(gt.prepareString());
            System.out.println(makePrint(insideTemperature) + "\t" + makePrint(outsideTemperature) +"\t" +ac.prepareMessage());
            System.out.println(makePrint(wallDurability) + "\t"+ makePrint(outsideWindSpeed)+"\t"+walls.prepareMessage());

            insideTemperature.affectValue();
            wallDurability.affectValue();
            gt.progress();
            i++;
        }

    }

    String makePrint(EnvironmentVariable ev){
        return ev.getTAG() + " : " + ev.getValue() + " " + ev.getUnit();
    }
    String makePrint(Sensor sensor){
        return sensor.getTAG() + " : " + sensor.getValue() + " " + sensor.getUnit();
    }


    public void setOutsideTemperature(int fps) {
        insideTemperature.getSensor().setValue(fps);
    }

    public void setACTemperature(int fps){
        ( (TemperatureActor) insideTemperature.getActor() ).setTemperature(fps);
    }

    public void setOutsideWindSpeed(int fps){
        wallDurability.getSensor().setValue(fps);
    }

    public void setWallDurability(int fps){
        ((WindActor) wallDurability.getActor()).setWallType(fps);
    }

    public void setWindow(int fps){
        timeVariable.setCurrentState(fps);
    }
}
