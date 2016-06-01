package weapon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import gameplay.SimpleTimer;

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
		wp.setBaseDamage(20);
		assertEquals(20,wp.getBaseDamage());
		wp.setRateOfFire(3);
		assertEquals(3,wp.getRateOfFire());
		wp.setActualRateFire(1);
		assertEquals(1,wp.getActualRateFire());
		wp.setMaxRange(50);
		assertEquals(50,wp.getMaxRange());
		//test reloadWeapon
		wp.reloadWeapon();
		assertEquals(5,wp.getActualAmmo());
	}
	
	/**
	 * Test getDamageByrate method.
	 */
	@Test
	public void testGetDamageByRate()
	{
		Weapon wp = new MockWeapon(10,25,2,10);
		//fireRate > actual fireRate
		int result = wp.getDamageByrate(2, 3);
		assertEquals(4,result);
		assertEquals(0,wp.getActualRateFire());
		
		//fireRate < actual fireRate
		wp.setActualRateFire(5);
		result = wp.getDamageByrate(2, 3);
		assertEquals(6,result);
		assertEquals(2,wp.getActualRateFire());
	}

	/**
	 * A SimpleTimer for the test and have the weapon observe it.
	 * Test that the rate of fire works good. 
	 */
	@Test
	public void testRateOfFire()
	{
		SimpleTimer time = new SimpleTimer();
		Weapon wp = new MockWeapon(10,25,2,5);
		time.addTimeObserver(wp);
		//fire maximum times
		int damage = wp.getDamageByrate(3, 2);
		assertEquals(6,damage);
		assertEquals(3,wp.getActualAmmo());
		//no ammo was waste
		damage = wp.getDamageByrate(3, 2);
		assertEquals(3,wp.getActualAmmo());
		//can't fire
		assertEquals(0,damage);
		//Have one unit of time pass
		time.timeChanged();
		assertEquals(2, wp.getActualRateFire());
		//fire again
		damage = wp.getDamageByrate(3, 2);
		assertEquals(6,damage);
		//one ammo left
		time.timeChanged();
		damage = wp.getDamageByrate(3, 2);
		assertEquals(6,damage);
		assertEquals(0,wp.getActualAmmo());
		
	}
}
