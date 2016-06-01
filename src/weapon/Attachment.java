package weapon;

import exceptions.AttachmentException;

/**
 * It represent an attachment.
 * @author Jixiang Lu
 *
 */
public abstract class Attachment implements Weapon
{
	private Weapon wp;
	
	/**
	 * Constructor: A weapon with this attachment will be created.
	 * 
	 * @param wp the weapon will be wrapped this attachment
	 * @throws AttachmentException each weapon only has 0-2 attachment.
	 */
	public Attachment(Weapon wp) throws AttachmentException
	{
		int attachment = wp.getNumberOfAttachment();
		if(attachment < 2)
		{
			this.wp = wp;
			wp.setNumberOfAttachment(attachment+1);
			
		}
		else
		{
			throw new AttachmentException("cannot be wrapped around a weapon that already has two attachments!");
		}
		
	}
	
	/**
	 * Gets the weapon the attachment wrap.
	 * @return the weapon.
	 */
	public Weapon getWeapon()
	{
		return wp;		
	}
	
	/**
	 * Sets the weapon the attachment wrap.
	 * @param wp the weapon
	 */
	public void setWeapon(Weapon wp)
	{
		this.wp =wp;
	}
	
	/**
	 * Sets the Maximum number of Ammo which the weapon can carry.
	 * @param ammo the maximum number of ammo
	 */
	@Override
	public void setMaxAmmo(int ammo)
	{
		wp.setMaxAmmo(ammo);
	}
	
	/**
	 * Gets the Maximum number of Ammo which the weapon can carry.
	 * @return the Maximum number of Ammo.
	 */
	@Override
	public int getMaxAmmo()
	{
		return wp.getMaxAmmo();
	}
	
	/**
	 * Sets the Rate of Fire.
	 * 
	 * @param rof the Rate of Fire.
	 */
	@Override
	public void setRateOfFire(int rof)
	{
		wp.setRateOfFire(rof);
	}
	
	/**
	 * Gets the Rate of Fire.
	 * @return the Rate of Fire.
	 */
	@Override
	public int getRateOfFire()
	{
		return wp.getRateOfFire();
	}
	
	/**
	 * Sets the Max Range the weapon can reach.
	 * @param range the max range.
	 */
	@Override
	public void setMaxRange(int range)
	{
		wp.setMaxRange(range);
	}
	
	/**
	 * Gets the Max Range the weapon can reach.
	 * @return the maxRange.
	 */
	@Override
	public int getMaxRange()
	{
		return wp.getMaxRange();
	}
	
	/**
	 * Sets the base damage of the weapon.
	 * @param damage the base damage of the weapon
	 */
	@Override
	public void setBaseDamage(int damage)
	{
		wp.setBaseDamage(damage);
	}
	
	/**
	 * Gets the base damage of the weapon.
	 * @return the base damage of the weapon.
	 */
	@Override
	public int getBaseDamage()
	{
		return wp.getBaseDamage();
	}
	
	/**
	 * Sets the Rate of Fire left actually.
	 * @param rof the Rate of fire left.
	 */
	@Override
	public void setActualRateFire(int rof)
	{
		wp.setActualRateFire(rof);
	}
	
	/**
	 * Gets the Rate of Fire left actually.
	 * @return the rate of fire left.
	 */
	@Override
	public int getActualRateFire()
	{
		return wp.getActualRateFire();
	}
	
	/**
	 * Sets the actual number of ammo left.
	 * @param ammo the actual number of ammo left.
	 */
	@Override
	public void setActualAmmo(int ammo)
	{
		wp.setActualAmmo(ammo);
	}
	
	/**
	 * Gets the actual number of ammo left.
	 * @return the actual number of ammo left.
	 */
	@Override
	public int getActualAmmo()
	{
		return wp.getActualAmmo();
	}
	
	/**
	 * Reload the weapon.
	 */
	@Override
	public void reloadWeapon()
	{
		wp.reloadWeapon();
	}

	/**
	 * Sets the number of attachments which the weapon has
	 * @param attachment the number of attachment.
	 */
	@Override
	public void setNumberOfAttachment(int attachment)
	{
		wp.setNumberOfAttachment(attachment);
	}
	
	/**
	 * Gets the number of attachments which the weapon has
	 * @return the number of attachment.
	 */
	@Override
	public int getNumberOfAttachment()
	{
		return wp.getNumberOfAttachment();
	}
	
	/**
	 * Gets the damage which caused by multiple fire base on this distance.
	 * @param distance the distance between weapon and target.
	 * @param fireRate the times of fire
	 * @return the value of damage
	 */
	@Override
	public int getDamageByrate(int distance, int fireRate)
	{
		int damage =0;
		int actualRateFire = this.getActualRateFire();
		if(fireRate<= actualRateFire)
		{
			for(int i = 0;i<fireRate;i++)
			{
				damage+=this.getDamage(distance);
			}
			 this.setActualRateFire(actualRateFire-fireRate);

		}
		else
		{
			for(int i =0;i<actualRateFire;i++)
			{
				damage += this.getDamage(distance);
			}
			this.setActualRateFire(0);
		}
		return damage;
	}
	
	/**
	 * Gets the timer update. The rate  of fire will be reset each round.
	 */
	@Override
	public void updateTime(int time)
	{
		wp.updateTime(time);
	}
}
