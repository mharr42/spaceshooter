package gameManagement;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import input.PlayerInput;
//import movement.Movement;

public class Game implements ActionListener
{
	private GamePanel serverPanel;
	private Player[] players;
	private PlayerInput[] playerInputs;
	private boolean paused = false;
	private JFrame frame;
	private Timer timer;
	
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
			
			players[0].getCollider().CheckOverlap(players[1].getCollider().getBounds());
			
			if(players[0].getInput().checkFire())
			{
				System.out.println("shot fired");
				Projectile bullet = new Projectile();
//				bullet.setCurrentPos(null);
				serverPanel.add(bullet.spawn(players[0].getCurrentPosition()));
				
				bullet.move(frame, serverPanel, 1);
			}
			
			updatePlayerData();
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
