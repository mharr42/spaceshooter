package gameManagement;

public class PlayerData 
{
	private Vector2 position;
	private int health;
	private int score;
	
	public PlayerData()
	{
		position = new Vector2(0,0);
		health = 5;
		score = 0;
	}
	
	public PlayerData(Player p)
	{
		position = p.getCurrentPosition();
		health = p.getHealth();
		score = p.getScore();
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}


}
