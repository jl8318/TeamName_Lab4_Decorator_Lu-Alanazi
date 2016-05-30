package environment;

import lifeform.LifeForm;

/**
 * A Cell that can hold a LifeForm.
 * 
 * @author Jixiang Lu
 *
 */
public class Cell
{

	private LifeForm entity;

	/**
	 * Create a Cell.
	 */
	public Cell()
	{
		entity = null;
	}

	/**
	 * @return the LifeForm in this Cell
	 */
	public LifeForm getLifeForm()
	{

		return entity;
	}

	/**
	 * Tries to add the LifeForm to the Cell. Will not add if a LifeForm is
	 * already present.
	 * 
	 * @param life
	 *            the LifeForm will be tried to add the Cell.
	 * @return true if the LifeForm was added to the Cell, false other wise.
	 */
	public boolean addLifeForm(LifeForm life)
	{
		if (entity == null)
		{
			this.entity = life;
			return true;
		} 
		else
		{
			return false;
		}
	}

	/**
	 * Removes the LifeForm in the Cell.
	 *
	 * @return the LifeForm removed, null if none present.
	 */
	public LifeForm removeLifeForm()
	{
		if (this.entity != null)
		{
			LifeForm temp = entity;
			entity = null;
			return temp;
		} 
		else
		{
			return null;
		}

	}

}
