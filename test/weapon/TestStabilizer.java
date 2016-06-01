package weapon;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStabilizer
{

	@Test
	public void testInitialization()
	{
		Weapon wp =  new PlasmaCannon();
		wp = new Stabilizer(wp);
		assertTrue(wp instanceof Attachment);
		assertTrue(wp instanceof Weapon);
	}
	
	/**
	 * Test the getDamage() method.
	 */
	@Test
	public void testGetDamage()
	{
		Weapon wp =  new PlasmaCannon();
		wp = new Stabilizer(wp);
		// |distance| > maxRange, still fire
		assertEquals(0,wp.getDamage(30));
		assertEquals(0,wp.getDamage(-30));
		
		// |distance| < maxRange
		float result = 50*2/4*1.25f;
		int r = (int)result;
		assertEquals(r,wp.getDamage(20));
		result = 50*1/4*1.25f;
		r = (int)result;
		assertEquals(r,wp.getDamage(15));
		
		//no ammon, automatically reload 
		 result = 50*4/4*1.25f;
		 r = (int)result;
		assertEquals(r,wp.getDamage(15));
		
		//reload method
		wp.reloadWeapon();
		assertEquals(r,wp.getDamage(15));
	}

}
