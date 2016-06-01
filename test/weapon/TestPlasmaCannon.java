package weapon;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlasmaCannon {

	@Test
	public void testInitialization() {
		//test the construct without any parameters
		Weapon pc = new PlasmaCannon();
		assertTrue(pc instanceof Weapon);
		assertTrue(pc instanceof GenericWeapon);
		assertEquals(4,pc.getMaxAmmo());
		assertEquals(4,pc.getActualAmmo());
		assertEquals(50,pc.getBaseDamage());
		assertEquals(1,pc.getRateOfFire());
		assertEquals(1,pc.getActualRateFire());
		assertEquals(20,pc.getMaxRange());
		
		//test the construct with four parameters;
		pc = new PlasmaCannon(50,20,1,4);
		assertEquals(4,pc.getMaxAmmo());
		assertEquals(4,pc.getActualAmmo());
		assertEquals(50,pc.getBaseDamage());
		assertEquals(1,pc.getRateOfFire());
		assertEquals(1,pc.getActualRateFire());
		assertEquals(20,pc.getMaxRange()); 
		
	}
	
	@Test
	public void testGetDamage()
	{
		Weapon pc = new PlasmaCannon();
		// distance < maxRange
		int expect = 50*(4/4);
		assertEquals(expect,pc.getDamage(10));
		expect = 50*3/4;
		assertEquals(expect,pc.getDamage(10));
		expect = 50*2/4;
		assertEquals(expect,pc.getDamage(10));
		expect =  50*1/4;
		assertEquals(expect,pc.getDamage(10));
		//The actualAmmo == 0;
		assertEquals(0,pc.getDamage(10));
		//reload
		pc.reloadWeapon();
		expect = 50*(4/4);
		assertEquals(expect,pc.getDamage(10));
		//when the distance > MaxRange
		assertEquals(0,pc.getDamage(30));
	}

}
