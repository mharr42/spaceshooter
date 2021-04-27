package playerGUI;

import javax.swing.JPanel;

import gameManagement.GamePanelControl;
import java.awt.Color;
import javax.swing.JLabel;

public class SimpleGamePanel extends JPanel 
{
	private GamePanelControl gpc;
	
	private JLabel healthLabel;
	
	public SimpleGamePanel(GamePanelControl gpc)
	{
		setBackground(Color.BLACK);
		this.gpc = gpc;
		setLayout(null);
		
		healthLabel = new JLabel("New label");
		healthLabel.setBounds(198, 89, 46, 14);
		healthLabel.setForeground(Color.LIGHT_GRAY);
		add(healthLabel);
	}
	
	public void setHealthText(int val)
	{
		healthLabel.setText(String.valueOf(val));
	}
}
