package movement;

import gameManagement.Vector2;

public class Movement 
{
	
	public Movement()
	{
		
	}
	
	public Vector2 Move(Vector2 currentPos, Vector2 input)
	{
		return currentPos.add(input);
	}
}
