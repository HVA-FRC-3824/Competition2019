// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3824.Competition2019;

import org.usfirst.frc3824.Competition2019.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton backClimbStart;
    public JoystickButton backClimbStop;
    public JoystickButton frontClimbStart;
    public JoystickButton frontClimbStop;
    public JoystickButton straightSpinShooterWheels;
    public JoystickButton stopShooterWheelsCargo;
    public JoystickButton shoot;
    public JoystickButton unshoot;
    public JoystickButton shooterAngleBackTop;
    public JoystickButton shooterAngleBackMiddle;
    public JoystickButton shooterAngleBackBottom;
    public JoystickButton shooterAngleFrontTop;
    public JoystickButton shooterAngleFrontMiddle;
    public JoystickButton shooterAngleFrontBottom;
    public JoystickButton shooterAngleIntakeLevel;
    public JoystickButton shooterAngleHome;
    public JoystickButton shooterResetAngleEncoder;
    public JoystickButton deployerToggle;
    public Joystick joystickControl;
    public JoystickButton highGear;
    public JoystickButton lowGear;
    public JoystickButton climbCenter;
    public JoystickButton climbSide;
    public JoystickButton killClimb;
    public JoystickButton reviveClimb;
    public JoystickButton cameraMode;
    public JoystickButton driveToggleDirection;
    public Joystick joystickDrive;
    public JoystickButton latchToggle;
    public JoystickButton hatchToggle;
    public JoystickButton hatchPickupUp;
    public JoystickButton hatchPickupDown;
    public JoystickButton shooterStepUp;
    public JoystickButton shooterStepDown;
    public JoystickButton shooterHomeAngle;
    public JoystickButton shooterIntakeAngle;
    public JoystickButton shooterStartSpinIn;
    public JoystickButton shooterStopSpinIn;
    public JoystickButton shooterStartSpinOut;
    public JoystickButton shooterStopSpinOut;
    public JoystickButton shooterShootPrepare;
    public JoystickButton shooterShootDeploy;
    public JoystickButton shooterCargoShipAngle;
    public JoystickButton shooterSpaceShipAngle;
    public Joystick board;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        board = new Joystick(2);
        
        shooterSpaceShipAngle = new JoystickButton(board, 5);
        shooterSpaceShipAngle.whenPressed(new ShooterSpaceShipAngleRotate());
        shooterCargoShipAngle = new JoystickButton(board, 6);
        shooterCargoShipAngle.whenPressed(new ShooterCargoShipAngleRotate());
        shooterShootDeploy = new JoystickButton(board, 11);
        shooterShootDeploy.whenReleased(new ShooterDeploy());
        shooterShootPrepare = new JoystickButton(board, 11);
        shooterShootPrepare.whenPressed(new ShooterPrepare());
        shooterStopSpinOut = new JoystickButton(board, 10);
        shooterStopSpinOut.whenReleased(new SetShooterSpeedStraight(0));
        shooterStartSpinOut = new JoystickButton(board, 10);
        shooterStartSpinOut.whenPressed(new SetShooterSpeedStraight(-2000));
        shooterStopSpinIn = new JoystickButton(board, 14);
        shooterStopSpinIn.whenReleased(new SetShooterSpeedStraight(0));
        shooterStartSpinIn = new JoystickButton(board, 14);
        shooterStartSpinIn.whenPressed(new SetShooterSpeedStraight(2000));
        shooterIntakeAngle = new JoystickButton(board, 4);
        shooterIntakeAngle.whenPressed(new ShooterAngleRotate(12300));
        shooterHomeAngle = new JoystickButton(board, 3);
        shooterHomeAngle.whenPressed(new ShooterAngleRotate(0));
        shooterStepDown = new JoystickButton(board, 2);
        shooterStepDown.whenPressed(new ShooterStepDown(250));
        shooterStepUp = new JoystickButton(board, 1);
        shooterStepUp.whenPressed(new ShooterStepUp(250));
        hatchPickupDown = new JoystickButton(board, 13);
        hatchPickupDown.whenPressed(new HatchPickupAngleRotate(4500));
        hatchPickupUp = new JoystickButton(board, 12);
        hatchPickupUp.whenPressed(new HatchPickupAngleRotate(0));
        hatchToggle = new JoystickButton(board, 15);
        hatchToggle.whenPressed(new HatchPanelDeploy());
        latchToggle = new JoystickButton(board, 16);
        latchToggle.whenPressed(new HatchPanelLatch());
        joystickDrive = new Joystick(0);
        
        driveToggleDirection = new JoystickButton(joystickDrive, 1);
        driveToggleDirection.whenPressed(new ToggleDriveDirection());
        cameraMode = new JoystickButton(joystickDrive, 11);
        cameraMode.whenPressed(new ToggleCamMode());
        reviveClimb = new JoystickButton(joystickDrive, 4);
        reviveClimb.whenPressed(new ReviveClimber());
        killClimb = new JoystickButton(joystickDrive, 3);
        killClimb.whenPressed(new KillClimber());
        climbSide = new JoystickButton(joystickDrive, 6);
        climbSide.whenPressed(new AllSystemsClimbSide());
        climbCenter = new JoystickButton(joystickDrive, 5);
        climbCenter.whenPressed(new AllSystemsClimbCenter());
        lowGear = new JoystickButton(joystickDrive, 2);
        lowGear.whenReleased(new ChassisGearShift(false));
        highGear = new JoystickButton(joystickDrive, 2);
        highGear.whenPressed(new ChassisGearShift(true));
        joystickControl = new Joystick(1);
        
        deployerToggle = new JoystickButton(joystickControl, 32);
        deployerToggle.whenPressed(new HatchPanelDeploy());
        shooterResetAngleEncoder = new JoystickButton(joystickControl, 32);
        shooterResetAngleEncoder.whenPressed(new ResetShooterAngle());
        shooterAngleHome = new JoystickButton(joystickControl, 3);
        shooterAngleHome.whenPressed(new ShooterAngleRotate(0));
        shooterAngleIntakeLevel = new JoystickButton(joystickControl, 32);
        shooterAngleIntakeLevel.whenPressed(new ShooterAngleRotate(0));
        shooterAngleFrontBottom = new JoystickButton(joystickControl, 32);
        shooterAngleFrontBottom.whenPressed(new ShooterAngleRotate(0));
        shooterAngleFrontMiddle = new JoystickButton(joystickControl, 32);
        shooterAngleFrontMiddle.whenPressed(new ShooterAngleRotate(0));
        shooterAngleFrontTop = new JoystickButton(joystickControl, 32);
        shooterAngleFrontTop.whenPressed(new ShooterAngleRotate(0));
        shooterAngleBackBottom = new JoystickButton(joystickControl, 32);
        shooterAngleBackBottom.whenPressed(new ShooterAngleRotate(0));
        shooterAngleBackMiddle = new JoystickButton(joystickControl, 32);
        shooterAngleBackMiddle.whenPressed(new ShooterAngleRotate(0));
        shooterAngleBackTop = new JoystickButton(joystickControl, 4);
        shooterAngleBackTop.whenPressed(new ShooterAngleRotate(800));
        unshoot = new JoystickButton(joystickControl, 1);
        unshoot.whenReleased(new ShooterPusherRetract());
        shoot = new JoystickButton(joystickControl, 1);
        shoot.whenPressed(new ShooterPusherExtend());
        stopShooterWheelsCargo = new JoystickButton(joystickControl, 32);
        stopShooterWheelsCargo.whenReleased(new SetShooterSpeedStraight(0));
        straightSpinShooterWheels = new JoystickButton(joystickControl, 32);
        straightSpinShooterWheels.whenPressed(new SetShooterSpeedStraight(0));
        frontClimbStop = new JoystickButton(joystickControl, 11);
        frontClimbStop.whenPressed(new ClimberFrontSetPosition(0));
        frontClimbStart = new JoystickButton(joystickControl, 6);
        frontClimbStart.whenPressed(new ClimberFrontSetPosition(15000));
        backClimbStop = new JoystickButton(joystickControl, 10);
        backClimbStop.whenPressed(new ClimberBackSetPosition(0));
        backClimbStart = new JoystickButton(joystickControl, 7);
        backClimbStart.whenPressed(new ClimberBackSetPosition(15000));


        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("ShooterSetPIDValues", new ShooterSetPIDValues());
        SmartDashboard.putData("ResetShooterAngle", new ResetShooterAngle());
        SmartDashboard.putData("ShooterTopSetPIDValues", new ShooterTopSetPIDValues());
        SmartDashboard.putData("ShooterBottomSetPIDValues", new ShooterBottomSetPIDValues());
        SmartDashboard.putData("ClimberFrontSetPIDValues", new ClimberFrontSetPIDValues());
        SmartDashboard.putData("ClimberBackSetPIDValues", new ClimberBackSetPIDValues());
        SmartDashboard.putData("HatchPickupSetPIDValues", new HatchPickupSetPIDValues());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystickControl() {
        return joystickControl;
    }

    public Joystick getJoystickDrive() {
        return joystickDrive;
    }

    public Joystick getBoard() {
        return board;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

