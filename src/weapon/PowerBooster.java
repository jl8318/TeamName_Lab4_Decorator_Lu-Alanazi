package weapon;
/**
 * Power Booster Class 
 * @author Saad
 *
 */

public class PowerBooster extends Attachment {

	public PowerBooster(Weapon wp) {
		super(wp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getDamage(int distance) {
		int  distanceads = Math.abs(distance);
		float weapon = this.getWeapon().getDamage(distanceads) ; 
		float actualAmmo = (float)this.getActualAmmo();
		float maxAmmo = (float)this.getMaxAmmo();
		if (distanceads <= getMaxRange())
		{
			float damage = weapon*(1+actualAmmo/maxAmmo);
			return (int)damage;
		}
		else
		{
			return 0 ; 
		}
		
	}
	}
	

