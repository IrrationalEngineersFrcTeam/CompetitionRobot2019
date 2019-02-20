/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.ElevatorUpCommand;
import frc.robot.Robot;
import frc.robot.commands.ArmExtendCommand;
import frc.robot.commands.SlideElevatorBackCommand;

public class PlaceHatchLevel_3 extends CommandGroup {
  /**
   * Add your docs here.
   */
  public PlaceHatchLevel_3() {
    // Add Commands here:
    // e.g. addSequential(new Command1());
    //      addSequential(new Command2());
    // these will run in order.

    requires(Robot.elevateslidesub);
    requires(Robot.elevatesub);
    requires(Robot.armsub);

    addSequential(new SlideElevatorBackCommand(), 1);
    System.out.println("Sliding Back");
    addSequential(new ArmExtendCommand(), 1);
    System.out.println("Extending Arm");
    addSequential(new ElevatorUpCommand());
    System.out.println("Elevator Going Up");

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    //      addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.



  }
}
