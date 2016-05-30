package gameplay;

import java.util.ArrayList;

/** 
 * Keeps track of what round the game is in. Starts at round 0 and increments the value by 1
 * each time timeChanged is called. Additionally, it calls the updataTime function of all 
 * observing observers.
 * 
 * @author Jixiang Lu
 *
 */
public class SimpleTimer extends Thread implements Timer
{
	private int round;
	private ArrayList<TimeObserver> theObservers;
	private int sleeptime;
	private final static int ROUND_FIX = 50;// the fixed number, the game will finish after ROUNF_FIX rounds
	
	/**
	 * Constructor with default sleep time = 1000.
	 */
	public SimpleTimer()
	{
		this(1000);
		
	}
	
	/**
	 * Constructor with specific sleep time.
	 * sleep time is equals to the parameter sleeptime.
	 * 
	 * @param sleeptime sleep time will be set.
	 */
	public SimpleTimer(int sleeptime)
	{
		this.round = 0;
		this.theObservers = new ArrayList<TimeObserver>();
		this.sleeptime = sleeptime;
	}
	
	/**
	 * Adds the observer into List.
	 */
	@Override
	public void addTimeObserver(TimeObserver observer)
	{
		this.theObservers.add(observer);
		
	}

	/**
	 * Removes the observer from List
	 */
	@Override
	public void removerTimeObserver(TimeObserver observer)
	{
		this.theObservers.remove(observer);
		
	}
	
	
	/**
	 * It will call update method of all observers in its list when the method is called.
	 */
	@Override
	public void timeChanged()
	{
		round++;
		for(TimeObserver ob: this.theObservers)
		{
			ob.updateTime(round);
		}
		
	}
	
	/**
	 * The game will run for 50 round. It will call timeChanged every sleeptime.
	 */
	@Override
	public void run()
	{
		
		try
		{	this.round = 0;
			//the game will run for 50 round
			while(this.round<ROUND_FIX)
			{				
				sleep(this.sleeptime);
				this.timeChanged();
			}
			//when the game finish remove all the observers(not sure)
			//this.theObservers.clear();
		}
		catch(InterruptedException ex)
		{
			System.out.println("InterruptedException occurs in SimpleTimer.java");
		}

	}
	
	/**
	 * Gets the current rounds
	 * 
	 * @return the current rounds
	 */
	public int getRound()
	{
		return this.round;
	}
	
	/**
	 * Gets the ArrayList that contains all added observers.
	 * @return
	 */
	public ArrayList<TimeObserver> getTimeObserverList()
	{
		return this.theObservers;
	}
	
	/**
	 * Gets the sleep time.
	 * 
	 * @return the sleep time
	 */
	public int getSleeptime()
	{
		return this.sleeptime;
	}
	


}
