/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class BoxDefaultCommand extends Command {
  public BoxDefaultCommand() {
    requires(Robot.boxSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    boolean intake = Robot.m_oi.isIntake();
    boolean outtake = Robot.m_oi.isOuttake();

    double pivotSpeed = Robot.m_oi.getPivotSpeed();

    if (intake) {
      Robot.boxSubsystem.intake();
    } else if (outtake) {
      Robot.boxSubsystem.outtake();
    } else {
      Robot.boxSubsystem.stopIntake();
    }

    Robot.boxSubsystem.movePivot(pivotSpeed);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
