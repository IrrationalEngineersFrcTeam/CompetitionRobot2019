/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;


/**
 * This subsystem is here to be used by the commands because the pidsubsystem cannot
 * be initialized in robotInit
 */
public class AutoAssistCenteringSubsystem extends Subsystem 
{
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  double Output = Robot.targetCentering.getOutput();
  // static boolean IsSeen = Robot.VisionTargetIsSeen.getBoolean(true);

  public void FindTarget()
  {

      Robot.drivesub.DriveCommand(-0.3, 0.3);

  }

  public void CenterOnTarget()
  {

    if(Output > 0)
    {
      Robot.drivesub.DriveCommand(0, 0 + Output);
    }
    else if(Output < 0)
    {
      Robot.drivesub.DriveCommand(0 + -Output, 0);
    }

  }

  @Override
  public void initDefaultCommand() 
  {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void DriveOverLine()
  {
    Robot.robotmap.MotorL1Control.set(-Robot.lineCentering.getOutput() * .5);
    Robot.robotmap.MotorL2Control.set(-Robot.lineCentering.getOutput() * .5);
    Robot.robotmap.MotorR1Control.set(Robot.lineCentering.getOutput() * .5);
    Robot.robotmap.MotorR2Control.set(Robot.lineCentering.getOutput() * .5);
  }

  public void Stop()
  {
    Robot.robotmap.MotorL1Control.set(0.0);
    Robot.robotmap.MotorL2Control.set(0.0);
    Robot.robotmap.MotorR1Control.set(0.0);
    Robot.robotmap.MotorR2Control.set(0.0);
  }
}
