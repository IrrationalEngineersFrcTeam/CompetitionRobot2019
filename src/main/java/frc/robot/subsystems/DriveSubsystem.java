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
    Robot.robotmap.MotorL1Control.set(-SpeedL * .5);
		Robot.robotmap.MotorL2Control.set(-SpeedL * .5);
		Robot.robotmap.MotorR1Control.set(SpeedR * .5);
    Robot.robotmap.MotorR2Control.set(SpeedR * .5);

    System.out.println(Robot.robotmap.encoderL1.getVelocity());

    
    
  }

  public void getEncoderRot() {


  }

  public double getRightEncoderVel(String side) {

    //get the average of the two encoders on each side for a more accurate value
    double rightEncVel = (Robot.robotmap.encoderR1.getVelocity() + Robot.robotmap.encoderR2.getVelocity()) / 2;
    double leftEncVel = (Robot.robotmap.encoderL1.getVelocity() + Robot.robotmap.encoderL2.getVelocity()) / 2;
    //if the "side" variable delivered equals right, return the right encoder velocity value
    if (side.equals("right")) {
      return rightEncVel;
    //if the "side" variable delivered equals left, return the left encoder velocity value
    } else if (side.equals("left")) {
      return leftEncVel;
      //if the "side" variable delivered does not equal any of the needed values, 
    } else {
      return 1234;
    }
  }
}
