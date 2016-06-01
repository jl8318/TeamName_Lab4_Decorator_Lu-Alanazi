package weapon;

import exceptions.AttachmentException;

public abstract class Attachment implements Weapon
{
	private Weapon wp;
	
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
	
	public Weapon getWeapon()
	{
		return wp;		
	}
	public void setWeapon(Weapon wp)
	{
		this.wp =wp;
	}
	@Override
	public void setMaxAmmo(int ammo)
	{
		wp.setMaxAmmo(ammo);
	}
	@Override
	public int getMaxAmmo()
	{
		return wp.getMaxAmmo();
	}
	@Override
	public void setRateOfFire(int rof)
	{
		wp.setRateOfFire(rof);
	}
	@Override
	public int getRateOfFire()
	{
		return wp.getRateOfFire();
	}
	@Override
	public void setMaxRange(int range)
	{
		wp.setMaxRange(range);
	}
	@Override
	public int getMaxRange()
	{
		return wp.getMaxRange();
	}
	@Override
	public void setBaseDamage(int damage)
	{
		wp.setBaseDamage(damage);
	}
	@Override
	public int getBaseDamage()
	{
		return wp.getBaseDamage();
	}
	@Override
	public void setActualRateFire(int rof)
	{
		wp.setActualRateFire(rof);
	}
	@Override
	public int getActualRateFire()
	{
		return wp.getActualRateFire();
	}
	@Override
	public void setActualAmmo(int ammo)
	{
		wp.setActualAmmo(ammo);
	}
	@Override
	public int getActualAmmo()
	{
		return wp.getActualAmmo();
	}
	@Override
	public void reloadWeapon()
	{
		wp.reloadWeapon();
	}

	@Override
	public void setNumberOfAttachment(int attachment)
	{
		wp.setNumberOfAttachment(attachment);
	}
	
	@Override
	public int getNumberOfAttachment()
	{
		return wp.getNumberOfAttachment();
	}
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
	
	@Override
	public void updateTime(int time)
	{
		wp.updateTime(time);
	}
}
