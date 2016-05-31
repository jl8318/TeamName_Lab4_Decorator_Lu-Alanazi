package weapon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestGenericWeapon {

	@Test
	public void testInitialization() 
	{
		Weapon wp = new MockWeapon(10,25,2,10);
		assertTrue(wp instanceof Weapon);
		assertEquals(10,wp.getMaxAmmo());
		assertEquals(10,wp.getActualAmmo());
		assertEquals(10,wp.getBaseDamage());
		assertEquals(2,wp.getRateOfFire());
		assertEquals(2,wp.getActualRateFire());
		assertEquals(25,wp.getMaxRange());
		
		assertEquals(2,wp.getDamage(2));
		
	}
	
	@Test
	public void testAllSetter()
	{
		Weapon wp = new MockWeapon(10,25,2,10);
		assertTrue(wp instanceof Weapon);
		wp.setMaxAmmo(5);
		assertEquals(5,wp.getMaxAmmo());
		wp.setActualAmmo(3);
		assertEquals(3,wp.getActualAmmo());
		
		assertEquals(10,wp.getBaseDamage());
		assertEquals(2,wp.getRateOfFire());
		assertEquals(2,wp.getActualRateFire());
		assertEquals(25,wp.getMaxRange());
		
	}

}
