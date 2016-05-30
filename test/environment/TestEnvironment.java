package environment;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

import org.junit.Test;

/**
 * The test cases for the Environment class
 * @author Jixiang Lu
 *
 */
public class TestEnvironment
{

	/**
	 * At initialization, the Cells in the Environment 
	 * should be empty and not contain a LifeForm.
	 */
	@Test
	public void testInitialization()
	{
		Environment env = new Environment(1, 1);
		assertNull(env.getLifeForm(0, 0));
	}

	/**
	 * Check the addLifeForm method.
	 */
	@Test
	public void testAddLifeForm()
	{
		Environment env = new Environment(2, 3);
		LifeForm bob = new MockLifeForm("Bob", 40);
		LifeForm luck = new MockLifeForm("Luck", 1);
		//The cell is empty so it is successful to add the life into environment.
		boolean success = env.addLifeForm(1, 2, bob);
		assertTrue(success);
		assertEquals(bob, env.getLifeForm(1, 2));
		//The cell is not empty so the program can add the life into environment.
		success = env.addLifeForm(1, 2, luck);
		assertFalse(success);
		assertEquals(bob, env.getLifeForm(1, 2));
		//The row or col is invalid so it doesn't work.
		success = env.addLifeForm(5, 6, luck);
		assertFalse(success);
		assertNull(env.getLifeForm(5, 6));
	}

	/**
	 * Check RemoveLifeForm method.
	 */
	@Test
	public void testRemoveLifeForm()
	{
		LifeForm removeForm;
		Environment env = new Environment(2, 3);
		//The cell is empty so it doesn't work.
		removeForm = env.removeLifeForm(1,2);
		assertNull(removeForm);
		//the row or col is invalid so it doesn't work.
		removeForm = env.removeLifeForm(3,3);
		assertNull(removeForm);
		//The cell is not empty so it will remove the entity in the cell.
		LifeForm bob = new MockLifeForm("Bob", 40);
		env.addLifeForm(1, 2, bob);
		removeForm = env.removeLifeForm(1,2);
		assertEquals(bob,removeForm);
		//The cell has been removed successfully.
		removeForm = env.removeLifeForm(1,2);
		assertNull(removeForm);
		
	}
}
