package weapon;

import exceptions.AttachmentException;

/**
 * Stabilizer class
 * @author Saad
 *
 */

public class Stabilizer extends Attachment 
{

	public Stabilizer(Weapon wp)throws AttachmentException
	{
		super(wp);
	}
    /**
     * A Stabilizer auto reloads if ammo is at 0 
	 * A Stabilizer also increases the Weapon's damage by 25%
     */
	@Override
	public int getDamage(int distance) 
	{
		int distanceads = Math.abs(distance);
		float stabilizer = (float) (this.getWeapon().getDamage(distanceads)* 1.25);
		if(getActualAmmo()==0)
		{
			this.getWeapon().reloadWeapon(); 
		}
		
		return (int)stabilizer;
	}
	
	
	
	

}
