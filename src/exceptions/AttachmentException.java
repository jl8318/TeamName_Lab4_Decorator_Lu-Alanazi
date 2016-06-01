package exceptions;

/**
 * An exception: when an weapon wrap more than two attachments, the exception will
 * be throws.
 * @author Jixiang Lu
 *
 */
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
