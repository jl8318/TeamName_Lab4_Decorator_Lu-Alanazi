package lifeform;

import environment.Range;
import gameplay.TimeObserver;
import weapon.Weapon;

/**
 * Keeps track of the information associated with a simple life form. Also
 * provides the functionality related to the life form.
 * 
 * @author Jixiang Lu
 *
 */
public abstract class LifeForm implements TimeObserver
{
	private String myName;
	private int currentLifePoints;
	private int attackStrength;
	private int mytime;
	private Weapon weapon; 

	/**
	 * Create an LifeForm with the name, currentLifePoint and default 0
	 * attack Strength.
	 * 
	 * @param name
	 *            the name of the life form
	 * @param point
	 *            the current starting life points of the life form
	 */
	public LifeForm(String name, int point) 
	{
		if (point > 0) 
		{
			this.myName = name;
			this.currentLifePoints = point; 
			mytime = 0;
			this.weapon = null;
		} 
		else 
		{
			System.out.println("Bad value");
		}
		this.attackStrength = 0;
	}

	/**
	 * @return the name of the life form
	 */
	public String getName() 
	{

		return this.myName;
	}

	/**
	 * Gets the current LifePoints.
	 * 
	 * @return the amount of current life points the life form has.
	 */
	public int getCurrentLifePoints() 
	{

		return this.currentLifePoints;
	}
	
	/**
	 * Sets the Current LifePoints of an Alien
	 * 
	 * @param life the Current LifePoints
	 */
	public void setCurrentLifePoints(int life)
	{
		if(life>0)
			this.currentLifePoints = life;
		else
			this.currentLifePoints = 0;
	}

	/**
	 * Reduce the LifePoint according to the amount of damage.
	 * The LifePoint cannot go below 0 LifePoint.
	 * @param damage the amount of damage.
	 */
	public void takeHit(int damage)
	{
		if(damage > this.currentLifePoints)
			this.currentLifePoints = 0;
		else
			this.currentLifePoints -= damage;
		
	}

	/**
	 * Gets the how strong an attack the LifeForm processes.
	 * 
	 * @return attack strength of the LifeForm
	 */
	public int getAttackStrength()
	{
		return this.attackStrength;
	}

	/**
	 * Sets the how strong an attack the LifeForm processes.
	 * 
	 * @param attrackStrength the attack strength
	 */
	public void setAttackStrength(int attrackStrength)
	{
		this.attackStrength = attrackStrength;
	}

	/**
	 * Attack another LifeForm. If the LifeForm has a weapon, it will
	 * fire once. Otherwise, the damage is dependent on the attack strength.
	 * If the LifeForm is dead, it can't attack another LifeForm.
	 * @author Jixiang Lu
	 * @param attackedEntity the LifeForm will be attack.
	 */
	public void attack(LifeForm attackedEntity)
	{
		this.attack(attackedEntity, 1);
				
	}
	
	/**
	 * Attack another LifeForm. If the LifeForm has a weapon, it will
	 * fire <fireRate> times. Otherwise, the damage is dependent on the attack strength.
	 * @author Jixiang Lu 
	 * @param attackedEntity the LifeForm will be attack
	 * @param fireRate the number of fire times 
	 */
	public void attack(LifeForm attackedEntity,int fireRate)
	{
		if(this.currentLifePoints>0)
		{
			if(Range.distance<=5)
				attackedEntity.takeHit(this.attackStrength);
			else if(Range.distance<=10)
			{
				if(this.weapon==null||this.weapon.getActualAmmo()==0||this.weapon.getActualRateFire()==0)
				{
					attackedEntity.takeHit(this.attackStrength);
				}
				else
				{
					int damage = this.weapon.getDamageByrate(Range.distance, fireRate);
					attackedEntity.takeHit(damage);
				}
			}
			else
			{
				if(this.weapon==null||this.weapon.getActualAmmo()==0||this.weapon.getActualRateFire()==0)
				{
					attackedEntity.takeHit(0);
				}
				else
				{
					int damage = this.weapon.getDamageByrate(Range.distance, fireRate);
					attackedEntity.takeHit(damage);
				}
			}
		}
			
		else
		{
			//dead can't attack.
		}
	}
	/**
	 * Update the instance variable mytime.
	 */
	@Override
	public void updateTime(int time)
	{
		this.mytime = time;
	}

	/**
	 * Gets the current mytime.
	 * @return the current mytime
	 */
	public int getTime()
	{
		return this.mytime;
	}
	
	/**
	 * Sets the current mytime
	 * @param time the current mytime
	 */
	public void setTime(int time)
	{
		this.mytime = time;
	}

	/*
	 * Lab 4
	 * @author Jixiang Lu 
	 */
	
	/**
	 * Sets the weapon.
	 * @param weapon
	 */
	public void setWeapon(Weapon weapon)
	{
		this.weapon = weapon ; 
	}
	
	/**
	 * Gets the weapon.
	 * @return Weapon 
	 */
	public Weapon getWeapon()
	{
		return weapon ; 
	}

	/**
	 * Drop the weapon
	 */
	public void dropWeapon()
	{
		this.weapon = null;
		
	}
	
	/**
	 * Pick up the weapon. If the LifeForm has weapon, do nothing.
	 * @param wp2 The weapon should been picked up.
	 */
	public void pickUpWeapon(Weapon wp2)
	{
		if(this.weapon == null)
			this.setWeapon(wp2);
		
	}
	
	/**
	 * Reload the weapon. If the LifeForm has no weapon, do noting.
	 */
	public void reloadWeapon()
	{
		if(this.weapon!=null)
			weapon.reloadWeapon();
		else
		{
			//do nothing
		}
	}
	
	
	
	
	
}
