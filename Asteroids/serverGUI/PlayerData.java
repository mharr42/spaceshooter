package serverGUI;

public class PlayerData {
	//TODO: Implement Collider and Projectile classes.
	private double x_pos;
	private double y_pos;
	private double health;
	//private Collider collision;
	private int score;
	private double deltaX;
	private double deltaY;
	//private Projectile bullet;
	
	//Default constructor for the PlayerData.
	public PlayerData() {
		x_pos = 0.0;
		y_pos = 0.0;
		health = 5.0;
		//collision = new Collider();
		score = 0;
		deltaX = 0.0;
		deltaY = 0.0;
		//bullet = new Projectile();
		
	}
	
	//Constructor for initializing new player classes.
	//int playerNumber: indicates player number and assigns position accordingly.
	public PlayerData(int playerNumber) {
		//TODO: Determine the correct positional values.
		if(playerNumber == 1) {
			x_pos = 0.0;
			y_pos = 0.0;
			health = 5.0;
			//collision = new Collider();
			score = 0;
			deltaX = 0.0;
			deltaY = 0.0;
			//bullet = new Projectile();
		}else {
			x_pos = 0.0;
			y_pos = 0.0;
			health = 5.0;
			//collision = new Collider();
			score = 0;
			deltaX = 0.0;
			deltaY = 0.0;
			//bullet = new Projectile();
		}
		
	}
	
	//TODO: Implement getCollision, setCollision, and getBullet methods.
	
	//Reduce the player's health.
	public void doDamage(double damage) {
		
	}
	
	//Method to get the player's X position.
	public double getX() {
		return this.x_pos;
	}
	
	//Method to get the player's Y position.
	public double getY() {
		return this.y_pos;
	}
	
	//Method to get the player's health.
	public double getHealth() {
		return this.health;
	}
	
	//Method to get the player's score.
	public int getScore() {
		return this.score;
	}
	
	//Method to get the player's delta X.
	public double getDeltaX() {
		return this.deltaX;
	}
	
	//Method to get the player's delta Y.
	public double getDeltaY() {
		return this.deltaY;
	}
	
	//Method to set the player's X position.
	public void setX(double x) {
		this.x_pos = x;
	}
	
	//Method to set the player's Y position.
	public void setY(double y) {
		this.y_pos = y;
	}
	
	//Method to set the player's health.
	public void setHealth(double h) {
		this.health = h;
	}
	
	//Method to set the player's score.
	public void setScore(int s) {
		this.score = s;
	}
	
	//Method to set the player's delta X.
	public void setDeltaX(double dx) {
		this.deltaX = dx;
	}
	
	//Method to set the player's delta Y.
	public void setDeltaY(double dy) {
		this.deltaY = dy;
		
	}
	
	
}
