package movement;

import java.awt.Rectangle;

import gameManagement.Vector2;

public class Collider 
{
//	private int width;
//	private int height;
	private Rectangle bounds;

	
	public Collider()
	{
//		width = 30;
//		height = 30;
		bounds = new Rectangle();
		
	}
	
	public Collider(Vector2 pos, int w, int h)
	{
//		width = w;
//		height = h;
		bounds = new Rectangle((int)pos.x, (int)pos.y, w,h);
	}
	
	public boolean CheckOverlap(Rectangle other)
	{
		if(bounds.intersects(other))
		{
			System.out.println("collision occured");
			return true;
		}
		return false;
	}
	
	public void updatePos(Vector2 pos)
	{
		bounds.setLocation((int)pos.x, (int)pos.y); 
	}
	
	public Rectangle getBounds()
	{
		return bounds;
	}
}
