/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;




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
  //The Elevator things are commented out for now, because we are using a spark for now.

  public static int MotorL1;
  public static int MotorL2;
  public static int MotorR1;
  public static int MotorR2;
  public static int MotorE1;
  public static int MotorC1;

  public CANSparkMax MotorL1Control;
  public CANSparkMax MotorL2Control;
  public CANSparkMax MotorR1Control;
  public CANSparkMax MotorR2Control;
  public Spark MotorElevControl;
  public Spark CargoControl;



  public CANEncoder encoderL1;
  public CANEncoder encoderL2;
  public CANEncoder encoderR1;
  public CANEncoder encoderR2;

  public DoubleSolenoid HatchMechPiston;
  public DoubleSolenoid ArmPiston;
  public DoubleSolenoid ElevatorSlider;
  public DoubleSolenoid ClimberPiston1;
  public DoubleSolenoid ClimberPiston2;

  public RobotMap() {
    
    MotorL1 = 3;
    MotorL2 = 4;
    MotorR1 = 1;
    MotorR2 = 2;
    MotorE1 = 0;
    MotorC1 = 1;

    MotorL1Control = new CANSparkMax(MotorL1 , MotorType.kBrushless);
    MotorL2Control = new CANSparkMax(MotorL2 , MotorType.kBrushless);
    MotorR1Control = new CANSparkMax(MotorR1 , MotorType.kBrushless);
    MotorR2Control = new CANSparkMax(MotorR2 , MotorType.kBrushless);
    MotorElevControl = new Spark(MotorE1);
    CargoControl = new Spark(MotorC1);

    encoderL1 = new CANEncoder(MotorL1Control);
    encoderL2 = new CANEncoder(MotorL2Control);
    encoderR1 = new CANEncoder(MotorR1Control);
    encoderR2 = new CANEncoder(MotorR2Control);
    
    HatchMechPiston = new DoubleSolenoid(0, 1);
    ArmPiston = new DoubleSolenoid(2, 3);
    ElevatorSlider = new DoubleSolenoid(4, 5);
    ClimberPiston1 = new DoubleSolenoid(6, 7);
    ClimberPiston2 = ClimberPiston1;
    
    HatchMechPiston.set(DoubleSolenoid.Value.kForward);
    ArmPiston.set(DoubleSolenoid.Value.kReverse);
    ElevatorSlider.set(DoubleSolenoid.Value.kReverse);
    ClimberPiston1.set(DoubleSolenoid.Value.kReverse);
    ClimberPiston2.set(DoubleSolenoid.Value.kReverse);
  }
 
}
