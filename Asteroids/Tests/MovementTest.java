package testClasses;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import gameManagement.Vector2;
import movement.Movement;

public class MovementTest {
	private Movement m;
	private Vector2 pos;
	private Vector2 input;
	
	@Before
	public void setUp() throws Exception {
		m = new Movement();
		pos = new Vector2(0, 0);
		input = new Vector2(30, 30);
	}

	@Test
	public void testMove() {
		Vector2 expected = pos;
		Vector2 actual = m.Move(pos, input);
		
		assertNotEquals("No movement occured", expected, actual);
		
	}

}