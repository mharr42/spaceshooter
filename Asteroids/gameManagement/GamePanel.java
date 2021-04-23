package gameManagement;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;


public class GamePanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private Player p1; 
	private Player p2;
	
	private JLabel p1Health;
	private JLabel p2Health;
	
	private JLabel p1Score;
	private JLabel p2Score;
	
	public GamePanel(KeyListener[] keys, Player[] players, JFrame frame)
	{
		setBackground(Color.black);
		
		
		setFocusable(true);
		addKeyListener(keys[0]);
		addKeyListener(keys[1]);
		
		setLayout(null);
		
		p1 = players[0];
		p2 = players[1];
		p2.setCurrentPosition(p2.getCurrentPosition().add(new Vector2(20,20)));
		
		
		p1.setShipImage(new ImageIcon(GamePanel.class.getResource("/gameManagement/player1.png")));
		p2.setShipImage(new ImageIcon(GamePanel.class.getResource("/gameManagement/player2.png")));
		add(p1.getShip());
		add(p2.getShip());
		
		p1Score = new JLabel("score: ");
		p1Score.setForeground(Color.LIGHT_GRAY);
		p1Score.setBounds(55, 0, 72, 22);
		add(p1Score);
				
		p2Score = new JLabel("score: ");
		p2Score.setForeground(Color.LIGHT_GRAY);
		p2Score.setBounds(306, 0, 72, 22);
		add(p2Score);
						
		p1Health = new JLabel("health:");
		p1Health.setForeground(Color.LIGHT_GRAY);
		p1Health.setBounds(55, 20, 72, 22);
		add(p1Health);
						
		p2Health = new JLabel("health:");
		p2Health.setForeground(Color.LIGHT_GRAY);
		p2Health.setBounds(306, 20, 72, 22);
		add(p2Health);
	}

	
	public JPanel getPanel()
	{
		return this;
	}
	
	public void paintComponenet(Graphics g)
	{
		super.paintComponent(g);
		
		p1.updatePos();
		p2.updatePos();
		
		p1Health.setText("healht: " + p1.getHealth());
		p2Health.setText("health: " + p2.getHealth());
	}
}
