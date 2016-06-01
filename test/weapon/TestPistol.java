package weapon;

import static org.junit.Assert.*;
/**
 * Test Class to test the functionality of Pistol 
 * @author Saad
 */

import org.junit.Test;

import gameplay.SimpleTimer;

public class TestPistol 
{

	@Test
	public void testInitialization() 
	{
		/**
		 * Test the Initialization (the constructor of Pistol)
		 * @author Saad
		 */
		
		Pistol p = new Pistol(10 , 25 , 2 , 10);
	}
	
	/**
	 * test Pistol functioning correctly without attachment 
	 * here the distance is 25 , so 10*(25-25)+5 / 25 = 2 
	 * @author Saad
	 */
	@Test
	public void testfunction() 
	{
		/**
		 * Test the Initialization 
		 */
		
		Pistol p = new Pistol();
		assertEquals(2, p.getDamage(25)); 
		/**
		 * the actual Ammo reduced by one 
		 */
		assertEquals(9 , p.getActualAmmo());
		
		
	}
	
	/**
	 * Test pistol if the distance is more than the max range
	 * in this case it  should return zero 
	 * @author Saad
	 */
	@Test
	public void testmaxrange() 
	{
		Pistol p = new Pistol();
		assertEquals(0, p.getDamage(30)); 
		/**
		 * even when the distance is more than the max range still can fire and ammo will be 
		 * reduced by one
		 * @author Saad
		 */
		assertEquals(9, p.getActualAmmo()); 
		
		
		 
	} 
	@Test
	public void testnigative() 
	{
		Pistol p = new Pistol();

		/**
		 * When the distance value is negative number 
		 * @author Saad
		 */
		assertEquals(2 , p.getDamage(-25));
		assertEquals(9, p.getActualAmmo());
		 
	} 
	
	/**
	 * Test the reload function 
	 * @author Saad
	 */
	
	@Test
	public void testReload() 
	{
		Pistol p = new Pistol();

		/**
		 * When the distance value is negative number 
		 */
		assertEquals(2 , p.getDamage(-25));
		/**
		 * here the the actual amount reduced by one
		 */
		assertEquals(9, p.getActualAmmo());
		/**
		 * here call the reload weapon to test the reload function 
		 */
		p.reloadWeapon();
		assertEquals(10 , p.getActualAmmo());
		 
	}
	
	
	
	
	
	
	

}
