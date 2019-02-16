/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;


/**
 * Add your docs here.
 */
public class ElevatorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  DigitalInput LimitHigh = new DigitalInput(0);
  DigitalInput LimitLow = new DigitalInput(1);
  Counter LimitCounterHigh = new Counter(LimitHigh);
  Counter LimitCounterLow = new Counter(LimitLow);
  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void ElevatorSpeed(double ElevSpeed) 
  {

    //If you are using a spark, not a spark max, it would be: .setSpeed(ElevSpeed) , instead of just .set(ElevSpeed)
    Robot.robotmap.MotorElevControl.set(ElevSpeed);

  }

  public boolean LimitSwitchHigh()
  {
    return this.LimitCounterHigh.get() > 0;
  }

  public boolean LimitSwitchLow()
  {
    return this.LimitCounterLow.get() > 0;
  }

  public void ElevatorUp() {
    Robot.robotmap.MotorElevControl.set(0.3);
    System.out.println("Going UP!");
  }

  public void ElevatorDown() {
    Robot.robotmap.MotorElevControl.set(-0.3);
    System.out.println("Going DOWN!");
  }

  public void ElevatorStop() {
    Robot.robotmap.MotorElevControl.set(0);
  }

}
