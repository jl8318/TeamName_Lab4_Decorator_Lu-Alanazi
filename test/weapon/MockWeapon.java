package weapon;

public class MockWeapon extends GenericWeapon {
	public MockWeapon(int damage,int range,int rateOfFire,int ammo)
	{
		super(damage,range,rateOfFire,ammo);
	}

	@Override
	public int getDamage(int distance) {
		int actualAmmoInt = ((getActualAmmo()-1)>0)?(getActualAmmo()-1):0;
		this.setActualAmmo(actualAmmoInt);
		return distance; 
	}

}
