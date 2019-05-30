/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.ChassisDefaultCommand;

/**
 * Add your docs here.
 */
public class ChassisSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  WPI_TalonSRX leftMaster;
  WPI_TalonSRX leftFollow;
  
  WPI_TalonSRX rightMaster;
  WPI_TalonSRX rightFollow;

  DifferentialDrive drive;
  
  public ChassisSubsystem () {

    leftMaster = new WPI_TalonSRX(RobotMap.LEFT_MASTER);
    leftFollow = new WPI_TalonSRX(RobotMap.LEFT_FOLLOW);

    leftFollow.follow(leftMaster);

    leftMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

    rightMaster = new WPI_TalonSRX(RobotMap.RIGHT_MASTER);
    rightFollow = new WPI_TalonSRX(RobotMap.RIGHT_FOLLOW);
    
    rightFollow.follow(rightMaster);

    rightMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

    drive = new  DifferentialDrive(leftMaster, rightMaster);

  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ChassisDefaultCommand());
  }

  public double getRightEncoder () {
    return rightMaster.getSelectedSensorPosition();
  }

  public double getLeftEncoder () {
    return leftMaster.getSelectedSensorPosition();
  }

  public void move (double speed, double turn) {
    drive.arcadeDrive(speed, turn);
  }

  public void updateSmartdashboard () {
    SmartDashboard.putNumber("Right Encoder", getRightEncoder());
    SmartDashboard.putNumber("Left Encoder", getLeftEncoder());
  }
  
}
