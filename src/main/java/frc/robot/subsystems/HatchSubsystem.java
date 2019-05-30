/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.HatchDefaultCommand;

/**
 * Add your docs here.
 */
public class HatchSubsystem extends Subsystem {
  
  DoubleSolenoid hatchSolenoid;
  boolean locked;

  public HatchSubsystem () {

    hatchSolenoid = new DoubleSolenoid(RobotMap.HATCH_SOLENOID_PORT_ONE, RobotMap.HATCH_SOLENOID_PORT_TWO);
    locked = false;

  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new HatchDefaultCommand());
  }

  public void lockHatch () {
    locked = true;
  }

  public void openHatch (boolean hatchBoolean) {
    if (!locked || (locked && hatchBoolean)) {
      locked = false;
      hatchSolenoid.set(hatchBoolean ? Value.kForward : Value.kReverse);
    }
  }

  public void updateSmartdashboard () {
  }

}
