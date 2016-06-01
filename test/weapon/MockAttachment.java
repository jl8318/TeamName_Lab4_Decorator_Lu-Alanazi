package weapon;

import exceptions.AttachmentException;

/**
 * Mock class is used to test Attachment class.
 * @author Jixiang Lu
 *
 */
public class MockAttachment extends Attachment
{

	/**
	 * Constructor: A weapon with this attachment will be created.
	 * 
	 * @param wp the weapon will be wrapped this attachment
	 * @throws AttachmentException each weapon only has 0-2 attachment.
	 */
	public MockAttachment(Weapon wp) throws AttachmentException
	{
		super(wp);
		
	}
	
	/**
	 * Gets the damage each time is equals to distance.
	 */
	@Override
	public int getDamage(int distance) 
	{
		return distance+ this.getWeapon().getDamage(distance) ;
	}

	

}
