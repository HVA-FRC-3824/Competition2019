// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3824.Competition2019.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc3824.Competition2019.Constants;
import org.usfirst.frc3824.Competition2019.subsystems.*;

/**
 *
 */
public class AllSystemsClimb extends CommandGroup {


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
    public AllSystemsClimb() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

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
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS
        // ensure shooter angle is in climb start position
        addSequential(new ShooterAngleRotate(Constants.ALL_SHOOTER_CLIMB_START_POSITION));

        // ensure robot is against platform
        addSequential(new DriveWithPower(Constants.ALL_CHASSIS_INITIAL_POWER, 2), 3.0);
        
        // extends front and back climber at the same time
        addParallel(new ClimberFrontSetPosition(Constants.ALL_FRONT_CLIMBER_EXTEND_POSITION));
        addSequential(new ClimberBackSetPosition(Constants.ALL_BACK_CLIMBER_EXTEND_POSITION));

        // rotate shooter angle in order to pull robot onto platform
        addSequential(new ShooterAngleRotate(Constants.ALL_SHOOTER_PULL_IN_POSITION));

        // start shooter climber wheels in order to pull in
        addParallel(new SetShooterSpeedStraight(Constants.ALL_SHOOTER_PULL_IN_RPM));
        
        // drive forward onto the platform
        addSequential(new DriveWithPower(Constants.ALL_CHASSIS_PLATFORM_POWER, 2), 3.0);

        // bring up front climber
        addSequential(new ClimberFrontSetPosition(Constants.ALL_FRONT_CLIMBER_RETRACT_POSITION));

        // drive forward onto the platform
        addSequential(new DriveWithPower(Constants.ALL_CHASSIS_PLATFORM_POWER, 2), 3.0);

        // bring up back climber
        addSequential(new ClimberBackSetPosition(Constants.ALL_BACK_CLIMBER_RETRACT_POSITION));

        // drive frowrad onto the platform
        addParallel(new DriveWithPower(Constants.ALL_CHASSIS_PLATFORM_POWER, 2), 3.0);
        
        // bring shooter angle rotate to home position
        addSequential(new ShooterAngleRotate(Constants.ALL_SHOOTER_HOME_POSITION));
    } 
}
