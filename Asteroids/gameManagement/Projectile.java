package gameManagement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import movement.Collider;
import movement.Movement;

public class Projectile {
	
	private Collider col;
	private float speed;
	private Vector2 currentPosition;
	private JLabel icon;
	
	public Projectile()
	{
		col = new Collider();
		currentPosition = new Vector2(0,0);
		
	}
	
	public JLabel spawn(Vector2 pos)
	{
		icon = new JLabel("");
		icon.setIcon(new ImageIcon(GamePanel.class.getResource("/gameManagement/bullet.png")));
		icon.setBounds((int)pos.x, (int)pos.y, 506, 518);

		return icon;
	}
	
	public void move(JFrame frame, GamePanel panel, int dir)
	{
		Movement mover = new Movement();
		Vector2 displacement = new Vector2(dir * speed, speed);
		Vector2 deltaPos = mover.Move(currentPosition, displacement);
		
		currentPosition = deltaPos;
		col.updatePos(currentPosition);
		icon.setBounds((int)currentPosition.x, (int)currentPosition.y, 7, 7);
		panel.paintComponenet(frame.getGraphics());
		frame.repaint();
	}
	
	public void setCurrentPos(Vector2 pos)
	{
		currentPosition = pos;
	}
}
