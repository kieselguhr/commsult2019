package models;

import abstracts.Actor;

public class WindActor extends Actor {

    public static final int WALLTYPE_STRAW = 0;
    public static final int WALLTYPE_STICK = 1;
    public static final int WALLTYPE_BRICK = 2;

    public static final int STRAW_DEFENSE = 10;
    public static final int STICK_DEFENSE = 30;
    public static final int BRICK_DEFENSE = 70;

    int wallType = WALLTYPE_STRAW;

    public int getWallType() {
        return wallType;
    }

    public void setWallType(int wallType) {
        this.wallType = wallType;
    }

    public int effectEnvironment(int value) {
        switch (wallType){
            case 0 :
                value = value + 10;
                break;
            case 1 :
                value = value + 30;
                break;
            case 2 :
                value = value + 70;
                break;
            default :
                value = 0;
        }

        if(value<0){
            return 0;
        }if(value>100){
            return 100;
        }else{
            return value;
        }
    }

    public int getWallDurability(){
        switch (wallType){
            case 0 :
                return STRAW_DEFENSE;
            case 1 :
                return STICK_DEFENSE;
            case 2 :
                return BRICK_DEFENSE;
        }
        return 0;
    }

    public String prepareMessage() {
        switch (wallType){
            case 0 :
                return "Wall type : Straw";
            case 1 :
                return "Wall type : Stick";
            case 2 :
                return "Wall type : Bricks";
            default :
                return "Wall type : Null";
        }
    }
}
