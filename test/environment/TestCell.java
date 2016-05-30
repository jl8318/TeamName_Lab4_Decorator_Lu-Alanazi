package environment;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

import org.junit.Test;

/**
 * The test cases for the Cell class.
 * 
 * @author Jixiang Lu
 *
 */
public class TestCell
{

	/**
	 * At initialization, the Cell should be empty and not contain a LifeForm.
	 */
	@Test
	public void testInitialization()
	{
		Cell cell = new Cell();
		assertNull(cell.getLifeForm());
	}

	/**
	 * Checks to see if we change the LifeForm held by the Cell that
	 * getLifeForm properly responds to this change.
	 * 
	 */
	@Test
	public void testSetLifeForm()
	{
		LifeForm bob = new MockLifeForm("Bob",40);
		LifeForm fred = new MockLifeForm("Fred",40);
		Cell cell = new Cell();
		//The cell is empty so this should work.
		boolean success = cell.addLifeForm(bob);
		assertTrue(success);
		assertEquals(bob,cell.getLifeForm());
		//The cell is not empty so this should fail.
		success = cell.addLifeForm(fred);
		assertFalse(success);
		assertEquals(bob,cell.getLifeForm());
	}

	/**
	 * Check the remove method. If there is an entity
	 * in the Cell, remove it and return it. Otherwise,
	 * return null.
	 * 
	 */
	@Test
	public void testRemoveLifeForm()
	{
		LifeForm removeForm;
		Cell cell = new Cell();
		//The cell is empty so return null.
		removeForm = cell.removeLifeForm();
		assertNull(removeForm);
		LifeForm bob = new MockLifeForm("Bob",40);
		cell.addLifeForm(bob);
		//The cell is not empty so return entity.
		removeForm = cell.removeLifeForm();
		assertEquals(bob,removeForm);
		//The cell has been removed so return null.
		removeForm = cell.removeLifeForm();
		assertNull(removeForm);
	}
}
