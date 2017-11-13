package models;

public class GameTime {

    int day = 1;
    int time = 1000;

    public GameTime(int time) {
        this.time = time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void progress(){
        time = time + 10;
        if(time%100 > 59){
            time = time / 100;
            time++;
            time = time * 100;
        }

        if(time >= 2400){
            time = 0;
            day++;
        }

    }

//    public void printTime(){
//
//        String printValue = prepareString();
//        System.out.println(printValue);
//    }

    public String prepareString() {
        String h = "";
        String m = "";

        h = String.valueOf(time / 100);

        if(time%100 == 0){
            m = "00";
        }
        else{
            m = String.valueOf(time % 100);
        }

        return "Day "+ day+  " " + h+":"+m;
    }

}
