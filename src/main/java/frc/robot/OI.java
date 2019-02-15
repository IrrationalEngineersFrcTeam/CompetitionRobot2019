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
import frc.robot.commands.HatchHoldOpenCommand;
import frc.robot.commands.ArmExtendCommand;
import frc.robot.commands.ArmRetractCommand;
import frc.robot.commands.ElevatorUpCommand;
import frc.robot.commands.ElevatorDownCommand;
import frc.robot.commands.SlideElevatorForwardCommand;
import frc.robot.commands.SlideElevatorBackCommand;
import frc.robot.autoCommands.PlaceHatchLevel_1;
import frc.robot.autoCommands.PlaceHatchLevel_2;
import frc.robot.autoCommands.PlaceHatchLevel_3;


public class OI {
//This creates any joysticks we will use to drive the robot,
//in this case a left joystick and a right joystick.
  public Joystick StickL;
  public Joystick StickR;

//Here we have the hatch mechanism buttons
  public Button HatchHoldOpenButton;

//These Arm and slider buttons are for testing and will probably be removed
  public Button ArmExtendButton;
  public Button ArmRetractButton;

//These buttons are to slide the elevator forward and back
  public Button SliderForward;
  public Button SliderBack;

//These Buttons are for the command groups for lifting the hatch to specific levels
public Button PlaceHatchLevel_1_Button;
public Button PlaceHatchLevel_2_Button;
public Button PlaceHatchLevel_3_Button;

//These are the manual elevator control buttons
  public POVButton ElevatorUp315;
  public POVButton ElevatorUp360;
  public POVButton ElevatorUp45;
  public POVButton ElevatorDown135;
  public POVButton ElevatorDown180;
  public POVButton ElevatorDown225;

  public Button ElevatorUp;
  public Button ElevatorDown;


  public OI() {
  //This tells the robot what ports these joysticks will be connected to, 

    StickL = new Joystick(0);
    StickR = new Joystick(1);

  //This is where we tie the code buttons to the buttons on the joysticks
  //In this case the hatch button
    HatchHoldOpenButton = new JoystickButton(StickR, 0);

    
  //These buttons are for testing purposes, they will be phased out in the future
    ArmExtendButton = new JoystickButton(StickL, 2);
    ArmRetractButton = new JoystickButton(StickL, 3);

  //These are for the slider piston for the elevator
    SliderForward = new JoystickButton(StickL, 10);
    SliderBack = new JoystickButton(StickL, 14);


    //These buttons are the buttons for the command groups, eventually we will only have these buttons
    //instead of seperate buttons for the ArmExtend/Retract and the elevator buttons
    //We will change the button ports later
    PlaceHatchLevel_1_Button = new JoystickButton(StickR, 2);
    PlaceHatchLevel_2_Button = new JoystickButton(StickR, 1);
    PlaceHatchLevel_3_Button = new JoystickButton(StickR, 3);

  //These buttons are tied to the little joystick called the hat on the big joystick
  //These three go up
    ElevatorUp315 = new POVButton(StickL, 315);
    ElevatorUp360 = new POVButton(StickL, 360);
    ElevatorUp45 = new POVButton(StickL, 45);
  //These three go down
    ElevatorDown135 = new POVButton(StickL, 135);
    ElevatorDown180 = new POVButton(StickL, 180);
    ElevatorDown225 = new POVButton(StickL, 225);

    ElevatorDown = new JoystickButton(StickR, 9);
    ElevatorUp = new JoystickButton(StickR, 4);

  //This method binds the button to a command
  //In this case the hatch button
  //  HatchGrabButton.whenPressed(new HatchGrabCommand());
  //Iedited it so that HatchGrab is now useless
    HatchHoldOpenButton.whileHeld(new HatchHoldOpenCommand());
    /*
    //These are temperary
    */
    ArmExtendButton.whenPressed(new ArmExtendCommand());
    ArmRetractButton.whenPressed(new ArmRetractCommand());

  //The slider command
    SliderForward.whenPressed(new SlideElevatorForwardCommand());
    SliderBack.whenPressed(new SlideElevatorBackCommand());

  //The Place Hatch commands
    PlaceHatchLevel_1_Button.whenPressed(new PlaceHatchLevel_1());
    PlaceHatchLevel_2_Button.whenPressed(new PlaceHatchLevel_2());
    PlaceHatchLevel_3_Button.whenPressed(new PlaceHatchLevel_3());

  //The reason I have three for both up and down is so that it has room for user error
  //These are up
    ElevatorUp315.whileHeld(new ElevatorUpCommand());
    ElevatorUp360.whileHeld(new ElevatorUpCommand());
    ElevatorUp45.whileHeld(new ElevatorUpCommand());
  //These are down
    ElevatorDown135.whileHeld(new ElevatorDownCommand());
    ElevatorDown180.whileHeld(new ElevatorDownCommand());
    ElevatorDown225.whileHeld(new ElevatorDownCommand());

    ElevatorUp.whileHeld(new ElevatorDownCommand());
    ElevatorDown.whileHeld(new ElevatorUpCommand());

  }

 
}
