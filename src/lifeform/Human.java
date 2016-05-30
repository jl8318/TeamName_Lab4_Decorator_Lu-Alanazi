package lifeform;

/**
 * The Human class which is subclass of LifeForm. It represents
 * a human with an armor. 
 * 
 * @author Jixiang Lu
 *
 */

public class Human extends LifeForm
{
	private int armorPoints;
	private int timesWillDegrade;
	
	/**
	 * Create a Human with initial armor, a name and life points.
	 * 
	 * @param name The name of human
	 * @param life  the life point of human
	 * @param armor the value of armorPoints.
	 */
	public Human(String name, int life, int armor)
	{
		super(name,life);
		if(armor < 0)
			armorPoints = 0;
		else
			armorPoints = armor;
		this.setAttackStrength(5);
		this.timesWillDegrade = 75;
	}
	
	/**
	 * Gets the value of armorPoints
	 * 
	 * @return the value of armorPoints
	 */
	public int getArmorPoints()
	{
		return this.armorPoints;
	}

	/**
	 * Sets the value of armorPoints
	 * 
	 * @param armor the value will be used to set the value of armorPoints.
	 */
	public void setArmorPoints(int armor)
	{
		this.armorPoints = (armor>0) ? armor:0;	
	}
	
	/**
	 * Reduce the LifePoint according to the value of damage and armor.
	 * The LifePoint cannot go below 0 LifePoint.
	 * Human's armor will absorb some of the damage and will
	 * degrade if the armor is attacked over 75 times. The value of 
	 * damage is LifePoint + (armorPoints - damage) if armorPoints is
	 * less than the value of damage. Otherwise, the LifePoint will no change.
	 * 
	 * @param damage the value of damage.
	 */
	@Override
	public void takeHit(int damage)
	{
		if(this.getCurrentLifePoints()==0)
			this.setCurrentLifePoints(0);
		else 
		{
			int ifDamage = (this.armorPoints>=damage)?0:(this.armorPoints-damage);
			int actualPoints = getCurrentLifePoints()+ifDamage;
			if(actualPoints<=0)
				this.setCurrentLifePoints(0);
			else
				this.setCurrentLifePoints(actualPoints);
			if(timesWillDegrade>0)
				this.timesWillDegrade-=1;
			if(timesWillDegrade==0)
				armorPoints = 0;
		}
		
	}

	/**
	 * Gets how many times left the armor will degrade.
	 * @return
	 */
	public int getTimesWillDegrade()
	{
		
		return this.timesWillDegrade;
	}
	
	/**
	 * Sets how many times left the armor will degrade.
	 * @param times
	 */
	public void setTimesWillDegrade(int times)
	{
		
		this.timesWillDegrade = times;
	}
}
