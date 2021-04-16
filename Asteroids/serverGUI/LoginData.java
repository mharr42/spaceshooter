package serverGUI;

import java.io.Serializable;

public class LoginData implements Serializable{
	
	// Private Data fields for the username
	private String username;
	private String password;

	// Setters for the username and password
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	// Getters for the username and password
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public LoginData(String username, String password)
	{
		setUsername(username);
		setPassword(password);
	}
}