package gameManagement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import input.PlayerInput;

public class GamePanel extends JPanel
{
    private GamePanelControl gpc;
    private PlayerInput player_input;
    
	private static final long serialVersionUID = 1L;
	
	private PlayerData p1; 
	private PlayerData p2;
	
	private JPanel background;
	
	private JLabel p1Health;
	private JLabel p2Health;
	
	private JLabel p1Score;
	private JLabel p2Score;
	
	private JLabel p1Ship;
	private JLabel p2Ship;
	
	public GamePanel(GamePanelControl gpc)
	{
	    
	    
	    this.setBackground(Color.BLACK);
	    
	    
	    p1Ship = new JLabel(); 
	    p1Ship.setBounds(54, 157, 30, 30);
	    
	    
	    
	  p1Ship.setIcon(new ImageIcon(GamePanel.class.getResource("/gameManagement/player1.png")));
	  
      setLayout(null);
	  //p1Ship.setBounds((int)p1.getPosition().x, (int)p1.getPosition().y, 7, 7);
	  
	  //      p2Ship.setIcon(new ImageIcon(GamePanel.class.getResource("/gameManagement/player2.png")));
//      add(p2.getShip());
      
      p1Score = new JLabel("score: ");
      p1Score.setForeground(Color.LIGHT_GRAY);
      p1Score.setBounds(54, 13, 60, 14);
      
      add(p1Score);
              
      p2Score = new JLabel("score: ");
      p2Score.setForeground(Color.LIGHT_GRAY);
      p2Score.setBounds(335, 13, 67, 14);
      add(p2Score);
                      
      p1Health = new JLabel("health:");
      p1Health.setForeground(Color.LIGHT_GRAY);
      p1Health.setBounds(53, 38, 74, 14);
      add(p1Health);
                      
      p2Health = new JLabel("health:");
      p2Health.setForeground(Color.LIGHT_GRAY);
      p2Health.setBounds(334, 38, 68, 14);
      add(p2Health);
	  
      add(p1Ship);
	}
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public GamePanel(KeyListener[] keys, Player[] players, JFrame frame)
//	{
//		setBackground(Color.black);
//		
//		
//		setFocusable(true);
//		addKeyListener(keys[0]);
//		addKeyListener(keys[1]);
//		
//		setLayout(null);
//		
//		p1 = players[0];
//		p2 = players[1];
//		p2.setCurrentPosition(p2.getCurrentPosition().add(new Vector2(20,20)));
//		
//		
//		p1.setShipImage(new ImageIcon(GamePanel.class.getResource("/gameManagement/player1.png")));
//		p2.setShipImage(new ImageIcon(GamePanel.class.getResource("/gameManagement/player2.png")));
//		add(p1.getShip());
//		add(p2.getShip());
//		
//		p1Score = new JLabel("score: ");
//		p1Score.setForeground(Color.LIGHT_GRAY);
//		p1Score.setBounds(55, 0, 72, 22);
//		add(p1Score);
//				
//		p2Score = new JLabel("score: ");
//		p2Score.setForeground(Color.LIGHT_GRAY);
//		p2Score.setBounds(306, 0, 72, 22);
//		add(p2Score);
//						
//		p1Health = new JLabel("health:");
//		p1Health.setForeground(Color.LIGHT_GRAY);
//		p1Health.setBounds(55, 20, 72, 22);
//		add(p1Health);
//						
//		p2Health = new JLabel("health:");
//		p2Health.setForeground(Color.LIGHT_GRAY);
//		p2Health.setBounds(306, 20, 72, 22);
//		add(p2Health);
//	}
//
//	
//	public JPanel getPanel()
//	{
//		return this;
//	}
//	
//	public void paintComponenet(Graphics g)
//	{
//		super.paintComponent(g);
//		
//		p1.updatePos();
//		p2.updatePos();
//		
//		p1Health.setText("health: " + p1.getHealth());
//		p2Health.setText("health: " + p2.getHealth());
//	}
//}
