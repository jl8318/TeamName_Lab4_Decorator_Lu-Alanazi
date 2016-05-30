package recovery;

/**
 * A recovery behavior which recover a certain fraction of 
 * the current life points.
 * 
 * @author Jixiang Lu
 *
 */
public class RecoveryFractional implements RecoveryBehavior
{
	private double percentRecovery;
	
	/**
	 * Construct a Fractional RecoveryBehavior.
	 * 
	 * @param percent the fraction which will be used
	 * to calculate the recovery LifePoint.
	 */
	public RecoveryFractional(double percent)
	{
		this.percentRecovery = percent;
	}
	
	/**
	 * Returns the current LifePoint after do
	 * Recovery Behavior.
	 * 
	 * @param currentLife the current LifePoints
	 * @param maxLife the maximum LifePoint
	 * @return the current LifePoint after do Recovery Behavior
	 */
	@Override
	public int calculateRecovery(int currentLife, int maxLife)
	{
		if(currentLife <=0)
			return 0;
		else if(Math.ceil(currentLife*(1+percentRecovery))>=maxLife)
		{
			return maxLife;
		}
		else
			return (int)Math.ceil(currentLife*(1+percentRecovery));
	}

}
