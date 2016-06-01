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
		int actualAmmoInt = ((getActualAmmo()-1)>0)?(getActualAmmo()-1):0;
		this.setActualAmmo(actualAmmoInt);
		return distance+ this.getWeapon().getDamage(distance) ;
	}

	

}
