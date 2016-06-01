package weapon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import exceptions.AttachmentException;

public class TestAttachment
{

	@Test
	public void testInitialization() throws AttachmentException
	{
		Weapon wp = new PlasmaCannon();
		Attachment at = new MockAttachment(wp);
		assertTrue(at instanceof Weapon);
		assertTrue(at instanceof Attachment);
		assertEquals(wp,at.getWeapon());
		assertEquals(4,at.getMaxAmmo());
		assertEquals(4,at.getActualAmmo());
		assertEquals(50,at.getBaseDamage());
		assertEquals(1,at.getRateOfFire());
		assertEquals(1,at.getActualRateFire());
		assertEquals(20,at.getMaxRange());
		
		assertEquals(2+50,at.getDamage(2));
	}
	
	@Test
	public void testSetter() throws AttachmentException
	{
		Weapon wp = new PlasmaCannon();
		Attachment at = new MockAttachment(wp);
		at.setMaxAmmo(5);
		assertEquals(5,at.getMaxAmmo());
		at.setActualAmmo(3);
		assertEquals(3,at.getActualAmmo());
		at.setBaseDamage(20);
		assertEquals(20,at.getBaseDamage());
		at.setRateOfFire(3);
		assertEquals(3,at.getRateOfFire());
		at.setActualRateFire(1);
		assertEquals(1,at.getActualRateFire());
		at.setMaxRange(50);
		assertEquals(50,at.getMaxRange());
		//test reloadWeapon
		at.reloadWeapon();
		assertEquals(5,at.getActualAmmo());
		//test setWeapon()
		wp = new PlasmaCannon(30,30,2,5);
		at.setWeapon(wp);
		assertEquals(wp,at.getWeapon());
	}

	/**
	 * Test  getDamageByrate method
	 * @throws AttachmentException
	 */
	@Test
	public void testGetDamageByrate() throws AttachmentException
	{
		Weapon wp = new PlasmaCannon();
		wp = new MockAttachment(wp);
		
		//fireRate > actual fireRate
		int result = wp.getDamageByrate(2, 3);
		assertEquals(52,result);
		assertEquals(0,wp.getActualRateFire());
		assertEquals(3,wp.getActualAmmo());
		
		//fireRate < actual fireRate
		wp.setActualRateFire(5);
		result = wp.getDamageByrate(2, 3);
		assertEquals(80,result);
		assertEquals(2,wp.getActualRateFire());
	}
	
	/**
	 * Test update method.
	 * @throws AttachmentException
	 */
	@Test
	public void testUpdate() throws AttachmentException
	{
		Weapon wp = new PlasmaCannon();
		wp = new MockAttachment(wp);
		wp.getDamageByrate(2, 3);
		assertEquals(0,wp.getActualRateFire());
		wp.updateTime(0);
		assertEquals(wp.getRateOfFire(),wp.getActualRateFire());
	}
	/**
	 * 
	 * @throws AttachmentException
	 */
	@Test(expected =AttachmentException.class)
	public void testWrapWeapon() throws AttachmentException
	{
		//one attachment
		Weapon wp = new PlasmaCannon();
		wp = new MockAttachment(wp);
		assertEquals(2+50,wp.getDamage(2));
		
		//two attachment
		wp= new MockAttachment(wp);
		wp.reloadWeapon();
		assertEquals(4+50,wp.getDamage(2));
		
		//more than two attachment will throw AttachmentException
		wp = new MockAttachment(wp);
		
		
	}
}
