import java.awt.*;

//Represents a Volvo 240
public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;
    
    //Constructor for a Volvo 240
    public Volvo240(){
        super(4, Color.black, 100, "Volvo240");
    }
    
    //get modifier for changing speed
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    //increase speed
    @Override
    public void incrementSpeed(double amount){
	    setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
    }

    //decrease speed
    @Override
    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }
}