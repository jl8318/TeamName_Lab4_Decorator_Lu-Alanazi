package environment;

import lifeform.LifeForm;

/**
 * A Environment hold a 2-Dimensional array of Cell.
 * 
 * @author Jixiang Lu
 *
 */
public class Environment
{
	private Cell[][] theCells;
	
	/**
	 * Create an Environment
	 * @param row the number of row
	 * @param col the number of column
	 */
	public Environment(int row, int col)
	{
		theCells = new Cell[row][col];
		for(int i = 0;i<row;i++)
		{
			for(int j = 0; j<col;j++)
			{
				theCells[i][j]=new Cell();
			}
		}
	}

	/**
	 * Gets a LifeForm at Cell theCells[row][col].
	 * Return LifeForm if there is a LifeForm in the Cell,
	 * null if the row and col are invalid or there is not
	 * LifeForm in the Cell.
	 * @param row the number of row
	 * @param col the number of column
	 * @return LifeForm if there is a LifeForm in the Cell,
	 * null if the row and col are invalid or there is not
	 * LifeForm in the Cell.
	 * 
	 */
	public LifeForm getLifeForm(int row, int col)
	{
		if(row<theCells.length&&col<theCells[0].length)
			return  theCells[row][col].getLifeForm();
		else
		{
			System.out.println("the number of row or the the number of col is invalid");
			return null;
		}
	}

	/**
	 * Adds a LifeForm to the Cell the Cell[row][col].
	 * Will not add the LifeForm if the row and col
	 * are invalid or if a LifeForm is already in that Cell.
	 * Return true if successfully added, false otherwise.
	 * 
	 * @param row the number of row
	 * @param col the number of column
	 * @param entity the entity is used  added into the Cell
	 * @return true if successfully added, false otherwise.
	 */
	public boolean addLifeForm(int row, int col, LifeForm entity)
	{
		if(row<theCells.length&&col<theCells[0].length)
		{
			return theCells[row][col].addLifeForm(entity);
		}
		else
		{
			System.out.println("the number of row or the the number of col is invalid");
			return false;
		}
		
	}

	/**
	 * Removes the LifeForm at theCells[row][col].
	 * Returns the LifeForm removed(null if no LifeForm in 
	 * the Cell or the row or the col is invalid)
	 * 
	 * @param row the number of row
	 * @param col the number of column
	 * @return LifeForm removed or null
	 */
	public LifeForm removeLifeForm(int row, int col)
	{
		if(row<theCells.length&&col<theCells[0].length)
		{
			return theCells[row][col].removeLifeForm();
		}
		else
		{
			System.out.println("the number of row or the the number of col is invalid");
			return null;
		}
	}
	
	
	
}
