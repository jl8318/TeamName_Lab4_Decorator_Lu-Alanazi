package gameplay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test the functionality provided by the SimpleTimer class,interface Timer and interface
 * TimerObserver.
 * 
 * @author Jixiang Lu
 *
 */
public class TestSimpleTimer
{

	/**
	 * Test SimpleTimer class and Mock class initialize.
	 */
	@Test
	public void testInitialization()
	{
		MockSimpleTimerObserver observer = new MockSimpleTimerObserver();
		assertTrue(observer instanceof TimeObserver);
		assertEquals(0,observer.mytime);
		
		//Constructor with no parameter.
		SimpleTimer subject = new SimpleTimer();
		assertTrue(subject instanceof Timer);
		assertEquals(0,subject.getRound());
		assertEquals(0,subject.getTimeObserverList().size());
		assertEquals(1000,subject.getSleeptime());
		
		//Constructor with one parameter is sleeptime.
		subject = new SimpleTimer(1000);
		assertEquals(0,subject.getRound());
		assertEquals(0,subject.getTimeObserverList().size());
		assertEquals(1000,subject.getSleeptime());
		
	}
	
	/**
	 * Test the AddTimeObserver method.
	 */
	@Test
	public void testAddTimeObserver()
	{
		SimpleTimer subject = new SimpleTimer();
		MockSimpleTimerObserver observer = new MockSimpleTimerObserver();
		subject.addTimeObserver(observer);
		subject.timeChanged();
		//update time and receive time
		assertEquals(1,subject.getRound());
		assertEquals(1,observer.mytime);
		
		assertEquals(1,subject.getTimeObserverList().size());
	}
	
	/**
	 * Test the RemoveTimeObserver method.
	 */
	@Test
	public void testRemoveTimeObserver()
	{
		SimpleTimer subject = new SimpleTimer();
		MockSimpleTimerObserver observer = new MockSimpleTimerObserver();
		subject.addTimeObserver(observer);
		subject.timeChanged();
		assertEquals(1,observer.mytime);
		subject.removerTimeObserver(observer);
		subject.timeChanged();;
		assertEquals(1,observer.mytime);
		
		assertEquals(0,subject.getTimeObserverList().size());
	}
	
	/**
	 * Test the SimpleTimer run as Thread
	 * @throws InterruptedException
	 */
	@Test
	public void testSimpleTimerAsThread() throws InterruptedException
	{
		SimpleTimer st = new SimpleTimer(1000);
		st.start();
		Thread.sleep(250);
		for(int i = 0;i<5;i++)
		{
			assertEquals(i,st.getRound());
			Thread.sleep(1000);
		}
	}

}

/**
 * A Mock class is used to test interface TimeObserver and SimpleTimer class.
 * @author Jixiang Lu
 *
 */
class MockSimpleTimerObserver implements TimeObserver
{
	public int mytime = 0 ;
	@Override
	public void updateTime(int time)
	{
		this.mytime = time;
		
	}
	
}