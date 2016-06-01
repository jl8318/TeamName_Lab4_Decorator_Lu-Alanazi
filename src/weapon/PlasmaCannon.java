package weapon;

/**
 * It represent a Plasma Cannon
 * @author Jixiang Lu
 *
 */
public class PlasmaCannon extends GenericWeapon 
{
	
	/**
	 * PlasmaCannon with default settle.
	 */
	public PlasmaCannon()
	{
		this(50,20,1,4);
	}
	
	/**
	 * PlasmaCannon with the base damage, max range, max fire rate, max ammo.
	 * @param damage the base damage.
	 * @param range the maximum range the weapon can reach.
	 * @param rateOfFire the maximum fire rate per round.
	 * @param ammo the maximum number of ammo the weapon can carry.
	 */
	public PlasmaCannon(int damage, int range,int rof, int ammo)
	{
		super(damage,range,rof,ammo);
	}
	
	/**
	 * Gets the damage based on the PlasmaCannon's equation, the distance between
	 * weapon and target. The damage is caused by fired once.
	 */
	@Override
	public int getDamage(int distance) 
	{
		int distanceAbs = Math.abs(distance);
		if(distanceAbs>this.getMaxRange())
		{
			int actualAmmoInt = ((getActualAmmo()-1)>0)?(getActualAmmo()-1):0;
			this.setActualAmmo(actualAmmoInt);
			return 0;
		}
		else
		{
			if(this.getActualAmmo()>0)
			{
				//get result
				float baseDamage = (float)this.getBaseDamage();
				float actualAmmo = (float)this.getActualAmmo();
				float maxAmmo = (float)this.getMaxAmmo();
				float damage = baseDamage*(actualAmmo/maxAmmo);   
				int result = (int)damage;
				//change actualAmmo
				int actualAmmoInt = ((getActualAmmo()-1)>0)?(getActualAmmo()-1):0;
				this.setActualAmmo(actualAmmoInt);
				return result;
			}
			else
				return 0;
		}
	}

}
