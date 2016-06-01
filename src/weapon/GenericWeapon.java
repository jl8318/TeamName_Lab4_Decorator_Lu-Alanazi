package weapon;

/**
 * It represent the Generic Weapon.
 * 
 * @author Jixiang Lu
 *
 */
public abstract class GenericWeapon implements Weapon
{
	
	private int baseDamage;
	private int maxRange;
	private int rateOfFire;
	private int maxAmmon;
	private int actualAmmo;
	private int actualRateFire;
	private int numberOfAttachment;
	
	/**
	 * Constructor with the base damage, max range, max fire rate, max ammo.
	 * @param damage the base damage.
	 * @param range the maximum range the weapon can reach.
	 * @param rateOfFire the maximum fire rate per round.
	 * @param ammo the maximum number of ammo the weapon can carry.
	 */
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
	
	/**
	 * Sets the Maximum number of Ammo which the weapon can carry.
	 * @param ammo the maximum number of ammo
	 */
	@Override
	public void setMaxAmmo(int ammo)
	{
		this.maxAmmon = ammo;
	}
	
	/**
	 * Gets the Maximum number of Ammo which the weapon can carry.
	 * @return the Maximum number of Ammo.
	 */
	@Override
	public int getMaxAmmo()
	{
		return this.maxAmmon;
	}
	
	/**
	 * Sets the Rate of Fire.
	 * 
	 * @param rof the Rate of Fire.
	 */
	@Override
	public void setRateOfFire(int rof)
	{
		this.rateOfFire = rof;
	}
	
	/**
	 * Gets the Rate of Fire.
	 * @return the Rate of Fire.
	 */
	@Override
	public int getRateOfFire()
	{
		return this.rateOfFire;
	}
	
	/**
	 * Sets the Max Range the weapon can reach.
	 * @param range the max range.
	 */
	@Override
	public void setMaxRange(int range)
	{
		this.maxRange = range;
	}
	
	/**
	 * Gets the Max Range the weapon can reach.
	 * @return the maxRange.
	 */
	@Override
	public int getMaxRange()
	{
		return this.maxRange;
	}
	
	/**
	 * Sets the base damage of the weapon.
	 * @param damage the base damage of the weapon
	 */
	@Override
	public void setBaseDamage(int damage)
	{
		this.baseDamage = damage;
	}
	
	/**
	 * Gets the base damage of the weapon.
	 * @return the base damage of the weapon.
	 */
	@Override
	public int getBaseDamage()
	{
		return this.baseDamage;
	}
	
	/**
	 * Sets the Rate of Fire left actually.
	 * @param rof the Rate of fire left.
	 */
	@Override
	public void setActualRateFire(int rof)
	{
		this.actualRateFire = rof;
	}
	
	/**
	 * Gets the Rate of Fire left actually.
	 * @return the rate of fire left.
	 */
	@Override
	public int getActualRateFire()
	{
		return this.actualRateFire;
	}
	
	/**
	 * Sets the actual number of ammo left.
	 * @param ammo the actual number of ammo left.
	 */
	@Override
	public void setActualAmmo(int ammo)
	{
		this.actualAmmo= ammo;
	}
	
	/**
	 * Gets the actual number of ammo left.
	 * @return the actual number of ammo left.
	 */
	@Override
	public int getActualAmmo()
	{
		return this.actualAmmo;
	}
	
	/**
	 * Reload the weapon
	 */
	@Override
	public void reloadWeapon()
	{
		this.actualAmmo = this.maxAmmon;
	}
	
	/**
	 * Sets the number of attachments which the weapon has
	 * @param attachment the number of attachment.
	 */
	@Override
	public void setNumberOfAttachment(int attachment)
	{
		this.numberOfAttachment = attachment;
	}
	
	/**
	 * Gets the number of attachments which the weapon has
	 * @return the number of attachment.
	 */
	@Override
	public int getNumberOfAttachment()
	{
		return this.numberOfAttachment;
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
	
	/**
	 * Gets the timer update. The rate  of fire will be reset each round.
	 */
	@Override
	public void updateTime(int time)
	{
		this.actualRateFire = this.rateOfFire;
	}
}
