package testClasses;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.awt.Rectangle;

import movement.Collider;
import gameManagement.Vector2;

public class ColliderTest {
	private Collider c;
	private Vector2 bounds;
	private int w, h;

	@Before
	public void setUp() throws Exception {
		bounds = new Vector2((float) Math.random()* 100, (float) Math.random()* 100);
		w = 30;
		h = 30;
		c = new Collider(bounds, w, h);
	}

	@Test
	public void testCheckOverlap() {
		boolean expected = true;
		Vector2 v1 = new Vector2(30, 30);
		Collider c1 = new Collider(v1, 30, 30);

		Vector2 v2 = new Vector2(35, 35);
		Collider c2 = new Collider(v2, 30, 30);

		boolean answer = c1.CheckOverlap(c2.getBounds());

		assertEquals("The two colliders are not overlapping", expected,  answer);
	}

	@Test
	public void testCheckNoOverlap(){
		Vector2 v1 = new Vector2(30, 30);
		Collider c1 = new Collider(v1, 30, 30);
		boolean expected = false;
		Vector2 v3 = new Vector2(100, 100);
		Collider c3 = new Collider(v3, 30, 30);
		boolean answer = c1.CheckOverlap(c3.getBounds());
		assertEquals("The two colliders are overlapping", expected, answer);		
	}


	@Test
	public void testUpdatePos() {
		Rectangle r1 = c.getBounds();
		double x1 = r1.getX(), y1 = r1.getY();
		c.updatePos(new Vector2(45, 45));
		Rectangle r2 = c.getBounds();
		double x2 = r2.getX(), y2 = r2.getY();

		if(x1 == x2) {
			if(y1 == y2) {
				fail("The position did not change.");
			}
		}
	}
}
