/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.BoxDefaultCommand;

/**
 * Add your docs here.
 */
public class BoxSubsystem extends Subsystem {
  
  Victor intakeMotor;
  Victor pivotMotor;

  DigitalInput pivotLimitSwitch;

  Encoder pivotEncoder;

  public BoxSubsystem () {

    intakeMotor = new Victor(RobotMap.INTAKE_MOTOR);
    pivotMotor = new Victor(RobotMap.PIVOT_MOTOR);

    pivotMotor.setInverted(true);

    pivotLimitSwitch = new DigitalInput(RobotMap.PIVOT_LIMIT_SWITCH);

    pivotEncoder = new Encoder (RobotMap.PIVOT_ENCODER_ONE, RobotMap.PIVOT_ENCODER_TWO);

  }

  @Override
  public void initDefaultCommand () {
    setDefaultCommand(new BoxDefaultCommand());
  }

  public boolean getPivotLimitSwitch () {
    return pivotLimitSwitch.get();
  }

  public void intake () {
    intakeMotor.set(-RobotMap.INTAKE_SPEED);
  }

  public void outtake () {
    intakeMotor.set(RobotMap.INTAKE_SPEED);
  }

  public void stopIntake () {
    intakeMotor.set(0);
  }

  public double getPivotEncoder () {
    return pivotEncoder.get();
  }

  public void movePivot (double speed) {
    if (getPivotLimitSwitch() && speed > 0) {
      //speed = 0;
    }
    pivotMotor.set(speed);
  }

  public void updateSmartdashboard () {
    SmartDashboard.putNumber("Pivot Encoder", getPivotEncoder());
    SmartDashboard.putBoolean("Pivot Limit Switch", getPivotLimitSwitch());
  }

}
