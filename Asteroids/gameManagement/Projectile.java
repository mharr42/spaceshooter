package gameManagement;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import movement.Collider;
import movement.Movement;

public class Projectile extends JLabel{
	
	private static final long serialVersionUID = 1L;
	private Collider col;
	private float speed = 1;
	private Vector2 currentPosition;

	
	public Projectile()
	{
		currentPosition = new Vector2(0,0);
		col = new Collider(currentPosition, 7, 7);
		
	}
	
	public JLabel spawn(Vector2 pos)
	{
		this.setIcon(new ImageIcon(GamePanel.class.getResource("/gameManagement/bullet.png")));
		this.setBounds((int)pos.x, (int)pos.y, 7, 7);

		currentPosition = new Vector2(pos.x, pos.y);

		return this;
	}
	
	public void move(float dir)
	{
		Movement mover = new Movement();
		Vector2 displacement = new Vector2(dir * speed, 0);
		Vector2 deltaPos = mover.Move(currentPosition, displacement);
		
		currentPosition.x = deltaPos.x;
		

		this.setBounds((int)currentPosition.x, (int)currentPosition.y, 7, 7);
		col.updatePos(currentPosition);

	}
	
	public void checkBounds()
	{
		if(currentPosition.x > 500)
		{
//			Destroy(this);
		}
	}
	
	public void setCurrentPos(Vector2 pos)
	{
		currentPosition = pos;
	}
	
	public Vector2 getCurrentPosition()
	{
		return currentPosition;
	}
	
	public Collider getCollider()
	{
		return col;
	}
}
