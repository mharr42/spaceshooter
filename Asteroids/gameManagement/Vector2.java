package gameManagement;

public class Vector2 
{
	public float x;
	public float y;
	
	public Vector2()
	{
		this.x = 0.0f;
		this.y = 0.0f;
	}
	
	public Vector2(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Vector2 add(Vector2 a)
	{
		return new Vector2 (x + a.x, y + a.y);
	}
	
	public String toString()
	{
		String newstr = new String("(" + x + "," + y + ")");
		return newstr;
	}
}
