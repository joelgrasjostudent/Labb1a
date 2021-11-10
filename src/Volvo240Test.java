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
}
