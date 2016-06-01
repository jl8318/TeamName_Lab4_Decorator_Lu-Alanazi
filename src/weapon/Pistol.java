package weapon;

/**
 * Pisto Weapon  
 * @author Saad
 *
 */

public class Pistol extends GenericWeapon {
	
	public Pistol()
	{
		this(10 , 25 , 2 , 10); 
	}

	public Pistol(int damage, int range, int rateOfFire, int ammo) {
		super(damage, range, rateOfFire, ammo); 
		
	}
	
	/**
	 * Method to calculate the damage for pistol
	 */

	@Override
	public int getDamage(int distance) {
		
		 int distanceabs = Math.abs(distance);    //TO give positive number 
		float baseDamage = (float)getBaseDamage();
		float maxrange = (float)getMaxRange();
		
		if (distance > getMaxRange()) 
		{
			int actualAmmoInt = ((getActualAmmo()-1)>0)?(getActualAmmo()-1):0;
			this.setActualAmmo(actualAmmoInt);
			return 0 ; 
		}
		else 
		{
			float damag = baseDamage * (maxrange-distanceabs+5) / maxrange; 
			//change the actual Ammo
			int actualAmmoInt = ((getActualAmmo()-1)>0)?(getActualAmmo()-1):0;
			this.setActualAmmo(actualAmmoInt);
			return (int)damag; 
		}
		
	}
	
	


	

}
