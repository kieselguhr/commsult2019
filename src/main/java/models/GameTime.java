package models;

public class GameTime {

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
    }

    public void printTime(){

        String h = "";
        String m = "";

        h = String.valueOf(time / 100);

        if(time%100 == 0){
            m = "00";
        }
        else{
            m = String.valueOf(time % 100);
        }


        System.out.println("Time \t" + h+":"+m);
    }

}
