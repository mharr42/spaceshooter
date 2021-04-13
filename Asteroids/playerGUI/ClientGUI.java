package playerGUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.io.IOException;

import javax.swing.*;

public class ClientGUI extends JFrame{
	
	public ClientGUI()
	{
		GameClient client = new GameClient();
		client.setHost("localhost");
		client.setPort(8300);
		try
		{
			client.openConnection();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		// Set the title and default close operation
		this.setTitle("Game Client");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create the cardLayout container
		CardLayout cardLayout = new CardLayout();
		JPanel container = new JPanel(cardLayout);
		
		
		// Create the controllers next
		InitialControl ic = new InitialControl(container);
		LoginControl lc = new LoginControl(container, client);
		CreateAccountControl cac = new CreateAccountControl(container,client);
		// Add Game Panel Controller
		
		// Set the clientinfo
		client.setLoginControl(lc);
		client.setCreateAccountControl(cac);
		//Add set GamePanelControl here
		
		// Create the four views
		JPanel view1 = new InitialPanel(ic);
		JPanel view2 = new LoginPanel(lc);
		JPanel view3 = new CreateAccountControl(cac);
		//JPanel view4 = new InitialPanel(ic);

		// Add the views to the card layout container
		container.add(view1);
		container.add(view2);
		container.add(view3);
		//container.add(view4);
		
		// Show initial view in the card layout
		cardLayout.show(container, "1");
		
		// Add the card layout container to the JFrame.
		// GridBagLayout makes the container stay centered in the window
		this.setLayout(new GridBagLayout());
		this.add(container);
		
		// Show JFrame
	    this.setSize(550, 350);
	    this.setVisible(true);
		
	}
	
	// Main function that creates the client GUI when the program is started
	public static void main(String[] args)
	  {
	    new ClientGUI();
	  }

}
