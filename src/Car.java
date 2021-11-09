import java.awt.*;

/**
 * represents a car
 */
public abstract class Car implements Movable{

	private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double x; 
    private double y;
    private int direction;
    
    private static final int NORTH = 0; //North constant
    private static final int EAST = 1; //East constant
    private static final int SOUTH = 2; //South constant
    private static final int WEST = 3; //West constant
    
    /**
     * Math.max(getCurrentSpeed() - speedFactor() * amount,0)
     * @param nrDoors
     * @param color
     * @param power
     * @param model
     */
    public Car(int nrDoors, Color color, int power, String model) {
    	this.nrDoors = nrDoors;
    	this.color = color;
    	this.enginePower = power;
    	this.modelName = model;
    	stopEngine();
    	x = 0;
    	y = 0;
    	direction = NORTH;
    }
    /**
     * Returns number of doors
     * @return
     */
    public int getNrDoors(){
        return nrDoors;
    }
    /**
     * Returns the engine power
     * @return
     */
    public double getEnginePower(){
        return enginePower;
    }
    /**
     * Returns the current speed
     * @return
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }
    /**
     * Set a new current speed, takes an input speed as double
     * @param speed
     */
    public void setCurrentSpeed(double speed) {
    	currentSpeed = speed;
    }
    /**
     * Returns the color the car has
     * @return
     */
    public Color getColor(){
        return color;
    }
    /**
     * Give the car a new fancy color, takes the parameter color
     * @param clr
     */
    public void setColor(Color clr){
	    color = clr;
    }
    /**
     * Starts the car's engine, wrooooom
     */
    public void startEngine(){
	    currentSpeed = 0.1;
    }
    /**
     * Stops the cars engine, moooooorw
     */
    public void stopEngine(){
	    currentSpeed = 0;
    }
    /**
     * Returns the car's position.
     * @return
     */
    public double[] getPosition() {
    	double[] res = {x, y};
    	return res;
    }
    /**
     * Abstract method, used to set a speedfactor in each individual car.
     * @return
     */
    public abstract double speedFactor();
    /**
     * Increases the speed of the car, takes the parameter amount and increases the speed by that amount
     * @param amount
     */
    public abstract void incrementSpeed(double amount);
    /**
     * Decreases the speed of the car, takes the parameter amount and decreases the speed by that amount
     * @param amount
     */
    public abstract void decrementSpeed(double amount);
    /**
     * Moves the car in a given direction, it changes the x and y value depending on its direction
     */
	public void move() {
		if (direction == NORTH)
			y -= currentSpeed;
		if (direction == SOUTH)
			y += currentSpeed;
		if (direction == WEST)
			x -= currentSpeed;
		if (direction == EAST)
			x += currentSpeed;
	}
	/**
	 * Turns the car 90 degrees left
	 */
	public void turnLeft() {
		if (direction == NORTH)
			direction = WEST;
		if (direction == SOUTH)
			direction = EAST;
		if (direction == WEST)
			direction = SOUTH;
		if (direction == EAST)
			direction = NORTH;
	}
	/**
	 * Turns the car 90 degrees right
	 */
	public void turnRight() {
		if (direction == NORTH)
			direction = EAST;
		if (direction == SOUTH)
			direction = WEST;
		if (direction == WEST)
			direction = NORTH;
		if (direction == EAST)
			direction = SOUTH;
	}
}
