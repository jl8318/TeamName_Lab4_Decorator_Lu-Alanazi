package weapon;

/**
 * Mock class is used to test GenericWeapon class
 * @author ljx
 *
 */
public class MockWeapon extends GenericWeapon 
{
	
	/**
	 * Constructor with the base damage, max range, max fire rate, max ammo.
	 * @param damage the base damage.
	 * @param range the maximum range the weapon can reach.
	 * @param rateOfFire the maximum fire rate per round.
	 * @param ammo the maximum number of ammo the weapon can carry.
	 */
	public MockWeapon(int damage,int range,int rateOfFire,int ammo)
	{
		super(damage,range,rateOfFire,ammo);
	}

	/**
	 * Gets the damage each time is equals to distance.
	 */
	@Override
	public int getDamage(int distance) {
		int actualAmmoInt = ((getActualAmmo()-1)>0)?(getActualAmmo()-1):0;
		this.setActualAmmo(actualAmmoInt);
		return distance; 
	}

}
