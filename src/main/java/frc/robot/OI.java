/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;


public class OI {
//This creates any joysticks we will use to drive the robot,
//in this case a left joystick and a right joystick.
  public Joystick StickL;
  public Joystick StickR;


  public OI() {
    //This tells the robot what ports these joysticks will be connected to, 

    StickL = new Joystick(0);
    StickR = new Joystick(1);


  }

 
}
