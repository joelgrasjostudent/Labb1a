import java.awt.*;

public abstract class Car implements Movable{

	private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double x;
    private double y;
    private int direction;
    
    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;
    
    
    
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
	
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }
    
    public void setCurrentSpeed(double speed) {
    	currentSpeed = speed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
	    currentSpeed = 0.1;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }
    
    public double[] getPosition() {
    	double[] res = {x, y};
    	return res;
    }
    
    public abstract double speedFactor();

    public abstract void incrementSpeed(double amount);

    public abstract void decrementSpeed(double amount);
    
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
