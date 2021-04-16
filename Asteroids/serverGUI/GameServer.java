package serverGUI;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class GameServer extends AbstractServer{
	
	private int port;
	private int timeout = 0;
	
	//Constructor for initializing the server with the default settings.
	public GameServer(int port) {
		super(port);
		super.setTimeout(this.timeout);
	}

	//Method to indicate that a message has been received from the client.
	protected void handleMessageFromClient(Object arg0, ConnectionToClient arg1) {
		System.out.println("Client message sent to server.");
	}
	
	//Method to indicate that a listening exception has occurred and relay
	protected void listeningException(Throwable exception) {
		System.out.println("Listening exception occurred.");
		System.out.println(exception.getMessage());
		exception.printStackTrace();
	}
	
	//Method to indicate a client has connected to the server.
	protected void clientConnected(ConnectionToClient client) {
		System.out.println("Client Connected: " + client.toString());
		System.out.println("Client IP Address: " + client.getInetAddress().toString());
		System.out.println("Client ID: " + client.getId());
	}
	
	//Method to indicate that the server has been closed.
	protected void serverClosed() {
		System.out.println("Server has been closed.");
	}
	
	//Method to indicate that the server has been started.
	protected void serverStarted() {
		System.out.println("Server has been started.");
	}
	
	//Method to indicate that the server has been stopped.
	protected void serverStopped() {
		System.out.println("Server has been stopped.");
	}
	
	//Method to return the timeout of the server.
	public int getTimeout() {
		return this.timeout;
	}
	

}
