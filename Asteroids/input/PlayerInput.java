package input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import gameManagement.Vector2;

public class PlayerInput implements ActionListener, KeyListener
{
    private boolean aPressed = false;
    private boolean dPressed = false;
    private boolean wPressed = false;
    private boolean sPressed = false;
    private boolean firePressed = false;
    
    private boolean aProcessed = false;
    private boolean dProcessed = false;
    private boolean wProcessed = false;
    private boolean sProcessed = false;
    private boolean fireProcessed = false;
    
    private float x;
    private float y;

    public PlayerInput()
    {
    	x = 0;
    	y = 0;
    	
    	Timer timer = new Timer(1000/60, this);
		
		timer.start();
    }
    
    public void processInput()
    {
    	if(aPressed && !aProcessed)
    	{
    		x -= 1;
    		aProcessed = true;
    	}
    	if(dPressed && !dProcessed)
    	{
    		x += 1;
    		dProcessed = true;
    	}
    	if(wPressed && !wProcessed)
    	{
    		y -= 1;
    		wProcessed = true;
    	}
    	if(sPressed && !sProcessed)
    	{
    		y += 1;
    		sProcessed = true;
    	}
    	if(firePressed && ! fireProcessed)
    	{
    		firePressed = false;
    		fireProcessed = true;
    	}
    }
    
    public Vector2 getInput()
    {
    	return new Vector2(x,y);
    }
    
    public boolean checkFire()
    {
    	return firePressed;
    }
    public void step()
    {
    	processInput();
    }
    
    public void actionPerformed(ActionEvent e)
    {
    	step();
    }
    
    public void keyPressed(KeyEvent e)
    {
    	if(e.getKeyCode() == KeyEvent.VK_A && !aProcessed)
    	{
    		aPressed = true;
    	}
    	if(e.getKeyCode() == KeyEvent.VK_D && !dProcessed)
    	{
    		dPressed = true;
    	}
    	if(e.getKeyCode() == KeyEvent.VK_W && !wProcessed)
    	{
    		wPressed = true;
    	}
    	if(e.getKeyCode() == KeyEvent.VK_S && !sProcessed)
    	{
    		sPressed = true;
    	}
    	if(e.getKeyCode() == KeyEvent.VK_SPACE && !fireProcessed)
    	{
    		firePressed = true;
    	}
    }
    
    public void keyReleased(KeyEvent e)
    {
    	if(e.getKeyCode() == KeyEvent.VK_A)
    	{
    		aPressed = false;
    		aProcessed = false;
    		x += 1;
    	}
    	if(e.getKeyCode() == KeyEvent.VK_D)
    	{
    		dPressed = false;
    		dProcessed = false;
    		x -= 1;
    	}
    	if(e.getKeyCode() == KeyEvent.VK_W)
    	{
    		wPressed = false;
    		wProcessed = false;
    		y += 1;
    	}
    	if(e.getKeyCode() == KeyEvent.VK_S)
    	{
    		sPressed = false;
    		sProcessed = false;
    		y -= 1;
    	}
    	if(e.getKeyCode() == KeyEvent.VK_SPACE)
    	{
    		firePressed = false;
    		fireProcessed = false;
    	}
    }
    
    //Getters & Setters
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
    
    
}
