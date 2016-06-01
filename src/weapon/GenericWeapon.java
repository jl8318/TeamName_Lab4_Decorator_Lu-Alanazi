package weapon;

public abstract class GenericWeapon implements Weapon
{
	
	private int baseDamage;
	private int maxRange;
	private int rateOfFire;
	private int maxAmmon;
	private int actualAmmo;
	private int actualRateFire;
	private int numberOfAttachment;
	
	public GenericWeapon(int damage,int range,int rateOfFire,int ammo)
	{
		this.baseDamage = damage;
		this.maxRange = range;
		this.rateOfFire = rateOfFire;
		this.actualRateFire = rateOfFire;
		this.maxAmmon = ammo;
		this.actualAmmo = ammo; 
		this.numberOfAttachment = 0;
	}
	
	@Override
	public void setMaxAmmo(int ammo)
	{
		this.maxAmmon = ammo;
	}
	@Override
	public int getMaxAmmo()
	{
		return this.maxAmmon;
	}
	@Override
	public void setRateOfFire(int rof)
	{
		this.rateOfFire = rof;
	}
	@Override
	public int getRateOfFire()
	{
		return this.rateOfFire;
	}
	@Override
	public void setMaxRange(int range)
	{
		this.maxRange = range;
	}
	@Override
	public int getMaxRange()
	{
		return this.maxRange;
	}
	@Override
	public void setBaseDamage(int damage)
	{
		this.baseDamage = damage;
	}
	@Override
	public int getBaseDamage()
	{
		return this.baseDamage;
	}
	@Override
	public void setActualRateFire(int rof)
	{
		this.actualRateFire = rof;
	}
	@Override
	public int getActualRateFire()
	{
		return this.actualRateFire;
	}
	@Override
	public void setActualAmmo(int ammo)
	{
		this.actualAmmo= ammo;
	}
	@Override
	public int getActualAmmo()
	{
		return this.actualAmmo;
	}
	@Override
	public void reloadWeapon()
	{
		this.actualAmmo = this.maxAmmon;
	}
	
	@Override
	public void setNumberOfAttachment(int attachment)
	{
		this.numberOfAttachment = attachment;
	}
	
	@Override
	public int getNumberOfAttachment()
	{
		return this.numberOfAttachment;
	}

	@Override
	public int getDamageByrate(int distance, int fireRate)
	{
		int damage =0;
		if(fireRate<= this.actualRateFire)
		{
			for(int i = 0;i<fireRate;i++)
			{
				damage+=this.getDamage(distance);
			}
			this.actualRateFire -=fireRate;

		}
		else
		{
			int temp = this.actualRateFire;
			for(int i =0;i<temp;i++)
			{
				damage += this.getDamage(distance);
			}
			this.actualRateFire = 0;
		}
		return damage;
	}
	
	@Override
	public void updateTime(int time)
	{
		this.actualRateFire = this.rateOfFire;
	}
}
