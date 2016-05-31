package weapon;

public class MockAttachment extends Attachment{

	public MockAttachment(Weapon wp) 
	{
		super(wp);
		
	}

	@Override
	public int getDamage(int distance) 
	{
		return distance;
	}

	

}
