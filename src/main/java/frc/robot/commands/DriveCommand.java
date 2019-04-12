/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;



public class DriveCommand extends Command {

  public DriveCommand() {
    //Here is where the command declares its subsystem dependencies
    //in this case, the drive subsystem.
    requires(Robot.drivesub);
 
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //This creates two variables that are equal to the angle of joysticks
    //These will be usefull to the drive subsystem 
    double SpeedLY = Robot.oi.StickL.getY();
    double SpeedR = Robot.oi.StickR.getY();
    double SpeedLX = Robot.PIDTurn;

    boolean ArcadeModeOn = Robot.oi.ArcadeMode.get();
    //System.out.println("Left: " + SpeedL + ", Right: " + SpeedR);
    if(ArcadeModeOn == false)
    {
    Robot.drivesub.TankDrive(SpeedLY, SpeedR);
    }
    else
    {
    Robot.drivesub.ArcadeDrive(SpeedLY, SpeedLX);
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
