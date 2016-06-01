package weapon;

import static org.junit.Assert.*;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.junit.Test;

import exceptions.AttachmentException;

public class TestPowerBooster {


	/**
	 * Test PowerBooster Initialization 
	 * @author Saad
	 */

	@Test
	public void testInitilization()throws AttachmentException
	{
		Weapon wp = new ChainGun();
		wp = new PowerBooster(wp);
		assertTrue(wp instanceof Attachment);
		assertTrue(wp instanceof Weapon);
		
	}
	/**
	 * Test  PowerBooster GetDamage() Method  
	 * @author Saad
	 */
	
	@Test
	public void testGetDamage() throws AttachmentException
	{
		Weapon wp = new ChainGun();
		wp = new PowerBooster(wp);
		
		/**
		 * when the distance < Max Range
		 * it it will call the getDamage function for chain Gun and the result is 15 
		 * so will calculate the chain gun and the result will be 30 
		 */
		
		assertEquals(30, wp.getDamage(30));
		assertEquals(39 , wp.getActualAmmo());
		/**
		 * when the distance > max range still fire 
		 * 
		 */
		assertEquals(0 , wp.getDamage(40)); 
		/**
		 * Test Reload Method
		 */
		wp.reloadWeapon();
		assertEquals(40, wp.getActualAmmo());
	}
	
	/**
	 * Test the power Booster + Scoop. There is two attachment. 
	 */
	@Test
	public void testPowerBoosterScope() throws AttachmentException
	{
		Weapon wp = new ChainGun();
		wp = new Scope(wp);
		wp = new PowerBooster(wp);
		/**
		 * It call the get Damage Method for chain gun and calculate Scope and booster
		 */
		
	    assertEquals(30, wp.getDamage(30));
		/**
		 * when the distance > max range 
		 */
		assertEquals(0 , wp.getDamage(40));
				
	}
    
	/**
	 * Test the power Booster + Stabilizer. There is two attachment. 
	 */
	@Test
	public void testPowerBoosterStabilizer() throws AttachmentException
	{
		Weapon wp = new ChainGun();
		wp = new Stabilizer(wp);
		wp = new PowerBooster(wp);
		
		
		assertEquals(36 , wp.getDamage(30));
	    assertEquals(11 , wp.getDamage(10));
		
		
	}
	
	/**
	 * Test the power Booster + PowerBooster. There is two attachment. 
	 */
	@Test
	public void testPowerBoosterPowerBooster() throws AttachmentException
	{
		Weapon wp = new ChainGun();
		wp = new PowerBooster(wp);
		wp = new PowerBooster(wp); 
		
		
		assertEquals(60 , wp.getDamage(30)); 
		assertEquals(57 , wp.getDamage(30)); 
		
		
	}

	


}
