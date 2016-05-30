package lifeform;

import static org.junit.Assert.assertEquals;
import gameplay.SimpleTimer;

import org.junit.Test;

/**
 * Test the functionality provided by the LifeForm class.
 * @author Jixiang Lu
 *
 */
public class TestLifeForm 
{
	/*
	 *This Section for updating LifeForm so that the LifeForms can
	 *attack each other. It is still for the Strategy Pattern. (Lab 3)
	 */
	/**
	 * Test Attack function and the attackStrength instance variable.
	 */
	@Test
	public void testAttack()
	{
		LifeForm entity = new MockLifeForm("Bob",50);
		LifeForm entity2 = new MockLifeForm("Jack",60);
		
		//test attackStrength instance variable
		assertEquals(0,entity.getAttackStrength());
		entity.setAttackStrength(5);
		assertEquals(5,entity.getAttackStrength());
		
		//test attack method
		entity.attack(entity2);
		assertEquals(55, entity2.getCurrentLifePoints());
		entity.setAttackStrength(60);
		//test the LifePoint can drop below 0.
		entity.attack(entity2);
		assertEquals(0,entity2.getCurrentLifePoints());
		entity.attack(entity2);
		assertEquals(0,entity2.getCurrentLifePoints());
		
		//test dead can't attack
		entity2.setAttackStrength(5);
		entity2.attack(entity);
		assertEquals(50,entity.getCurrentLifePoints());
				
	}
	
	/**
	 * Test update method.
	 */
	@Test
	public void testUpdate()
	{
		LifeForm entity = new MockLifeForm("Bob",50);
		SimpleTimer st = new SimpleTimer();
		st.addTimeObserver(entity);
		st.timeChanged();
		assertEquals(1,entity.getTime());
	}
	
	/**
	 * Test setTime method
	 */
	@Test
	public void testSetTime()
	{
		LifeForm entity = new MockLifeForm("Bob",50);
		entity.setTime(5);
		assertEquals(5,entity.getTime());
	}
	
	/*
	 * Start Section for Strategy Pattern Tests.(Lab 1 and Lab 2)
	 */
	/**
	 * When a LifeForm is created, it should know its name and how
	 * many life points it has.
	 */
	@Test
	public void testInitialization() 
	{
		LifeForm entity;
		entity = new MockLifeForm("Bob",40);
		assertEquals("Bob",entity.getName());
		assertEquals(40,entity.getCurrentLifePoints());
		
		entity = new MockLifeForm("Bob",0);
		assertEquals(null,entity.getName());
		assertEquals(0,entity.getCurrentLifePoints());
	}
	
	/**
	 * Test setCurrentLifePoints method. The LifePoint can 
	 * not be below 0.
	 */
	@Test
	public void testSetCurrentLifePoints()
	{
		LifeForm entity = new MockLifeForm("Bob",40);
		entity.setCurrentLifePoints(50);
		assertEquals(50,entity.getCurrentLifePoints());
		entity.setCurrentLifePoints(-100);
		assertEquals(0,entity.getCurrentLifePoints());
		
	}
	
	/**
	 * Test the takeHit method. This method can reduce the amount of
	 *  LifePoint.
	 */
	@Test
	public void testTakeHit()
	{
		LifeForm entity = new MockLifeForm("Bob",40);
		entity.takeHit(20);
		assertEquals(20,entity.getCurrentLifePoints());
		entity.takeHit(5);
		assertEquals(15,entity.getCurrentLifePoints());
		
		//The LifePoint cannot go below 0 life point.
		entity.takeHit(100);
		assertEquals(0,entity.getCurrentLifePoints());
		
		//Take attack when the currentLifepoint is 0.
		entity.takeHit(10);
		assertEquals(0,entity.getCurrentLifePoints());
	}
	


}
