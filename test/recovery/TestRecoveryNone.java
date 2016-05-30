package recovery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * A class is used to test RecoveryNone class.
 * @author Jixiang Lu
 *
 */
public class TestRecoveryNone
{

	private RecoveryNone rn;
	/**
	 * Initialization
	 */
	@Before
	public void initializaiton()
	{
		rn = new RecoveryNone();
	}
	/**
	 * Test the constructor
	 */
	@Test
	public void testInitialization()
	{
		assertTrue(rn instanceof RecoveryBehavior);
		
	}
	/**
	 * Test when the current point is equal to maximum points. 
	 */
	@Test
	public void testUpperBound()
	{
		int result = rn.calculateRecovery(1000,1000);
		assertEquals(result,1000);
	}
	
	/**
	 * Test when the current point is equal to or less than zero.
	 */
	@Test
	public void testLowerBount()
	{
		int result = rn.calculateRecovery(0,1000);
		assertEquals(result,0);
		result = rn.calculateRecovery(-10,1000);
		assertEquals(result,0);
	}
	/**
	 * /**
	 * Test when the current point is between 0 to maximum. 
	 */
	@Test
	public void testNormal()
	{
		int result = rn.calculateRecovery(500,1000);
		assertEquals(result,500);
	}

}
