package weapon;

public abstract class Attachment implements Weapon
{
	private Weapon wp;
	public Attachment(Weapon wp)
	{
		this.wp = wp;
	}
	
	public Weapon getWeapon()
	{
		return wp;		
	}
	public void setWeapon(Weapon wp)
	{
		this.wp =wp;
	}
	@Override
	public void setMaxAmmo(int ammo)
	{
		wp.setMaxAmmo(ammo);
	}
	@Override
	public int getMaxAmmo()
	{
		return wp.getMaxAmmo();
	}
	@Override
	public void setRateOfFire(int rof)
	{
		wp.setRateOfFire(rof);
	}
	@Override
	public int getRateOfFire()
	{
		return wp.getRateOfFire();
	}
	@Override
	public void setMaxRange(int range)
	{
		wp.setMaxRange(range);
	}
	@Override
	public int getMaxRange()
	{
		return wp.getMaxRange();
	}
	@Override
	public void setBaseDamage(int damage)
	{
		wp.setBaseDamage(damage);
	}
	@Override
	public int getBaseDamage()
	{
		return wp.getBaseDamage();
	}
	@Override
	public void setActualRateFire(int rof)
	{
		wp.setActualRateFire(rof);
	}
	@Override
	public int getActualRateFire()
	{
		return wp.getActualRateFire();
	}
	@Override
	public void setActualAmmo(int ammo)
	{
		wp.setActualAmmo(ammo);
	}
	@Override
	public int getActualAmmo()
	{
		return wp.getActualAmmo();
	}
	@Override
	public void reloadWeapon()
	{
		wp.reloadWeapon();
	}

}
