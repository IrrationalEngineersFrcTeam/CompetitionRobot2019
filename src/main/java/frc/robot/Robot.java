/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
//The imports refer the robot to pre built libraries (mostly wpilib)
// the allows us to use those libraries so it knows what we mean by"Scheduler" for instance.
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSliderSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.HatchMechanismSubsystem;


public class Robot extends TimedRobot {
  //This is more or less the main class, all the others are defined here!
  public static OI oi;
  public static RobotMap robotmap;
  public static DriveSubsystem drivesub;
  public static HatchMechanismSubsystem hatchmechsub;
  public static ElevatorSubsystem elevatesub;
  public static ArmSubsystem armsub;
  public static ElevatorSliderSubsystem elevateslidesub;
  public static NetworkTableInstance inst;
  public static NetworkTable smartDashboardTable;
  public static NetworkTable camera1Table;
  public static NetworkTable camera2Table;
  public static NetworkTableEntry connected;
  public static NetworkTableEntry VisionTargetDist;
  public static NetworkTableEntry piTest;
  public static NetworkTableEntry encoderL;
  public static NetworkTableEntry encoderR;
  public static NetworkTableEntry VisionTargetCentering;

  
  @Override
  public void robotInit() {
  
  hatchmechsub = new HatchMechanismSubsystem();
  elevatesub = new ElevatorSubsystem();
  armsub = new ArmSubsystem();
  elevateslidesub = new ElevatorSliderSubsystem();
  oi = new OI();
  robotmap = new RobotMap();
  drivesub = new DriveSubsystem();
  inst = NetworkTableInstance.getDefault();
  smartDashboardTable = inst.getTable("SmartDashboard");
  camera1Table = inst.getTable("Camera1");
  camera2Table = inst.getTable("Camera2");
  connected = smartDashboardTable.getEntry("robotConnection");
  VisionTargetDist = camera1Table.getEntry("distance");
  encoderL = smartDashboardTable.getEntry("encoderL");
  encoderR = smartDashboardTable.getEntry("encoderR");
  piTest = smartDashboardTable.getEntry("timeRunning");

  }

  
  @Override
  public void robotPeriodic() {

    connected.setBoolean(true);
    //System.out.println(distance.getDouble(0));
    
    //piTest.setDouble(distance.getDouble(0));
    //encoderL.setDouble(leftspeed);
    //encoderR.setDouble(rightspeed);

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
