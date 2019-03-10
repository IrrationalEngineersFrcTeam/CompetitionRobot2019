/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.ReleaseClimberArmsCommand;
import frc.robot.commands.ElevatorUpCommand;
import frc.robot.commands.SlideElevatorBackCommand;
import frc.robot.commands.SlideElevatorForwardCommand;
import frc.robot.commands.ClimberPistonsExtendCommand;

public class ClimbUpCommand extends CommandGroup {
  /**
   * Add your docs here.
   */
  public ClimbUpCommand() {
    // Add Commands here:
    // e.g. addSequential(new Command1());
    //      addSequential(new Command2());
    // these will run in order.

    requires(Robot.climbersub);
    requires(Robot.elevateslidesub);
    requires(Robot.elevatesub);

    addSequential(new ElevatorUpCommand());
    addSequential(new SlideElevatorForwardCommand(), 0.5);
    System.out.println("Releasing climber arms");
    addSequential(new ReleaseClimberArmsCommand(), 1);
    System.out.println("Extending climber pistons");
    addSequential(new ClimberPistonsExtendCommand(), 0.5);
    addSequential(new SlideElevatorBackCommand(), 0.5);

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
