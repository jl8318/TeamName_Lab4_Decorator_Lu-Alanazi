package weapon;

import gameplay.TimeObserver;

public interface Weapon extends TimeObserver
{
	
	public int getDamage(int distance);
	public void setMaxAmmo(int ammo);
	public int getMaxAmmo();
	public void setRateOfFire(int rof);
	public int getRateOfFire();
	public void setMaxRange(int range);
	public int getMaxRange();
	public void setBaseDamage(int damage);
	public int getBaseDamage();
	public void setActualRateFire(int rof);
	public int getActualRateFire();
	public void setActualAmmo(int ammo);
	public int getActualAmmo();
	public void reloadWeapon();
	public void setNumberOfAttachment(int attachment);
	public int getNumberOfAttachment();
	public int getDamageByrate(int distance, int fireRate);
}
