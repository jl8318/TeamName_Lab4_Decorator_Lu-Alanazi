package recovery;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * A class is used to test RecoveryLinear class.
 * 
 * @author Jixiang Lu
 *
 */
public class TestRecoveryLinear
{
	private RecoveryLinear rl;
	private int recoveryStep;
	
	/**
	 * Initialization a linear RecoveryBehavior with 7.
	 */
	@Before
	public void initialization()
	{
		rl = new RecoveryLinear(7);
		this.recoveryStep = 7;
	}
	
	/**
	 * Test the constructor of RecoveryLinear.
	 */
	@Test
	public void testInitialization()
	{
		assertTrue(rl instanceof RecoveryBehavior);
	}
	
	/**
	 * Test the situation current LifePoint is equal to
	 * Maximum LifePoint.
	 */
	@Test 
	public void noRecoveryWhenNotHurt()
	{
		int maxLifePts =30;
		int result = rl.calculateRecovery(maxLifePts,maxLifePts);
		assertEquals(result,30);
	}

	/**
	 * Test the situation:maxLP- currentLP > step
	 */
	@Test
	public void RecoveryReallyHurt()
	{
		int maxlpts =30;
		int cutlpts =20;
		int result = rl.calculateRecovery(cutlpts,maxlpts);
		assertEquals(result,cutlpts+this.recoveryStep);
	}
	
	/**
	 * Test the situation: 0<maxLP-CurrentLP<step
	 */
	@Test
	public void RecoveryLittleHurt()
	{
		int maxlpts =30;
		int cutlpts =25;
		int result = rl.calculateRecovery(cutlpts,maxlpts);
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
		int result = rl.calculateRecovery(cutlpts,maxlpts);
		assertEquals(result,0);
	}
}
