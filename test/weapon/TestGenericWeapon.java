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
		assertEquals(10,wp.getBaseDamage());
		assertEquals(2,wp.getRateOfFire());
		assertEquals(25,wp.getMaxRange());
	}

}
