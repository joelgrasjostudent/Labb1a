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
}
