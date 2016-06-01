package weapon;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.AttachmentException;

/**
 * Test Stabilizer's combination
 * @author Jixiang Lu
 *
 */
public class TestStabilizer
{

	/**
	 * Test the Stabilizer's constructor
	 * 
	 * @throws AttachmentException
	 */
	@Test
	public void testInitialization() throws AttachmentException
	{
		Weapon wp = new PlasmaCannon();
		wp = new Stabilizer(wp);
		assertTrue(wp instanceof Attachment);
		assertTrue(wp instanceof Weapon);
	}

	/**
	 * Test the getDamage() method. There is one attachment.
	 * 
	 * @throws AttachmentException
	 */
	@Test
	public void testGetDamage() throws AttachmentException
	{
		Weapon wp = new PlasmaCannon();
		wp = new Stabilizer(wp);
		// |distance| > maxRange, still fire
		assertEquals(0, wp.getDamage(30));
		assertEquals(0, wp.getDamage(-30));

		// |distance| < maxRange
		float result = 50 * 2 / 4 * 1.25f;
		int r = (int) result;
		assertEquals(r, wp.getDamage(20));
		result = 50 * 1 / 4 * 1.25f;
		r = (int) result;
		assertEquals(r, wp.getDamage(15)); 

		// no ammon, automatically reload
		result = 50 * 4 / 4 * 1.25f;
		r = (int) result;
		assertEquals(r, wp.getDamage(15));

		// reload method
		wp.reloadWeapon();
		assertEquals(r, wp.getDamage(15));
	}

	/**
	 * Test the Scope + Stabilizer. There is two attachment.
	 * 
	 * @throws AttachmentException
	 */
	@Test(expected = AttachmentException.class)
	public void testScopeStabilizer() throws AttachmentException
	{
		Weapon wp = new PlasmaCannon();
		wp = new Scope(wp);
		wp = new Stabilizer(wp);
		// |distance| < maxRange
		assertEquals(77, wp.getDamage(15));
		assertEquals(68, wp.getDamage(10));

		// |distance|>maxRange

		assertEquals(0, wp.getDamage(25));
		assertEquals(0, wp.getDamage(-25));

		// automatically reload.
		assertEquals(77, wp.getDamage(15));

		// add attachment as a third attachment, will throws exception.
		wp = new Stabilizer(wp);

	}

	/**
	 * Test the Stabilizer + Stabilizer. There is two attachment.
	 * 
	 * @throws AttachmentException
	 */
	@Test
	public void testStabilizerDouble() throws AttachmentException
	{
		Weapon wp = new PlasmaCannon();
		wp = new Stabilizer(wp);
		wp = new Stabilizer(wp);

		// |distance| < maxRange
		assertEquals(77, wp.getDamage(15));
		assertEquals(57, wp.getDamage(15));

		// |distance|>maxRange
		assertEquals(0, wp.getDamage(25));
		assertEquals(0, wp.getDamage(-25));

		// automatically reload.
		assertEquals(77, wp.getDamage(15));
	}
	
	/**
	 * Test the Power Booster + Stabilizer. There is two attachment. 
	 */
	@Test
	public void testPowerBoosterStabilizer() throws AttachmentException
	{
		Weapon wp = new PlasmaCannon();
		wp = new PowerBooster(wp);
		wp = new Stabilizer(wp);

		// |distance| < maxRange
		assertEquals(125, wp.getDamage(15));
		assertEquals(80, wp.getDamage(15));

		// |distance|>maxRange
		assertEquals(0, wp.getDamage(25));
		assertEquals(0, wp.getDamage(-25));

		// automatically reload.
		assertEquals(125, wp.getDamage(15));
	}

}
