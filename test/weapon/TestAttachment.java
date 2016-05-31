package weapon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestAttachment
{

	@Test
	public void testInitialization() 
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
		
		assertEquals(2,at.getDamage(2));
	}
	
	@Test
	public void TestSetter()
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

}
