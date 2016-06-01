package weapon;

import exceptions.AttachmentException;

public class MockAttachment extends Attachment{

	public MockAttachment(Weapon wp) throws AttachmentException
	{
		super(wp);
		
	}

	@Override
	public int getDamage(int distance) 
	{
		return distance+ this.getWeapon().getDamage(distance) ;
	}

	

}
