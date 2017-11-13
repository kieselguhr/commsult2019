package models;

public class TimeVariable {

    public static final int SECURITY_LEVEL_LOW = 0;
    public static final int SECURITY_LEVEL_MID = 1;
    public static final int SECURITY_LEVEL_HIGH = 2;

    public static final int BLINDS_OPEN = 2;
    public static final int BLINDS_HALF = 1;
    public static final int BLINDS_LOW = 0;

    public int currentState;

    public int getCurrentState() {
        return currentState;
    }

    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }

    public int determineSecurityLevel(int time){

        if(time < 430){
            return SECURITY_LEVEL_LOW;
        }if(time < 600){
            return SECURITY_LEVEL_MID;
        }if(time < 1700){
            return SECURITY_LEVEL_HIGH;
        }if(time < 1830){
            return SECURITY_LEVEL_MID;
        }else{
            return SECURITY_LEVEL_LOW;
        }

    }

    public boolean isSafe(int time){
        int securityLevel = determineSecurityLevel(time);
        System.out.println("CURRENT "+currentState +" VS " + securityLevel );
        if(securityLevel < currentState){
            return false;
        }
        return true;
    }

}
