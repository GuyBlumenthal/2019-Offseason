/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  
  public final static int LEFT_MASTER = 5;
  public final static int LEFT_FOLLOW = 6;

  public final static int RIGHT_MASTER = 3;
  public final static int RIGHT_FOLLOW = 4;

  public final static int ELEVATOR_MOTOR_LEAD = 9;
  public final static int ELEVATOR_MOTOR_FOLLOW = 10;

  public final static int PIVOT_MOTOR = 0;
    
  public final static int SCREW_MOTOR = 3;
  
  public final static int INTAKE_MOTOR = 6;
  
  public final static int LIFT_DRIVING_MOTOR = 9;
  
  public final static int HATCH_SOLENOID_PORT_ONE = 6;
  public final static int HATCH_SOLENOID_PORT_TWO = 7;

  public final static int LOW_LIMIT_SWITCH = 0;
  public final static int HIGH_LIMIT_SWITCH = 1;
  public final static int PIVOT_LIMIT_SWITCH = 2;
  public final static int SCREW_LIMIT_SWITCH = 3;

  public final static int PIVOT_ENCODER_ONE = 4;
  public final static int PIVOT_ENCODER_TWO = 5;
  public final static int ELEVATOR_MASTER_ONE = 6;
  public final static int ELEVATOR_MASTER_TWO = 7;
  public final static int ELEVATOR_FOLLOW_ONE = 8;
  public final static int ELEVATOR_FOLLOW_TWO = 9;

  public final static double INTAKE_SPEED = 0.7;

}
