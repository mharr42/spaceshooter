package playerGUI;

import java.awt.CardLayout;
import java.awt.event.*;

import javax.swing.*;

public class LoginControl implements ActionListener{

	private JPanel container;
	private GameClient client;

	// Constructor for login controller
	public LoginControl(JPanel container,GameClient client)
	{
		this.container = container;
		this.client = client;
	}

	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();

		if (command == "Cancel")
		{
			CardLayout cardLayout = (CardLayout)container.getLayout();
			cardLayout.show(container, "1");
		}

		else if (command == "Submit")
		{
			// Get username and password user has entered
			LoginPanel loginpanel = (LoginPanel)container.getComponent(1);
			LoginData logindata = new LoginData(loginpanel.getUsername(), loginpanel.getPassword());

			if (logindata.getUsername().equals("") || logindata.getPassword().equals(""))
			{
				displayError("You must enter a username and password.");
				return;
			}

			// Submit login information to the server.
			try
			{
				client.sendToServer(logindata);
			}
			catch (Exception e) {
				// TODO: handle exception
				displayError("Error connecting to the server");
			}
		}
	}

	// After the login is successful, set the User object and dispay game screen
	public void loginSuccess()
	{
		LoginPanel loginPanel = (LoginPanel)container.getComponent(1);

		CardLayout cardLayout = (CardLayout)container.getLayout();
		cardLayout.show(container, "4");
	}

	// Method that displays a message in the error label.
	public void displayError(String error)
	{
		LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
		loginPanel.setError(error);
	}

}
