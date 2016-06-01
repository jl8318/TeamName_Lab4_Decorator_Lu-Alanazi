package weapon;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestScope {
	/**
	 * Test Initialization 
	 * @author Saad
	 */

	@Test
	public void testInitilization() {
		Weapon wp = new Pistol();
		wp = new Scope(wp);
		assertTrue(wp instanceof Attachment);
		assertTrue(wp instanceof Weapon);
		
	}
	/**
	 * Test GetDamage() meethod
	 * @author Saad
	 */
	
	@Test
	public void testGetDamage()
	{
		Weapon wp = new Pistol();
		wp = new Scope(wp);
		/**
		 * when the distance > max range still fire 
		 * @author Saad
		 */
		assertEquals(0 , wp.getDamage(30));
		assertEquals(0 , wp.getDamage(-30));
		/**
		 * when distance < max range 
		 * the distance = 25
		 * 2*(+25-25/25 =1 it should return 2 
		 */
		assertEquals(2 , wp.getDamage(25));
		assertEquals(2, wp.getDamage(-25));
		
	}
	/**
	 * Test the reload method
	 * @author Saad
	 */
	
	@Test
	public void testReaload()
	{
		Weapon wp = new Pistol();
		wp = new Scope(wp);
		
		/**
		 * when distance < max range 
		 * the distance = 25
		 * 2*(+25-25/25 =1 it should return 2 
		 * and the actual ammo is 9 now 
		 */
		assertEquals(2 , wp.getDamage(25));
		assertEquals(9, wp.getActualAmmo());
		/**
		 * now call the reload method , so the expected ammo is 10 
		 * @author Saad
		 */
		wp.reloadWeapon();
		assertEquals(10, wp.getActualAmmo());
		
		
	}

}
