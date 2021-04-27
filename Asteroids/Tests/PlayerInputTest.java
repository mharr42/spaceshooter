package testClasses;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.awt.event.KeyEvent;

import javax.swing.JButton;

import movement.PlayerInput;

public class PlayerInputTest {
	private PlayerInput pi;
	
	@Before
	public void setUp() throws Exception {
		pi = new PlayerInput();
	}
	
	@Test
	public void testKeyPressed() {
		KeyEvent e = new KeyEvent(new JButton(), 0, 0, 0, KeyEvent.VK_A);
		pi.keyPressed(e);
		
		boolean expected = true, actual = pi.getSingleKeyPress();
		
		assertEquals("Key presses are not being read properly", expected, actual);
		
	}

	@Test
	public void testKeyReleased() {
		KeyEvent e = new KeyEvent(new JButton(), 0, 0, 0, KeyEvent.VK_A);
		pi.keyPressed(e);
		boolean expected = false, actual = pi.getSingleKeyPress();
		System.out.println(expected + "\t" + actual);
		pi.keyReleased(e);
		actual = pi.getSingleKeyRelease();
		assertEquals("Key releases are not being read properly", expected, actual);
	}

	@Test
	public void testProcessInput() {
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(new JButton(), 0, 0, 0, KeyEvent.VK_W);
		pi.keyPressed(e);
		
		e = new KeyEvent(new JButton(), 0, 0, 0, KeyEvent.VK_A);
		pi.keyPressed(e);
		
		e = new KeyEvent(new JButton(), 0, 0, 0, KeyEvent.VK_S);
		pi.keyPressed(e);
		
		e = new KeyEvent(new JButton(), 0, 0, 0, KeyEvent.VK_D);
		pi.keyPressed(e);
		
		e = new KeyEvent(new JButton(), 0, 0, 0, KeyEvent.VK_SPACE);
		pi.keyPressed(e);
		
		pi.processInput();
		
		boolean expected = true;
		boolean actual = true;
		
		boolean[] pre = {true, true, true, true, false};
		boolean[] pre1 = pi.getPressed();
		
		boolean[] pro = {true, true, true, true, true};
		boolean[] pro1 = pi.getProcessed();
		
		if(!(pre.equals(pre1))) {
			actual = false;
		}else if(!(pro.equals(pro1))) {
			actual = false;
		}
		
		assertEquals("The inputs are not being processed correctly", expected, actual);
		
	}


}
