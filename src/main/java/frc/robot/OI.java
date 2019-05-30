/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  
  XboxController driveController = new XboxController(0);
  XboxController operatorController = new XboxController(1);

  public double getSpeed () {
    return -driveController.getY(Hand.kLeft);
  }

  public double getTurn () {
    return driveController.getX(Hand.kRight);
  }

  public double getElevatorSpeed () {
    return -operatorController.getY(Hand.kLeft);
  }

  public double getPivotSpeed () {
    return -operatorController.getY(Hand.kRight);
  }

  public boolean isOuttake () {
    return operatorController.getBumper(Hand.kRight);
  }

  public boolean isIntake () {
    return operatorController.getBumper(Hand.kLeft);
  }

  public boolean openHatch () {
    return operatorController.getBButton();
  }

  public boolean lockHatch () {
    return operatorController.getYButtonPressed();
  }

  public double getScrewSpeed () {
    return operatorController.getTriggerAxis(Hand.kRight) - operatorController.getTriggerAxis(Hand.kLeft);
  }

  public double getLiftDrivingSpeed () {
    return (driveController.getBumper(Hand.kRight) ? 1 : 0) - (driveController.getBumper(Hand.kLeft) ? -1 : 0);
  }

}
 