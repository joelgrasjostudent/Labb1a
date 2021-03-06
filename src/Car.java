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
    private double x; //represents position in the horizontal direction
    private double y; //represents position in the vertical direction
    private int direction; //represents which direction the car is facing
    
    private static final int NORTH = 0; //North constant
    private static final int EAST = 1; //East constant
    private static final int SOUTH = 2; //South constant
    private static final int WEST = 3; //West constant
    
    /**
     * @param nrDoors amount of doors
     * @param color color of the car
     * @param power the power of the cars engine
     * @param model the name of the model
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
     * @return Returns number of doors
     */
    public int getNrDoors(){
        return nrDoors;
    }
    /**
     * @return Returns the engine power
     */
    public double getEnginePower(){
        return enginePower;
    }
    /**
     * @return Returns the current speed
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }
    /**
     * @param speed Set a new current speed, takes an input speed as double
     */
    public void setCurrentSpeed(double speed) {
    	currentSpeed = speed;
    }
    /**
     * @return Returns the color the car has
     */
    public Color getColor(){
        return color;
    }
    /**
     * @param clr Give the car a new fancy color, takes the parameter color
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
     * @return Returns the car's position.
     */
    public double[] getPosition() {
    	double[] res = {x, y};
    	return res;
    }
    /**
     * Abstract method, used to get a speedfactor in each individual car.
     * @return returns the speedfactor
     */
    public abstract double speedFactor();
    /**
     * Increases the speed of the car, takes the parameter amount and increases the speed by that amount
     * @param amount amount to increase the speed with
     */
    private void incrementSpeed(double amount){
	    setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
    }
    /**
     * Decreases the speed of the car, takes the parameter amount and decreases the speed by that amount
     * @param amount amount to decrease the speed with
     */
    private void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }
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
		else if (direction == SOUTH)
			direction = EAST;
		else if (direction == WEST)
			direction = SOUTH;
		else
			direction = NORTH;
	}
	/**
	 * Turns the car 90 degrees right
	 */
	public void turnRight() {
		if (direction == NORTH)
			direction = EAST;
		else if (direction == SOUTH)
			direction = WEST;
		else if (direction == WEST)
			direction = NORTH;
		else
			direction = SOUTH;
	}
	
	/**
     * 
     * @param amount amount to gas with, must be between 0 and 1
     */
    public void gas(double amount){
    	amount = Math.max(amount, 0);
    	amount = Math.min(amount, 1);
        incrementSpeed(amount);
    }

    /**
     * 
     * @param amount amount to break with, must be between 0 and 1
     */
    public void brake(double amount){
    	amount = Math.max(amount, 0);
    	amount = Math.min(amount, 1);
        decrementSpeed(amount);
    }
}
