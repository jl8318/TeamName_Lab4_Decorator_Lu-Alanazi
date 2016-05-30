package recovery;

/**
 * An interface represent the Recovery Behavior.
 * 
 * @author Jixiang Lu
 *
 */
public interface RecoveryBehavior
{
	/**
	 * Returns the current LifePoint after do
	 * Recovery Behavior.
	 * 
	 * @param currentLife the current LifePoints
	 * @param maxLife the maximum LifePoint
	 * @return the current LifePoint after do Recovery Behavior
	 */
	public int calculateRecovery(int currentLife, int maxLife);
}
