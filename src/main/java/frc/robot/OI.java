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
import frc.robot.commands.HatchGrabCommand;
import frc.robot.commands.HatchReleaseCommand;

public class OI {
//This creates any joysticks we will use to drive the robot,
//in this case a left joystick and a right joystick.
  public Joystick StickL;
  public Joystick StickR;

//Here we have the hatch mechanism button
  public Button HatchMechRelease;
  public Button HatchMechGrab;


  public OI() {
    //This tells the robot what ports these joysticks will be connected to, 

    StickL = new Joystick(0);
    StickR = new Joystick(1);

    HatchMechRelease = new JoystickButton(StickR, 1);
    HatchMechGrab = new JoystickButton(StickR, 2);

  //This method binds the button to a command
  //In this case the hatch button
    //HatchMechButton.whileHeld(new HatchGrabCommand());
    HatchMechRelease.whenPressed(new HatchReleaseCommand());
    HatchMechGrab.whenPressed(new HatchGrabCommand());

  }

 
}
