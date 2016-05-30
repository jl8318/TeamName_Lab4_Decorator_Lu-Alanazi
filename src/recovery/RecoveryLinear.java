package recovery;

/**
 * A RecoveryBehavior which recover a fixed amount each time.
 * 
 * @author Jixiang Lu
 *
 */
public class RecoveryLinear implements RecoveryBehavior
{
	private int recoveryStep;
	
	/**
	 * Construct a linear RecoveryBehavior.
	 * 
	 * @param step fixed amount of points.
	 */
	public RecoveryLinear(int step)
	{
		this.recoveryStep = step;
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
		if(currentLife <= 0)
		{
			return 0;
		}
		else if((currentLife+this.recoveryStep)>=maxLife)
		{
			return maxLife;
		}
		else
		{
			return currentLife+this.recoveryStep;
		}
	}
	

}
