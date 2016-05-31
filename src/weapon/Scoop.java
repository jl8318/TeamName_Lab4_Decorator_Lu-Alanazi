package weapon;

public class Scoop extends Attachment {

	public Scoop(Weapon wp) {
		super(wp);
		
	}

	@Override
	public int getDamage(int distance) {
		int  distanceads = Math.abs(distance);
		float weapon = this.getWeapon().getDamage(distanceads) ; 
		float maxrange = getMaxRange();
		if (distanceads <= getMaxRange())
		{
			float damage = weapon*(1+(maxrange-distanceads)/maxrange);
			return (int)damage;
		}
		else
		{
			return 0 ; 
		}
		
	}

}
