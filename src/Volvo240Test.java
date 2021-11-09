import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

class Volvo240Test {

	@Test
	void testDoors() {
		Car volvo = new Volvo240();
		assertTrue(volvo.getNrDoors() == 4);
	}
	
	@Test
	void testColor() {
		Car volvo = new Volvo240();
		assertTrue(volvo.getColor() == Color.black);
	}
	@Test
	void testSpeedFactor() {
		Car volvo = new Volvo240();
		assertTrue(volvo.speedFactor() == volvo.getEnginePower() * 0.01 * 1.25);
	}
	@Test
	void testIncrementSpeed() {
		Volvo240 volvo = new Volvo240();
		double baseSpeed = volvo.getCurrentSpeed();
		double modifier = 1;
		volvo.incrementSpeed(modifier);
		assertTrue(volvo.getCurrentSpeed() > baseSpeed);
	}
	@Test
	void testDecrementSpeed() {
		Volvo240 volvo = new Volvo240();
		volvo.setCurrentSpeed(10);
		double baseSpeed = volvo.getCurrentSpeed();
		double modifier = 1;
		volvo.decrementSpeed(modifier);
		System.out.println(baseSpeed);
		assertTrue(volvo.getCurrentSpeed() < baseSpeed);
	}
	
}
