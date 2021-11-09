import java.awt.*;

/**
 * Represents a Volvo 240
 */
public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;
    
    /**
     * constructor for a Volvo 240
     */
    public Volvo240(){
        super(4, Color.black, 100, "Volvo240");
    }
    
    /**
     * get modifier for changing speed
     */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    /**
     * increase speed
     * @param amount it will increase the speed by this amount * speedfactor. Unless this is higher than its enginepower, than it will max out to its enginepower
     */
    @Override
    public void incrementSpeed(double amount){
	    setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
    }

    /**
     * decrease speed
     * @param amount it will lower the speed by speedfactor * amount. Unless this results in a currentSpeed under 0, then it will set it to zero.
     */
    @Override
    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }
}