package weapon;

import exceptions.AttachmentException;

/**
 * Power Booster Class 
 * @author Saad
 *
 */

public class PowerBooster extends Attachment 
{

	public PowerBooster(Weapon wp) throws AttachmentException
	{
		super(wp);
	}

	@Override
	public int getDamage(int distance) 
	{
		int  distanceads = Math.abs(distance);
		float actualAmmo = (float)this.getActualAmmo();
		float weapon = this.getWeapon().getDamage(distanceads) ; 	
		float maxAmmo = (float)this.getMaxAmmo();
		if (distanceads <= getMaxRange())
		{
			float damage = weapon*(1+actualAmmo/maxAmmo); 
			return (int)damage;
		}
		else
		{
			return 0 ; 
		}
		
	}
	}
	

