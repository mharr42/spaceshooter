package gameManagement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


import input.PlayerInput;
import movement.Movement;

public class Player 
{
	private Vector2 currentPosition;
	private JLabel ship;
	private PlayerInput input;
	private float moveSpeed = 2;
	private int health = 5;
	private int score;
	private PlayerData data;
//	private Vector2 bounds;
	
	public Player()
	{
		currentPosition = new Vector2(0,0);
		input = new PlayerInput();
		
		ship = new JLabel("");
		ship.setBounds(24, 133, 67, 40);
		
		
		data = new PlayerData(this);
	}
	
	public void updatePos()
	{
		setShipBounds(currentPosition, 67, 40);
	}
	
	public void move(JFrame frame, GamePanel panel)
	{
		Vector2 pInput = input.getInput();
		if(pInput.x != 0 || pInput.y != 0)
		{
			Movement mover = new Movement();
			Vector2 displacement = new Vector2(pInput.x * moveSpeed, pInput.y * moveSpeed);
			Vector2 p1deltaPos =  mover.Move(currentPosition, displacement);

			setCurrentPosition(p1deltaPos);
			panel.paintComponenet(frame.getGraphics());
			frame.repaint();
		}
	}
	
	public void setShipImage(ImageIcon i)
	{
		ship.setIcon(i);
	}
	
	public void setShipBounds(Vector2 p, int w, int h)
	{
		ship.setBounds((int)p.x, (int)p.y, w, h);
		
	}
	public void setShip(JLabel s)
	{
		ship = s;
	}
	public JLabel getShip()
	{
		return ship;
	}

	public Vector2 getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Vector2 currentPosition) {
		this.currentPosition = currentPosition;
	}

	public PlayerInput getInput() {
		return input;
	}

	public void setInput(PlayerInput input) {
		this.input = input;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public PlayerData getData() {
		return data;
	}

	public void setData(PlayerData data) {
		this.data = data;
	}
	
	public void updateData()
	{
		data.setPosition(currentPosition);
		data.setHealth( health);
		data.setScore(score);
	}
	
}
