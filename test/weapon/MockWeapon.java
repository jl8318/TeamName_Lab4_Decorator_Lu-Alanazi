package weapon;

public class MockWeapon extends GenericWeapon {
	public MockWeapon(int damage,int range,int rateOfFire,int ammo)
	{
		super(damage,range,rateOfFire,ammo);
	}

	@Override
	public int getDamage(int distance) {
		return distance;
	}

}
