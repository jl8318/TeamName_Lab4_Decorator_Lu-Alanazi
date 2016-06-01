package weapon;

import exceptions.AttachmentException;


public class Scope extends Attachment 
{

	public Scope(Weapon wp) throws AttachmentException 
	{

		super(wp);
		
	}

	@Override
	public int getDamage(int distance) 
	{
		int  distanceads = Math.abs(distance);
		float weapon = this.getWeapon().getDamage(distanceads) ; 
		float maxrange = getMaxRange();
		if (distanceads <= getMaxRange())
		{
			float damage = weapon*(1+(maxrange-distanceads)/maxrange); 
			return (int)damage;
		}
		else
		{
			return 0 ; 
		}
		
	}

}
