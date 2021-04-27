package gameManagement;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import playerGUI.GameClient;

public class GamePanelControl
{
    private JPanel container;
    private GameClient client;
    
    private JLabel p1;
    private JLabel p2;
    
    public GamePanelControl(JPanel container, GameClient client)
    {
        this.container = container;
        
        this.client = client;
        
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
