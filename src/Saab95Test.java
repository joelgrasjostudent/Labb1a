import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

class Saab95Test {

	@Test
	void testDoors() {
		Car saab = new Saab95();
		assertTrue(saab.getNrDoors() == 2);
	}
	@Test
	void testColor() {
		Car saab = new Saab95();
		assertTrue(saab.getColor() == Color.red);
	}
	@Test
	void testSpeedFactorTurboOff() {
		Saab95 saab = new Saab95(); 
		saab.setTurboOff();
		assertTrue(saab.speedFactor() == 1.25);
	}
	@Test
	void testSpeedFactorTurboOn() {
		Saab95 saab = new Saab95(); 
		saab.setTurboOn();
		assertTrue(saab.speedFactor() == 1.625);
	}
	@Test
	void testIncrementSpeed() {
		Saab95 saab = new Saab95();
		double modifier = 18;
		double firstSpeed = 10;
		saab.setCurrentSpeed(firstSpeed);
		saab.incrementSpeed(modifier);
		double speedFactor = saab.speedFactor();
		assertTrue(saab.getCurrentSpeed() == speedFactor * modifier + firstSpeed);
	}
	@Test
	void testDecrementSpeed() {
		Saab95 saab = new Saab95();
		double modifier = 19;
		double firstSpeed = 10;
		saab.setCurrentSpeed(firstSpeed);
		saab.decrementSpeed(modifier);
		double speedFactor = saab.speedFactor();
		assertTrue(saab.getCurrentSpeed() == firstSpeed - speedFactor * modifier);
	}

}
