/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Counter;

public class ElevatorUpCommand extends Command {
  public ElevatorUpCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.elevatesub);
  }

  DigitalInput LimitHigh = new DigitalInput(0);
  Counter LimitCounter = new Counter(LimitHigh);

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {

    while(!Robot.elevatesub.LimitSwitchTester(this.LimitCounter.get()))
    {
      Robot.elevatesub.ElevatorSpeed(0.3);
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() 
  {
    //  if(Robot.elevatesub.LimitSwitchTester(this.LimitCounter.get()) == true)
    //  {
    //  System.out.println("The limit switch has been triggered!");
    //  }
    //  else{System.out.println("Limit not reached!!");}

    Robot.elevatesub.ElevatorSpeed(0.0);

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
