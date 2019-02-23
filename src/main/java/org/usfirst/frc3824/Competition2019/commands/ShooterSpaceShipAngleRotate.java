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
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc3824.Competition2019.Constants;
import org.usfirst.frc3824.Competition2019.Robot;

/**
 *
 */
public class ShooterSpaceShipAngleRotate extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public ShooterSpaceShipAngleRotate() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        if (Robot.oi.board.getRawButton(9)) // back
        {
            if (Robot.oi.board.getRawButton(7)) // 7 = top
            {
                Robot.shooter.setAngleEncoder(Constants.SHOOTER_SPACESHIP_BACK_TOP_ANGLE_POSITION);
            }
            else if (Robot.oi.board.getRawButton(19)) // 19 = bottom
            {
                Robot.shooter.setAngleEncoder(Constants.SHOOTER_SPACESHIP_BOTTOM_ANGLE_POSITION);
            }
            else // if neither = middle
            {
                Robot.shooter.setAngleEncoder(Constants.SHOOTER_SPACESHIP_BACK_MIDDLE_ANGLE_POSITION);
            }
        }
        else if (Robot.oi.board.getRawButton(8)) // front
        {
            if (Robot.oi.board.getRawButton(7)) // 7 = top
            {
                Robot.shooter.setAngleEncoder(Constants.SHOOTER_SPACESHIP_FRONT_TOP_ANGLE_POSITION);
            }
            else if (Robot.oi.board.getRawButton(19)) // 19 = bottom
            {
                Robot.shooter.setAngleEncoder(Constants.SHOOTER_SPACESHIP_BOTTOM_ANGLE_POSITION);
            }
            else // if neither = middle
            {
                Robot.shooter.setAngleEncoder(Constants.SHOOTER_SPACESHIP_FRONT_MIDDLE_ANGLE_POSITION);
            }
        }
        else
        {
            System.out.println("\n******NO POSITION SELECTED (FRONT/BACK)******\n");
        }
        Robot.shooter.setShooterType(true);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
