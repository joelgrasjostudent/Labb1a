import java.awt.*;

/**
 * Represents a Saab 95
 */
public class Saab95 extends Car{

    private boolean turboOn;
    
    //Constructor for a Saab 95
    public Saab95(){
    	super(2, Color.red, 125, "Saab95");
	    turboOn = false;
    }

    //turn on turbo
    public void setTurboOn(){
	    turboOn = true;
    }

    //turn off turo
    public void setTurboOff(){
	    turboOn = false;
    }
    
    //get modifier for changing speed
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    //increase speed
    @Override
    public void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    //decrease speed
    @Override
    public void decrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }
}