/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
//The imports refer the robot to pre built libraries (mostly wpilib)
// the allows us to use those libraries so it knows what we mean by"Scheduler" for instance.
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.HatchMechanismSubsystem;



public class Robot extends TimedRobot {
  //This is more or less the main class, all the others are defined here!
  public static OI oi;
  public static RobotMap robotmap;
  public static DriveSubsystem drivesub;
  public static HatchMechanismSubsystem hatchmechsub;
  public static NetworkTable connectionTable;
  
  @Override
  public void robotInit() {
  
    connectionTable = NetworkTable.getTable("SmartDashboard/robotConnection");

    connectionTable.putBoolean("key", true);

  hatchmechsub = new HatchMechanismSubsystem();
  oi = new OI();
  robotmap = new RobotMap();
  drivesub = new DriveSubsystem();


  }

  
  @Override
  public void robotPeriodic() {
  }

 
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  
  @Override
  public void autonomousInit() {
   
    
    
  }

 
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    
    }
  

  
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  
  @Override
  public void testPeriodic() {
  }
}
