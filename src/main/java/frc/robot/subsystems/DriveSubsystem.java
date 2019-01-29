/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.commands.DriveCommand;


public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem here
  

  @Override
  public void initDefaultCommand() {
// This sets the default command.
    setDefaultCommand(new DriveCommand());

   
  }
  public void DriveCommand(double SpeedL, double SpeedR){
    //This is the code that actually makes the robot drive! It tells the 
    //proper motor controllers to set the motors to desired speed.
    Robot.robotmap.MotorL1Control.set(-SpeedL);
		Robot.robotmap.MotorL2Control.set(-SpeedL);
		Robot.robotmap.MotorR1Control.set(SpeedR);
    Robot.robotmap.MotorR2Control.set(SpeedR);
    
    
  }
}
