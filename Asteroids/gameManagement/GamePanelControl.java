package gameManagement;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;

import playerGUI.GameClient;
import playerGUI.SimpleGamePanel;

public class GamePanelControl
{
    private JPanel container;
    private GameClient client;
    private SimpleGamePanel panel;
    
    private JLabel p1;
    private JLabel p2;
    
    public GamePanelControl(JPanel container, GameClient client)
    {
        this.container = container;
        
        this.client = client;
        
    }
    
    public void setPanel(SimpleGamePanel p)
    {
    	panel = p;
    }
    
    public void loadGame()
    {
    	Object message = "RequestIntialGameData";
    	try {
			client.sendToServer(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void updateHealth(int val)
    {
    	panel.setHealthText(val);
    }
    
    public void setP1Label(JLabel p1)
    {
        this.setP1Label(p1);
    }
    
    public void setP2Label(JLabel p2)
    {
        this.setP2Label(p2);
    }
}
