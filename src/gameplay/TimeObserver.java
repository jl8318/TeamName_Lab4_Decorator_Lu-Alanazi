package gameplay;

/**
 * An observer interface. When a specific time passes,
 * its updataTime will be Called.
 * 
 * @author Jixiang Lu
 *
 */
public interface TimeObserver
{
	/**
	 * Gets the notify when the time changes.
	 * @param time the changed time.
	 */
	public void updateTime(int time);
}
