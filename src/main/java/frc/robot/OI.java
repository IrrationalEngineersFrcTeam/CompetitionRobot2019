/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;
import frc.robot.commands.HatchGrabCommand;
import frc.robot.commands.HatchReleaseCommand;
import frc.robot.commands.ElevatorUpManualCommand;
import frc.robot.commands.ElevatorDownManualCommand;
import frc.robot.commands.ArmExtendCommand;
import frc.robot.commands.ArmRetractCommand;

public class OI {
//This creates any joysticks we will use to drive the robot,
//in this case a left joystick and a right joystick.
  public Joystick StickL;
  public Joystick StickR;

//Here we have the hatch mechanism buttons
  public Button HatchGrabButton;
  public Button HatchReleaseButton;

/*
//These Arm and slider buttons are for testing and will probably be removed out
*/
  public Button ArmExtendButton;
  public Button ArmRetractButton;

  public POVButton ElevatorUp315;
  public POVButton ElevatorUp360;
  public POVButton ElevatorUp45;
  public POVButton ElevatorDown135;
  public POVButton ElevatorDown180;
  public POVButton ElevatorDown225;


  public OI() {
    //This tells the robot what ports these joysticks will be connected to, 

    StickL = new Joystick(0);
    StickR = new Joystick(1);

  //This is where we tie the code buttons to the buttons on the joysticks
  //In this case the hatch button
    HatchGrabButton = new JoystickButton(StickR, 3);
    HatchReleaseButton = new JoystickButton(StickR, 4);

    /*
    //These buttons are for testing purposes, they will be phased out in the future
    */
    ArmExtendButton = new JoystickButton(StickL, 3);
    ArmRetractButton = new JoystickButton(StickL, 4);


  //These buttons are tied to the little joystick called the hat on the big joystick
  //These three go up
    ElevatorUp315 = new POVButton(StickL, 315);
    ElevatorUp360 = new POVButton(StickL, 360);
    ElevatorUp45 = new POVButton(StickL, 45);
  //These three go down
    ElevatorDown135 = new POVButton(StickL, 135);
    ElevatorDown180 = new POVButton(StickL, 180);
    ElevatorDown225 = new POVButton(StickL, 225);

  //This method binds the button to a command
  //In this case the hatch button
    HatchGrabButton.whenPressed(new HatchGrabCommand());
    HatchReleaseButton.whenPressed(new HatchReleaseCommand());
    /*
    //These are temperary
    */
    ArmExtendButton.whenPressed(new ArmExtendCommand());
    ArmRetractButton.whenPressed(new ArmRetractCommand());

  //The reason I have three for both up and down is so that it has room for user error
  //These are up
    ElevatorUp315.whileHeld(new ElevatorUpManualCommand());
    ElevatorUp360.whileHeld(new ElevatorUpManualCommand());
    ElevatorUp45.whileHeld(new ElevatorUpManualCommand());
  //These are down
    ElevatorDown135.whileHeld(new ElevatorDownManualCommand());
    ElevatorDown180.whileHeld(new ElevatorDownManualCommand());
    ElevatorDown225.whileHeld(new ElevatorDownManualCommand());

  }

 
}
