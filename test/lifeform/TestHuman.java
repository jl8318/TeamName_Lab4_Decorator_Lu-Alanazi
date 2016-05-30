package lifeform;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * This class is used to test the Human Class.
 * 
 * @author Jixiang Lu
 *
 */
public class TestHuman
{

	/*
	 *This Section for updating Human so that the Humans can
	 *attack each other and attack other LifeForm. It is still
	 *for the Strategy Pattern.(Lab 3)
	 */

	/**
	 * Test the Human has a default attack strength of 5.
	 * And test Human takes damage properly using the attack method.
	 */
	@Test
	public void testAttack()
	{
		//the default attack strength is 5.
		Human hm = new Human("Bob",50,0);
		Human hm2 = new Human("Jack",60,0);
		assertEquals(5,hm.getAttackStrength());
		
		//test the default times which the armor is effective
		assertEquals(75,hm.getTimesWillDegrade());
		//test settle (setTimesWillDegrade)
		hm.setTimesWillDegrade(10);
		assertEquals(10,hm.getTimesWillDegrade());
		
		//using the new attack method with 0 armor
		hm.attack(hm2);
		assertEquals(55,hm2.getCurrentLifePoints());
		//Dead can't attack.
		hm.setCurrentLifePoints(0);
		hm.attack(hm2);
		assertEquals(55, hm2.getCurrentLifePoints());
		//the LifePoint can't below 0
		hm2.attack(hm);
		assertEquals(0,hm.getCurrentLifePoints());
		
		//The attacked times are less than 75 times.
		//The point of armor is greater than the damage.
		hm.setCurrentLifePoints(500);
		hm.setArmorPoints(10);
		hm2.attack(hm);
		assertEquals(500,hm.getCurrentLifePoints());
		//The point of armor is less than the damage.
		hm.setArmorPoints(4);
		hm2.attack(hm);
		assertEquals(499, hm.getCurrentLifePoints());
		//The human will be killed with armor if damage is enough
		hm2.setAttackStrength(600);
		hm2.attack(hm);
		assertEquals(0,hm.getCurrentLifePoints());
		
		//the attacked times are greater than 75 times.
		// the armor degrade.
		hm = new Human("Bob",50,10);
		hm2.setAttackStrength(5);
		for(int i = 0;i<75+1;i++)
		{
			hm2.attack(hm);
		}
		assertEquals(45,hm.getCurrentLifePoints());				
	}

	/*
	 * Start Section for Strategy Pattern Tests.(Lab 1 and Lab 2)
	 */
	/**
	 * Check the initialization of the Human Class
	 */
	@Test
	public void testInitialization()
	{
		Human hm = new Human("Bob", 40, 30);
		assertTrue(hm instanceof LifeForm);
		assertEquals("Bob", hm.getName());
		assertEquals(40, hm.getCurrentLifePoints());

		// test the getArmorpoints
		assertEquals(30, hm.getArmorPoints());

		// The armorPoints cannot be less than zero
		hm = new Human("Jam", 40, -100);
		assertEquals(0, hm.getArmorPoints());

	}

	/**
	 * Check the setArmorPoints
	 */
	@Test
	public void testSetArmorPoints()
	{
		Human hm = new Human("Bob", 40, 30);
		hm.setArmorPoints(20);
		assertEquals(20, hm.getArmorPoints());

		// The armorPoints cannot be less than zero
		hm.setArmorPoints(-200);
		assertEquals(0, hm.getArmorPoints());
	}
}
