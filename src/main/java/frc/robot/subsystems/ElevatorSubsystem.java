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
  Counter LimitCounterLow = new Counter(LimitLow);
  Counter LimitCounterHigh = new Counter(LimitHigh);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void ElevatorSpeed(double ElevSpeed) 
  {
      
    if(!LimitSwitchTester(LimitCounterHigh.get()) == true || !LimitSwitchTester(LimitCounterLow.get()) == true)
    {
      //If you are using a spark, not a spark max, it would be: .setSpeed(ElevSpeed) , instead of just .set(ElevSpeed)
      Robot.robotmap.MotorElevControl.set(ElevSpeed);
    }
    else
    {
      Robot.robotmap.MotorElevControl.set(0.0);
    }

  }

  public boolean LimitSwitchTester(int LimitLowOnOff)
  {
    return LimitLowOnOff > 0;
  }


}
