package lifeform;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import recovery.RecoveryBehavior;
import recovery.RecoveryFractional;
import recovery.RecoveryLinear;
import exceptions.MyNewException;
import gameplay.SimpleTimer;

/**
 * The class is used to test Alien class.
 * 
 * @author Jixiang Lu
 *
 */
public class TestAlien
{
	/*
	 * This section for test Alien heal
	 */

	/**
	 * Test constructor with four parameters and MyNewException
	 * 
	 * @throws MyNewException the RecoveryRate can't be negative.
	 */
	@Test(expected =MyNewException.class)
	public void testRecoveryRate() throws MyNewException
	{
		
		Alien al = new Alien("Bob",50,new RecoveryLinear(5),2);
		assertEquals(2,al.getRecoveryRate());
		al.setRecoveryRate(3);
		assertEquals(3,al.getRecoveryRate());
		al = new Alien("Bob",50, new RecoveryLinear(4),-10);	
	}
	
	/**
	 * Test setRecoveryRate method.
	 * 
	 * @throws MyNewException the RecoveryRate can't be negative.
	 */
	@Test(expected =MyNewException.class)
	public void testSetterRecoveryRate() throws MyNewException
	{
		Alien al = new Alien("Bob",50,new RecoveryLinear(5),2);
		al.setRecoveryRate(-100);
	}
	
	/**
	 * Test the constructor after Refactor.
	 * 
	 * @throws MyNewException
	 */
	@Test
	public void testDefaultRecoveryRate() throws MyNewException
	{
		Alien al = new Alien("Bob",50);
		assertEquals(1,al.getRecoveryRate());
		al = new Alien("Bob",50,new RecoveryLinear(5));
		assertEquals(1,al.getRecoveryRate());
	}
	
	/**
	 * Test the alien will heal when the time changes.
	 * @throws MyNewException
	 */
	@Test
	public void testCombatRecvoery() throws MyNewException
	{
		Alien al = new Alien("Bob",200,new RecoveryLinear(5),2);
		SimpleTimer st = new SimpleTimer();
		st.addTimeObserver(al);
		
		//first round
		st.timeChanged();
		//take a damage from his god
		al.setCurrentLifePoints(1);
		int currenP= 1;
		//second round to 10th round
		for(int i =2;i<=10;i++)
		{
			st.timeChanged();
			int j = (i%2==0)?1:0;
			currenP +=j*5;
			assertEquals(currenP,al.getCurrentLifePoints());
		}
		
		//recovery rate =0
		al.setRecoveryRate(0);
		assertEquals(26,al.getCurrentLifePoints());
		for(int i=0 ;i<10;i++)
		{
			st.timeChanged();
			assertEquals(26,al.getCurrentLifePoints());
		}
		
		//test other recovery rate
		al.setRecoveryRate(1);
		for(int i =1; i<10;i++)
		{
			st.timeChanged();
			assertEquals(26+i*5,al.getCurrentLifePoints());
		}
		al = new Alien("Bob",200,new RecoveryFractional(0.05),5);
		al.setCurrentLifePoints(1);
		currenP=1;
		for(int i =1;i<=15;i++)
		{
			st.timeChanged();
			if(i%5==0)
				currenP += currenP*0.05;
			assertEquals(currenP,al.getCurrentLifePoints());
		}
		
		//test remove observer, and no recovery 
		st.removerTimeObserver(al);
		st.timeChanged();
		assertEquals(currenP,al.getCurrentLifePoints());
		
	}
	/*
	 *This Section for updating Alien so that the Alien can
	 *attack each other and attack other LifeForm. It is still 
	 *for the Strategy Pattern.(Lab 3)
	 */

	/**
	 * Test the Alien has a default attack strength of 10.
	 * And test Alien takes damage properly using the new attack method.
	 */
	@Test
	public void testAttack()throws MyNewException
	{
		//the default attack strength is 10.
		Alien al = new Alien("Bob",50);
		assertEquals(10,al.getAttackStrength());
		Alien al2 = new Alien("Jack",60, new RecoveryLinear(5));
		assertEquals(10,al2.getAttackStrength());
		
		//normal attack
		al.attack(al2);
		assertEquals(50,al2.getCurrentLifePoints());
		////test the LifePoint can drop below 0
		al.setAttackStrength(60);
		al.attack(al2);
		assertEquals(0,al2.getCurrentLifePoints());
		
		//Dead can't attack.
		al2.attack(al);
		assertEquals(50, al.getCurrentLifePoints());
	}

	/*
	 * Start Section for Strategy Pattern Tests.(Lab 1 and Lab 2)
	 */
	/**
	 * Test the construction of Alien with two parameters.
	 */
	@Test
	public void testInitialization()throws MyNewException
	{
		Alien al = new Alien("Bob",50);
		assertTrue(al instanceof LifeForm);
		assertEquals("Bob",al.getName());
		assertEquals(50,al.getCurrentLifePoints());
		assertEquals(50,al.getMaxLifePoints());

	}
	
	/**
	 * Test Default RecoveryBehavior(RecoveryNone). 
	 */
	@Test
	public void testDefultConstructRecorvery()throws MyNewException
	{
		Alien al = new Alien("Bob",50);
		int hitpls =10;
		int maxpls= 50;
		al = new Alien("Bob",maxpls);
		al.takeHit(hitpls);
		assertEquals(50-hitpls,al.getCurrentLifePoints());
		al.recovery();
		assertEquals(50-hitpls,al.getCurrentLifePoints());
	}
	/**
	 * Test An Alien with specific RecoveryBehavior(RecoveryLinear and Recovery
	 * Fractional).
	 */
	@Test
	public void testRecovery() throws MyNewException
	{
		Alien al = new Alien("Bob",50);
		int maxpls= 50;
		int hitpls =10;
		int rcypls =7;
		
		//test RecoveryLinear for the alien class.
		RecoveryBehavior rb = new RecoveryLinear(rcypls);
		al = new Alien("Bob",maxpls,rb);
		//test upper bound
		al.recovery();
		assertEquals(maxpls,al.getCurrentLifePoints());
		al.takeHit(hitpls);
		assertEquals(maxpls-hitpls,al.getCurrentLifePoints());
		//test normal
		al.recovery();
		assertEquals(maxpls-hitpls+rcypls,al.getCurrentLifePoints());
		al.takeHit(maxpls);
		//test lower bound
		al.recovery();
		assertEquals(0,al.getCurrentLifePoints());
		
		
		//test RecoveryFractional for the alien class.
		double percent = 0.50;
		hitpls = 30;
		rb = new RecoveryFractional(percent);
		al = new Alien("Bob",maxpls,rb);
		//test upper bound
		al.recovery();
		assertEquals(maxpls,al.getCurrentLifePoints());
		al.takeHit(hitpls);
		assertEquals(maxpls-hitpls,al.getCurrentLifePoints());
		//test normal
		al.recovery();
		int result = (int)Math.ceil((maxpls-hitpls)*(1+percent));
		assertEquals(result,al.getCurrentLifePoints());
		al.takeHit(maxpls);
		//test lower bound
		al.recovery();
		assertEquals(0,al.getCurrentLifePoints());
		
	}
	
	
}
