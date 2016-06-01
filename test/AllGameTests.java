import lifeform.TestAlien;
import lifeform.TestHuman;
import lifeform.TestLifeForm;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import recovery.TestRecoveryFractional;
import recovery.TestRecoveryLinear;
import recovery.TestRecoveryNone;
import weapon.TestAttachment;
import weapon.TestChainGun;
import weapon.TestGenericWeapon;
import weapon.TestPistol;
import weapon.TestPlasmaCannon;
import weapon.TestPowerBooster;
import weapon.TestScope;
import weapon.TestStabilizer;
import environment.TestCell;
import environment.TestEnvironment;
import gameplay.TestSimpleTimer;

/**
 * Runs all of the tests in this project
 * @author Jixiang Lu
 *
 */

@RunWith(Suite.class)
@SuiteClasses({ 
	TestCell.class, 
	TestLifeForm.class,
	TestEnvironment.class,
	TestHuman.class,
	TestAlien.class,
	TestRecoveryNone.class,
	TestRecoveryLinear.class,
	TestRecoveryFractional.class,
	TestSimpleTimer.class,
	TestGenericWeapon.class,
	TestAttachment.class,
	TestPlasmaCannon.class,
	TestPistol.class,
	TestChainGun.class,
	TestStabilizer.class,
	TestPowerBooster.class,
	TestScope.class
	})
public class AllGameTests
{
}
