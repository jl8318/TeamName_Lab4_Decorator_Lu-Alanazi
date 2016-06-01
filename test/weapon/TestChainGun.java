package weapon;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestChainGun {

	
	/**
	 * Test the chain gun functioning without attachment 
	 */
	@Test
	public void testchaingun() {
		/**
		 * the distance is 20 , so 50*20/20 = 50 
		 */
		ChainGun cg = new ChainGun();
		assertEquals(15 , cg.getDamage(30));
		/**
		 * Test that the actual Ammo reduced by one 
		 */
		assertEquals(39, cg.getActualAmmo());
		
		
	}
	@Test
	public void testchaingunMax() {
		/**
		 * the distance is more than the max range so it should return zero
		 */
		ChainGun cg = new ChainGun();
		assertEquals(0 , cg.getDamage(40)); 
		/**
		 * even when the distance is more than the max range still can fire and ammo will be 
		 * reduced by one
		 */
		assertEquals(39, cg.getActualAmmo());  
		
		/**
		 * this to test if I passed negative value of distance 
		 */
		
		assertEquals(15 , cg.getDamage(30));
		assertEquals(38, cg.getActualAmmo());
	}
	
	/**
	 * Test the reload method for chain gun 
	 */
	
	@Test
	public void testReload() {
		
		ChainGun cg = new ChainGun();
		assertEquals(15 , cg.getDamage(30));
		/**
		 * No the actual ammo reduced by one 
		 */
		assertEquals(39, cg.getActualAmmo());
		/**
		 * call the reload function to test reload 
		 * and the actual ammo should be 4 
		 */
		cg.reloadWeapon();
		assertEquals(40, cg.getActualAmmo());
		
		
	}
	
	

}
