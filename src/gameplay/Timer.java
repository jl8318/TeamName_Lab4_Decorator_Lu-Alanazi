package gameplay;

/**
 * An interface represent a subject. When the time passes, it
 * will notify all observers in its list.
 * 
 * @author Jixiang Lu
 *
 */
public interface Timer
{
	/**
	 * Adds observer into its list.
	 * 
	 * @param observer the observer will added
	 */
	public void addTimeObserver(TimeObserver observer);
	
	/**
	 * Removes the observer.
	 * 
	 * @param observer the observer will be removed.
	 */
	public void removerTimeObserver(TimeObserver observer);
	
	/**
	 * When time passes, the method will update time of all
	 * observers that are in the List.
	 */
	public void timeChanged();
}
