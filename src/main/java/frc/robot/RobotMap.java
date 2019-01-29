/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;




//import com.revrobotics.CANSparkMax;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  //It explains itself, this is a "map" of the robot,
  //it is where all the motor and motor controllers are defined. 

  public static int MotorL1;
  public static int MotorL2;
  public static int MotorR1;
  public static int MotorR2;

  public CANSparkMax MotorL1Control;
  public CANSparkMax MotorL2Control;
  public CANSparkMax MotorR1Control;
  public CANSparkMax MotorR2Control;

  public RobotMap() {
    
    MotorL1 = 2;
    MotorL2 = 3;
    MotorR1 = 0;
    MotorR2 = 1;

    MotorL1Control = new CANSparkMax(MotorL1 , MotorType.kBrushless);
    MotorL2Control = new CANSparkMax(MotorL2 , MotorType.kBrushless);
    MotorR1Control = new CANSparkMax(MotorR1 , MotorType.kBrushless);
    MotorR2Control = new CANSparkMax(MotorR2 , MotorType.kBrushless);





  }
 
}
