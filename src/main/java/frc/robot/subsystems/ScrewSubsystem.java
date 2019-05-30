/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ScrewDefaultCommand;

/**
 * Add your docs here.
 */
public class ScrewSubsystem extends Subsystem {

  Victor screwMotor;
  Victor drivingMotor;

  DigitalInput screwLimitSwitch;

  public ScrewSubsystem () {

    screwMotor = new Victor (RobotMap.SCREW_MOTOR);
    drivingMotor = new Victor (RobotMap.LIFT_DRIVING_MOTOR);

    screwLimitSwitch = new DigitalInput(RobotMap.SCREW_LIMIT_SWITCH);

  }

  public boolean getScrewLimitSwitch() {
    return screwLimitSwitch.get();
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ScrewDefaultCommand());
  }

  public void moveLiftDrivingSpeed (double speed) {
    drivingMotor.set(speed);
  }

  public void moveScrew (double speed) {
    if (getScrewLimitSwitch() && speed > 0){
      speed = 0;
    }
    screwMotor.set(speed);
  }

  public void updateSmartdashboard () {
  }

}
