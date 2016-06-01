package lifeform;


/**
 * A Mock class that concrete LifeForm class which will
 * be tested.
 * 
 * @author Jixiang Lu
 *
 */
public class MockLifeForm extends LifeForm
{
	
	/**
	 * Construct an MockLifeForm.
	 *  
	 * @param name the name of LifeForm
	 * @param points the LifePoint of LifeForm
	 */
	public MockLifeForm(String name, int points){
		super(name, points);
	}
}
