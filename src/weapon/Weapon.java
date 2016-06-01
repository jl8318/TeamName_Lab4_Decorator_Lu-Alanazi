package weapon;

import gameplay.TimeObserver;
/**
 * Represent a weapon.
 * 
 * @author Jixiang Lu
 *
 */
public interface Weapon extends TimeObserver
{
	/**
	 * Gets how much damage will be caused to fire once per round.
	 * 
	 * @param distance The distance between the weapon and target.
	 * @return the value of damage.
	 */
	public int getDamage(int distance);
	
	/**
	 * Sets the Maximum number of Ammo which the weapon can carry.
	 * @param ammo the maximum number of ammo
	 */
	public void setMaxAmmo(int ammo);
	
	/**
	 * Gets the Maximum number of Ammo which the weapon can carry.
	 * @return the Maximum number of Ammo.
	 */
	public int getMaxAmmo();
	
	/**
	 * Sets the Rate of Fire.
	 * 
	 * @param rof the Rate of Fire.
	 */
	public void setRateOfFire(int rof);
	
	/**
	 * Gets the Rate of Fire.
	 * @return the Rate of Fire.
	 */
	public int getRateOfFire();
	
	/**
	 * Sets the Max Range the weapon can reach.
	 * @param range the max range.
	 */
	public void setMaxRange(int range);
	
	/**
	 * Gets the Max Range the weapon can reach.
	 * @return the maxRange.
	 */
	public int getMaxRange();
	
	/**
	 * Sets the base damage of the weapon.
	 * @param damage the base damage of the weapon
	 */
	public void setBaseDamage(int damage);
	
	/**
	 * Gets the base damage of the weapon.
	 * @return the base damage of the weapon.
	 */
	public int getBaseDamage();
	
	/**
	 * Sets the Rate of Fire left actually.
	 * @param rof the Rate of fire left.
	 */
	public void setActualRateFire(int rof);
	
	/**
	 * Gets the Rate of Fire left actually.
	 * @return the rate of fire left.
	 */
	public int getActualRateFire();
	
	/**
	 * Sets the actual number of ammo left.
	 * @param ammo the actual number of ammo left.
	 */
	public void setActualAmmo(int ammo);
	
	/**
	 * Gets the actual number of ammo left.
	 * @return the actual number of ammo left.
	 */
	public int getActualAmmo();
	
	/**
	 * Reload the weapon.
	 */
	public void reloadWeapon();
	
	/**
	 * Sets the number of attachments which the weapon has
	 * @param attachment the number of attachment.
	 */
	public void setNumberOfAttachment(int attachment);
	
	/**
	 * Gets the number of attachments which the weapon has
	 * @return the number of attachment.
	 */
	public int getNumberOfAttachment();
	
	/**
	 * Gets the damage which caused by multiple fire base on this distance.
	 * @param distance the distance between weapon and target.
	 * @param fireRate the times of fire
	 * @return the value of damage
	 */
	public int getDamageByrate(int distance, int fireRate);
}
