package exceptions;

public class AttachmentException extends Exception
{
	/**
	 * Constructor
	 * @param info Warning information
	 */
	public AttachmentException(String info)
	{
		super(info);
	}
}
