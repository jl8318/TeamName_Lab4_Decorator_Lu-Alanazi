package lifeform;

import recovery.RecoveryBehavior;
import recovery.RecoveryNone;
import exceptions.MyNewException;
/**
 * The Alien class which is subclass of LifeForm. It represents
 * an Alien with an ability to recovery its LifePoint.
 * 
 * @author Jixiang Lu
 *
 */
public class Alien extends LifeForm
{
	private int MaxLifePoints;
	private RecoveryBehavior recoverBehavior;
	private int recoveryRate;
	
	/**
	 * Construct an Alien without an recovery behavior and RecoveryRate.
	 * 
	 * @param name the name of Alien
	 * @param life the LifePoint of Alien
	 */
	public Alien(String name, int life) throws MyNewException
	{
		this(name, life,new RecoveryNone(),1);
	}
	
	/**
	 * Construct an Alien with specific recovery behavior, not RecoveryRate.
	 * 
	 * @param name the name of Alien
	 * @param life the LifePoint of Alien
	 * @param rb the RecoveryBehavior of Alien
	 */
	public Alien(String name, int life, RecoveryBehavior rb) throws MyNewException
	{
		this(name, life,rb,1);
	}

	/**
	 * Construct An Alien with name, life, RecoveryBehavior and RecoveryRate.
	 *  
	 * @param name the name of Alien
	 * @param life the LifePoint of Alien
	 * @param rb the RecoveryBehavior of Alien
	 * @param recoveryRate the Recovery Rate of Alien
	 * @throws MyNewException the Recovery Rate is negative.
	 */
	public Alien(String name, int life,RecoveryBehavior rb,int recoveryRate) throws MyNewException
	{
		super(name,life);
		this.MaxLifePoints= life;
		this.recoverBehavior = rb;
		this.setAttackStrength(10);
		if(recoveryRate>=0)
			this.recoveryRate = recoveryRate;
		else
			throw new MyNewException("In the Constructor of Alien Class: The recoveryRate can't be negative!");
	}
	/**
	 * Gets the maximum value of LifePoint.
	 * 
	 * @return the maximum value of LifePoint.
	 */
	public int getMaxLifePoints()
	{
		return this.MaxLifePoints;
	}

	/**
	 * Recovery LifePoint based on the recovery behavior of Alien
	 */
	public void recovery()
	{
		
		setCurrentLifePoints(recoverBehavior.calculateRecovery(getCurrentLifePoints(),MaxLifePoints));
	}
	
	/**
	 * Sets the Recovery Rate.
	 * 
	 * @param rate the Recovery Rate
	 * @throws MyNewException the Recovery Rate is negative.
	 */
	public void setRecoveryRate(int rate) throws MyNewException
	{
		if(rate>=0)
		 this.recoveryRate = rate;
		else
			throw new MyNewException("In the settle of Alien Class: The recoveryRate can't be negative!");
	}
	
	/**
	 * Gets the Recovery Rate.
	 * @return the Recovery Rate
	 */
	public int getRecoveryRate()
	{
		return this.recoveryRate;
	}

	/**
	 * The alien will recover every RecoveryRate round.
	 */
	@Override
	public void updateTime(int time)
	{
		this.setTime(time);
		if(this.recoveryRate!=0 && this.getTime()%this.recoveryRate==0)
			this.recovery();
			
		
	}
}
