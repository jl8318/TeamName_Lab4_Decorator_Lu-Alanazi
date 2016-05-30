package recovery;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * A class is used to test RecoveryFractional class.
 * 
 * @author Jixiang Lu
 *
 */
public class TestRecoveryFractional
{
	private RecoveryBehavior rb;
	private double percent;
	
	/**
	 * Initialization a Fractional RecoveryBehavior with 0.05.
	 */
	@Before
	public void initialization()
	{
		percent =0.05;
		rb = new RecoveryFractional(percent);
	}
	
	/**
	 * Test the constructor of RecoveryFractional.
	 */
	@Test
	public void testInitialization()
	{
		assertTrue(rb instanceof RecoveryBehavior);
	}
	
	/**
	 * Test the situation current LifePoint is equal to
	 * Maximum LifePoint.
	 */
	@Test 
	public void noRecoveryWhenNotHurt()
	{
		int maxLifePts =30;
		int result = rb.calculateRecovery(maxLifePts,maxLifePts);
		assertEquals(result,30);
	}

	/**
	 * Test the situation:maxLP- currentLP > currentLP * persent
	 */
	@Test
	public void RecoveryReallyHurt()
	{
		int maxlpts =30;
		int cutlpts =20;
		int result = rb.calculateRecovery(cutlpts,maxlpts);
		int guessResult = (int)Math.ceil(cutlpts*(1+percent));
		assertEquals(result,guessResult);
	}
	
	/**
	 * Test the situation: 0<maxLP-CurrentLP< currentLP * persent
	 */
	@Test
	public void RecoveryLittleHurt()
	{
		int maxlpts =30;
		int cutlpts =29;
		int result = rb.calculateRecovery(cutlpts,maxlpts);
		assertEquals(result,maxlpts);
	}
	
	/**
	 * Test the situation: Current LifePoint is 0.
	 */
	@Test
	public void RecoveryDead()
	{
		int maxlpts =30;
		int cutlpts =0;
		int result = rb.calculateRecovery(cutlpts,maxlpts);
		assertEquals(result,0);
	}

}
