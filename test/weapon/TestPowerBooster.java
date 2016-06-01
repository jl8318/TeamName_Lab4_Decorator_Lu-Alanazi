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
		 * when the distance > max range still fire 
		 * 
		 */
		assertEquals(0 , wp.getDamage(30));
		/**
		 * when the distance < Max Range
		 * it it will call the getDanage function for chain Gun and the result is 50 
		 * so will calculate the chain gun and the result will be 87 
		 */
		assertEquals(87 , wp.getDamage(20));
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
	    assertEquals(100, wp.getDamage(20));
		/**
		 * when the distance > max range 
		 */
		assertEquals(0 , wp.getDamage(30));
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
		
		assertEquals(124 , wp.getDamage(20));
		assertEquals(54 , wp.getDamage(10));
		
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
		
		
		assertEquals(200 , wp.getDamage(20));
		assertEquals(75 , wp.getDamage(10)); 
		
		
	}
	


}
