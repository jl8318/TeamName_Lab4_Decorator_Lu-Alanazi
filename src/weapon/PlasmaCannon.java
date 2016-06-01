package weapon;

public class PlasmaCannon extends GenericWeapon 
{
	
	public PlasmaCannon()
	{
		this(50,20,1,4);
	}
	
	public PlasmaCannon(int damage, int range,int rof, int ammo)
	{
		super(damage,range,rof,ammo);
	}

	@Override
	public int getDamage(int distance) 
	{
		int distanceAbs = Math.abs(distance);
		if(distanceAbs>this.getMaxRange())
		{
			int actualAmmoInt = ((getActualAmmo()-1)>0)?(getActualAmmo()-1):0;
			this.setActualAmmo(actualAmmoInt);
			return 0;
		}
		else
		{
			if(this.getActualAmmo()>0)
			{
				//get result
				float baseDamage = (float)this.getBaseDamage();
				float actualAmmo = (float)this.getActualAmmo();
				float maxAmmo = (float)this.getMaxAmmo();
				float damage = baseDamage*(actualAmmo/maxAmmo);   
				int result = (int)damage;
				//change actualAmmo
				int actualAmmoInt = ((getActualAmmo()-1)>0)?(getActualAmmo()-1):0;
				this.setActualAmmo(actualAmmoInt);
				return result;
			}
			else
				return 0;
		}
	}

}
