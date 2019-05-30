/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ElevatorDefaultCommand;

/**
 * Add your docs here.
 */
public class ElevatorSubsystem extends Subsystem {
  
  WPI_TalonSRX elevatorMaster;
  WPI_TalonSRX elevatorFollow;

  DigitalInput lowLimitSwitch;
  DigitalInput highLimitSwitch;
  
  Encoder elevatorMasterEncoder;
  Encoder elevatorFollowEncoder;

  public ElevatorSubsystem () {
    elevatorMaster = new WPI_TalonSRX(RobotMap.ELEVATOR_MOTOR_LEAD);
    elevatorFollow = new WPI_TalonSRX(RobotMap.ELEVATOR_MOTOR_FOLLOW);
    
    // elevatorFollow.follow(elevatorMaster);

    lowLimitSwitch = new DigitalInput(RobotMap.LOW_LIMIT_SWITCH);
    highLimitSwitch = new DigitalInput(RobotMap.HIGH_LIMIT_SWITCH);

    elevatorMasterEncoder = new Encoder (RobotMap.ELEVATOR_MASTER_ONE, RobotMap.ELEVATOR_MASTER_TWO);
    elevatorFollowEncoder = new Encoder (RobotMap.ELEVATOR_FOLLOW_ONE, RobotMap.ELEVATOR_FOLLOW_TWO);

  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ElevatorDefaultCommand());
  }

  public boolean getLowLimitSwitch () {
    return lowLimitSwitch.get();
  }
  
  public boolean getHighLimitSwitch () {
    return highLimitSwitch.get();
  }

  public void moveElevator (double speed) {
    if (getLowLimitSwitch() && speed < 0) {
      // speed = 0;
    }

    if (getHighLimitSwitch() && speed > 0) {
      // speed = 0;
    }
    elevatorMaster.set(ControlMode.PercentOutput, speed);
    elevatorFollow.set(ControlMode.PercentOutput, speed);
  }

  public void updateSmartdashboard () {

  }

}
