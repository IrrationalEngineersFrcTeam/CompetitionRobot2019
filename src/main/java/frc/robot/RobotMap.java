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
  public static int MotorE1;

  public CANSparkMax MotorL1Control;
  public CANSparkMax MotorL2Control;
  public CANSparkMax MotorR1Control;
  public CANSparkMax MotorR2Control;
  public CANSparkMax MotorElevControl;


  public CANEncoder encoderL1;
  public CANEncoder encoderL2;
  public CANEncoder encoderR1;
  public CANEncoder encoderR2;

  public DoubleSolenoid HatchMechPiston;
  public DoubleSolenoid ArmPiston;
  public DoubleSolenoid ElevatorSlider;

  public RobotMap() {
    
    MotorL1 = 2;
    MotorL2 = 3;
    MotorR1 = 0;
    MotorR2 = 1;
    MotorE1 = 4;

    MotorL1Control = new CANSparkMax(MotorL1 , MotorType.kBrushless);
    MotorL2Control = new CANSparkMax(MotorL2 , MotorType.kBrushless);
    MotorR1Control = new CANSparkMax(MotorR1 , MotorType.kBrushless);
    MotorR2Control = new CANSparkMax(MotorR2 , MotorType.kBrushless);
    MotorElevControl = new CANSparkMax(MotorE1 , MotorType.kBrushed);

    encoderL1 = new CANEncoder(MotorL1Control);
    encoderL2 = new CANEncoder(MotorL2Control);
    encoderR1 = new CANEncoder(MotorR1Control);
    encoderR2 = new CANEncoder(MotorR2Control);
    
    HatchMechPiston = new DoubleSolenoid(0, 1);
    ArmPiston = new DoubleSolenoid(2, 3);

    ElevatorSlider = new DoubleSolenoid(4, 5);
    
    HatchMechPiston.set(DoubleSolenoid.Value.kOff);
    HatchMechPiston.set(DoubleSolenoid.Value.kForward);
    HatchMechPiston.set(DoubleSolenoid.Value.kReverse);
    ArmPiston.set(DoubleSolenoid.Value.kOff);
    ArmPiston.set(DoubleSolenoid.Value.kForward);
    ArmPiston.set(DoubleSolenoid.Value.kReverse);

    ElevatorSlider.set(DoubleSolenoid.Value.kOff);
    ElevatorSlider.set(DoubleSolenoid.Value.kForward);
    ElevatorSlider.set(DoubleSolenoid.Value.kReverse);



  }
 
}
