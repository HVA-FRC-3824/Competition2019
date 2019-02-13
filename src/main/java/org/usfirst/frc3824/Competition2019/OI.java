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
    public JoystickButton changePID;
    public JoystickButton shooterResetAngleEncoder;
    public JoystickButton deployerIn;
    public JoystickButton deployerOut;
    public JoystickButton latchRetract;
    public JoystickButton latchExtend;
    public Joystick joystickControl;
    public JoystickButton highGear;
    public JoystickButton lowGear;
    public Joystick joystickDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        joystickDrive = new Joystick(0);
        
        lowGear = new JoystickButton(joystickDrive, 2);
        lowGear.whenReleased(new ChassisGearShift(false));
        highGear = new JoystickButton(joystickDrive, 2);
        highGear.whenPressed(new ChassisGearShift(true));
        joystickControl = new Joystick(1);
        
        latchExtend = new JoystickButton(joystickControl, 5);
        latchExtend.whenPressed(new Latch(true));
        latchRetract = new JoystickButton(joystickControl, 4);
        latchRetract.whenPressed(new Latch(false));
        deployerOut = new JoystickButton(joystickControl, 3);
        deployerOut.whenPressed(new Deploy(true));
        deployerIn = new JoystickButton(joystickControl, 2);
        deployerIn.whenPressed(new Deploy(false));
        shooterResetAngleEncoder = new JoystickButton(joystickControl, 32);
        shooterResetAngleEncoder.whenPressed(new ResetShooterAngle());
        changePID = new JoystickButton(joystickControl, 32);
        changePID.whenPressed(new SetPIDValues());
        shooterAngleHome = new JoystickButton(joystickControl, 32);
        shooterAngleHome.whenPressed(new ShooterAngleRotate(0));
        shooterAngleIntakeLevel = new JoystickButton(joystickControl, 32);
        shooterAngleIntakeLevel.whenPressed(new ShooterAngleRotate(115));
        shooterAngleFrontBottom = new JoystickButton(joystickControl, 32);
        shooterAngleFrontBottom.whenPressed(new ShooterAngleRotate(-70));
        shooterAngleFrontMiddle = new JoystickButton(joystickControl, 32);
        shooterAngleFrontMiddle.whenPressed(new ShooterAngleRotate(-45));
        shooterAngleFrontTop = new JoystickButton(joystickControl, 32);
        shooterAngleFrontTop.whenPressed(new ShooterAngleRotate(-25));
        shooterAngleBackBottom = new JoystickButton(joystickControl, 32);
        shooterAngleBackBottom.whenPressed(new ShooterAngleRotate(70));
        shooterAngleBackMiddle = new JoystickButton(joystickControl, 32);
        shooterAngleBackMiddle.whenPressed(new ShooterAngleRotate(45));
        shooterAngleBackTop = new JoystickButton(joystickControl, 32);
        shooterAngleBackTop.whenPressed(new ShooterAngleRotate(25));
        unshoot = new JoystickButton(joystickControl, 1);
        unshoot.whenReleased(new ShooterPusherRetract());
        shoot = new JoystickButton(joystickControl, 1);
        shoot.whenPressed(new ShooterPusherExtend());
        stopShooterWheelsCargo = new JoystickButton(joystickControl, 32);
        stopShooterWheelsCargo.whenReleased(new SetShooterSpeedStraight(0));
        straightSpinShooterWheels = new JoystickButton(joystickControl, 32);
        straightSpinShooterWheels.whenPressed(new SetShooterSpeedStraight(1.0));
        frontClimbStop = new JoystickButton(joystickControl, 11);
        frontClimbStop.whenReleased(new FrontClimberRetract());
        frontClimbStart = new JoystickButton(joystickControl, 11);
        frontClimbStart.whenPressed(new FrontClimberExtend());
        backClimbStop = new JoystickButton(joystickControl, 10);
        backClimbStop.whenReleased(new BackClimberRetract());
        backClimbStart = new JoystickButton(joystickControl, 10);
        backClimbStart.whenPressed(new BackClimberExtend());


        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("FrontClimberExtend", new FrontClimberExtend());
        SmartDashboard.putData("FrontClimberRetract", new FrontClimberRetract());
        SmartDashboard.putData("BackClimberExtend", new BackClimberExtend());
        SmartDashboard.putData("BackClimberRetract", new BackClimberRetract());
        SmartDashboard.putData("SetPIDValues", new SetPIDValues());
        SmartDashboard.putData("ResetShooterAngle", new ResetShooterAngle());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystickControl() {
        return joystickControl;
    }

    public Joystick getJoystickDrive() {
        return joystickDrive;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

