package weapon;

public abstract class GenericWeapon implements Weapon{
	
	private int baseDamage;
	private int maxRange;
	private int rateOfFire;
	private int maxAmmon;
	private int actualAmmo;
	private int actualRateFire;
	
	public GenericWeapon(int damage,int range,int rateOfFire,int ammo)
	{
		this.baseDamage = damage;
		this.maxRange = range;
		this.rateOfFire = rateOfFire;
		this.maxAmmon = ammo;
	}
	

}
