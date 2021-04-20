package gameManagement;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import input.PlayerInput;
import movement.Movement;

public class Game implements ActionListener
{
	private GamePanel serverPanel;
	private Player[] players;
	private PlayerInput[] playerInputs;
	private boolean paused = false;
	private JFrame frame;
	private Timer timer;
	private float moveSpeed = 2;
	
	public static void main(String[] args)
	{
		Game game = new Game();
		game.StartGame();
	}
	
	public Game()
	{
		frame = new JFrame("Spaceshooter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		players = new Player[2];
		playerInputs = new PlayerInput[2];
		
		players[0] = new Player();
		players[1] = new Player();
		playerInputs[0] = players[0].getInput();
		playerInputs[1] = players[1].getInput();

		serverPanel = new GamePanel(playerInputs, players, frame);
		players[0].setCurrentPosition(new Vector2(20, 300));
		players[1].setCurrentPosition(new Vector2(400,  300));
		
		frame.add(serverPanel, BorderLayout.CENTER);
		
		frame.setSize(500,500);
		frame.setVisible(true);
		
		timer = new Timer(1000/60, this);
		
		serverPanel.paintComponenet(frame.getGraphics());
		frame.repaint();
	}
	
	
	public void StartGame()
	{
		timer.start();
	}
	
	public void step()
	{
		if(!paused)
		{
			players[0].move(frame, serverPanel);
			players[1].move(frame, serverPanel);
			
			updatePlayerData();
		}
	}
	
	public void movePlayer(Player p)
	{
		Vector2 pInput = p.getInput().getInput();
		if(pInput.x != 0 || pInput.y != 0)
		{
			Movement mover = new Movement();
			Vector2 displacement = new Vector2(pInput.x * moveSpeed, pInput.y * moveSpeed);
			Vector2 p1deltaPos =  mover.Move(p.getCurrentPosition(), displacement);

			p.setCurrentPosition(p1deltaPos);
//			serverPanel.paintComponenet(frame.getGraphics());
//			frame.repaint();
		}
	}
	
	public void updatePlayerData()
	{
		players[0].updateData();
		players[1].updateData();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		step();

		
	}
	
	
}
