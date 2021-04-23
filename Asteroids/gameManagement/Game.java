package gameManagement;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import input.PlayerInput;


public class Game implements ActionListener
{
	private GamePanel serverPanel;
	private Player[] players;
	private PlayerInput[] playerInputs;
	private boolean paused = false;
	private JFrame frame;
	private Timer timer;

	
	private double timeSinceBeginning;
	private double lastTime;
	private double deltaTime;
	
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
		timeSinceBeginning += 1000/60;
		deltaTime = timeSinceBeginning - lastTime;
		
		if(!paused)
		{
			
			movePlayers();
			checkShots();
			moveBullets();
			checkCollisions();
			checkForWinner();
			
			updatePlayerData();
		}
		serverPanel.paintComponenet(frame.getGraphics());
		frame.repaint();
		lastTime = timeSinceBeginning;
	}
	
	public void movePlayers()
	{
		for(Player p: players)
		{
			if(p.getCurrentPosition().x > 500 || p.getCurrentPosition().y > 500)
			{
				if(p.getInput().getX() == -1 || p.getInput().getY() == -1)
				{
					p.move();
				}
			}
			else if(p.getCurrentPosition().x < 0 || p.getCurrentPosition().y < 0)
			{
				if(p.getInput().getX() == 1 || p.getInput().getY() == 1)
				{
					p.move();
				}
			}
			else
			{
				p.move();
			}
		}
	}
	
	public void checkShots()
	{
		for(Player p: players)
		{
			if(p.getInput().checkFire())
			{
				System.out.println("shot fired");
				
				p.shoot(serverPanel);
				
			}
		}
	}
	
	public void moveBullets()
	{
		int i = 0;
		
		for(Player p: players)
		{
			if(!p.bullets().isEmpty())
			{
				for(Projectile bullet: p.bullets())
				{
					if(i == 0)
					{
						bullet.move(1 * (float)deltaTime);
					}
					else
					{
						bullet.move(-1 * (float)deltaTime);
					}
					
					if(bullet.getCurrentPosition().x > 500)
					{
						removeComponent(bullet);
					}
				}
			}
			i++;
		}
	}
	
	public void checkCollisions()
	{
		for(int i = 0; i < 2; i++)
		{
			for(Projectile b: players[i].bullets())
			{
				boolean hitProcessed = false;
				if(i == 0)
				{
					if(b.getCollider().CheckOverlap(players[1].getCollider().getBounds()) && !hitProcessed)
					{
						hitProcessed = true;
						removeComponent(b);
						players[1].doDamage(1);
						b.getCollider().updatePos(new Vector2(1000,1000));
					}
				}
				else if(i ==1)
				{
					if(b.getCollider().CheckOverlap(players[0].getCollider().getBounds()) && !hitProcessed)
					{
						hitProcessed = true;
						removeComponent(b);
						b.getCollider().updatePos(new Vector2(1000,1000));
						players[0].doDamage(1);
						
					}
				}
			}
		}
	}
	
	public void checkForWinner()
	{
		for(int i = 0; i < 2; i++)
		{
			if(players[i].getHealth() < 1)
			{
				if(i == 0)
				{
					System.out.println("Player 2 is the winner!");
					//load winner panel to begin next match
				}
				else if (i == 1)
				{
					System.out.println("Player 1 is the winner");
					//load winner panel to begin next match
				}
			}
		}
	}
	
	public void updatePlayerData()
	{
		players[0].updateData();
		players[1].updateData();
	}
	
	public void removeComponent(Component obj)
	{
		
		serverPanel.remove(obj);
		serverPanel.validate();
		serverPanel.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		step();

		
	}
	
	
	
}
