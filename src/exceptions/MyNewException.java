package exceptions;

/**
 * An simple exception. It is used by Alien. When the Recovery Rate is 
 * negative, it will be thrown.
 * 
 * @author Jixiang Lu
 *
 */
public class MyNewException extends Exception
{

	/**
	 * Constructor
	 * @param info Warning information
	 */
	public MyNewException(String info)
	{
		super(info);
	}

}
