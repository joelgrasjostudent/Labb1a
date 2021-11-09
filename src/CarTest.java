import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;


class CarTest {
	
	

	@Test
	void testMove() {
		Car c = new Volvo240();
		double[] startPos = c.getPosition().clone();
		c.setCurrentSpeed(1);
		c.move();
		double[] newPos = c.getPosition();
		double deltaX = newPos[0] - startPos[0];
		double deltaY = newPos[1] - startPos[1];
		
		assertTrue((deltaY == -1) && (deltaX == 0));
	}
	
	@Test
	void testTurnLeft() {
		Car c = new Volvo240();
		double[] startPos = c.getPosition().clone();
		c.setCurrentSpeed(1);
		c.turnLeft();
		c.move();
		double[] newPos = c.getPosition();
		double deltaX = newPos[0] - startPos[0];
		double deltaY = newPos[1] - startPos[1];
		
		assertTrue((deltaY == 0) && (deltaX == -1));
	}
	
	@Test
	void testTurnRight() {
		Car c = new Volvo240();
		double[] startPos = c.getPosition().clone();
		c.setCurrentSpeed(1);
		c.turnRight();
		c.move();
		double[] newPos = c.getPosition();
		double deltaX = newPos[0] - startPos[0];
		double deltaY = newPos[1] - startPos[1];
		
		assertTrue((deltaY == 0) && (deltaX == 1));
	}
	
	@Test
	void testStartEngine() {
		Car c = new Volvo240();
		c.startEngine();
		assertTrue(c.getCurrentSpeed() == 0.1);
	}
	
	@Test
	void testSetColor() {
		Car c = new Volvo240();
		c.setColor(Color.black);
		assertTrue(c.getColor().equals(Color.black));
	}
	
	@Test
	void testAllMoveDirections() {
		Car c = new Volvo240();
		double[] startPos = c.getPosition().clone();
		c.setCurrentSpeed(1);
		
		for (int i = 0; i < 4; i++) {
			c.turnRight();
			c.move();
		}
		for (int i = 0; i < 4; i++) {
			c.turnLeft();
			c.move();
		}
		
		double[] newPos = c.getPosition();
		double deltaX = newPos[0] - startPos[0];
		double deltaY = newPos[1] - startPos[1];
		
		assertTrue((deltaY == 0) && (deltaX == 0));
	}
	

}
