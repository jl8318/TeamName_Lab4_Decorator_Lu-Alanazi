package weapon;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.AttachmentException;

public class TestScope {
	/**
	 * Test Initialization 
	 * @author Saad
	 */

	@Test
	public void testInitilization()throws AttachmentException
	{
		Weapon wp = new Pistol();
		wp = new Scope(wp);
		assertTrue(wp instanceof Attachment);
		assertTrue(wp instanceof Weapon);
		
	}
	/**
	 * Test GetDamage() method
	 * @author Saad
	 */
	
	@Test
	public void testGetDamage() throws AttachmentException
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
	public void testReaload() throws AttachmentException
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
	@Test
	public void testPistolScope() throws AttachmentException
	{
		Weapon wp = new Pistol();
		wp = new Scope(wp);
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
		 * when the distance > max range still fire 
		 * @author Saad
		 */
		assertEquals(0 , wp.getDamage(30));
		assertEquals(0 , wp.getDamage(-30));
		/**
		 * now call the reload method , so the expected ammo is 10 
		 * 
		 */
		wp.reloadWeapon();
		assertEquals(10, wp.getActualAmmo());
		
		
	}
	/**
	 * Test the Scope + Stabilizer. There is two attachment. 
	 */
	
	@Test
	public void testPistolScopeStab() throws AttachmentException
	{
		Weapon wp = new Pistol();
		wp = new Stabilizer(wp);
		wp = new Scope(wp);
		 assertEquals(9 , wp.getDamage(15));
		 assertEquals(9 , wp.getActualAmmo());
		
		/**
		 * now call the reload method , so the expected ammo is 10 
		 * 
		 */
		wp.reloadWeapon();
		assertEquals(10, wp.getActualAmmo());
		
		
	}
	
	/**
	 * Test the power Booster + Scoop. There is two attachment. 
	 */
	
	@Test
	public void testPistolpower() throws AttachmentException
	{
		Weapon wp = new Pistol();
		wp = new PowerBooster(wp);	
		wp = new Scope(wp);
		
        
		assertEquals(16, wp.getDamage(15));
		assertEquals(9 , wp.getActualAmmo());
		
		/**
		 * now call the reload method , so the expected ammo is 10 
		 * 
		 */
		wp.reloadWeapon();
		assertEquals(10, wp.getActualAmmo());
		
		
	}

}
