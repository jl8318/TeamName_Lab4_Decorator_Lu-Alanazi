package recovery;

/**
 * A Recovery Behavior without any recovery ability.
 * 
 * @author Jixiang Lu
 *
 */
public class RecoveryNone implements RecoveryBehavior
{

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
		return (currentLife>=0)?currentLife:0;
	}
	
}
