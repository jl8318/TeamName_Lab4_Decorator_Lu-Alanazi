package weapon;

/**
 * Chan gun class 
 * @author Saad
 *
 */

public class ChainGun extends GenericWeapon {
	
	 public ChainGun() {
		this(50 , 20 , 1 , 4);
	}

	public ChainGun(int damage, int range, int rateOfFire, int ammo) {
		super(damage, range, rateOfFire, ammo);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * this method calculates the damage of chain gun	
	 */

	@Override
	public int getDamage(int distance) {

		int distanceabs = Math.abs(distance);    //TO give positive number 
		float baseDamage = (float)getBaseDamage();
		float maxrange = (float)getMaxRange();
		
		if (distance > getMaxRange())
		{
			return 0 ; 
		}
		else 
		{
			float damag = baseDamage * distanceabs/ maxrange; 
			int actualAmmoInt = ((getActualAmmo()-1)>0)?(getActualAmmo()-1):0;
			this.setActualAmmo(actualAmmoInt);
			
			return (int)damag; 
		}
	}
	

}
