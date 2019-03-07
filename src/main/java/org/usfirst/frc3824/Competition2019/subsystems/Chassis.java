// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3824.Competition2019.subsystems;


import com.kauailabs.navx.frc.AHRS;

import org.usfirst.frc3824.Competition2019.Constants;
import org.usfirst.frc3824.Competition2019.Robot;
import org.usfirst.frc3824.Competition2019.commands.*;
import org.usfirst.frc3824.Competition2019.support.Limelight;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.SPI;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Chassis extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private VictorSP right;
    private VictorSP left;
    private DifferentialDrive differentialDrive;
    private Solenoid gearShift;
    private Compressor compressor;
    private AnalogInput ultrasonic;
    private Relay directionLights;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // private double turnAngle_F = Constants.TURNANGLE_F;
    // private double turnAngle_P = Constants.TURNANGLE_P;
    // private double turnAngle_I = Constants.TURNANGLE_I;
    // private double turnangle_D = Constants.TURNANGLE_D;

    // private double drivetrainDriveStraight_P = Constants.DRIVETRAIN_DRIVE_STRAIGHT_P;
    // private double drivetrainDriveStraight_I = Constants.DRIVETRAIN_DRIVE_STRAIGHT_I;
    // private double drivetrainDriveStraight_D = Constants.DRIVETRAIN_DRIVE_STRAIGHT_D;

    private AHRS ahrs = new AHRS(SPI.Port.kMXP);

    // private double m_magnitude;
    
    // public PIDController angleGyroPID = new PIDController(drivetrainDriveStraight_P,
    //                                                       drivetrainDriveStraight_I,
    //                                                       drivetrainDriveStraight_D,
    //                                                       ahrs, new AnglePIDOutput());

    private double camera_P = Constants.CAMERA_P;
    private double camera_I = Constants.CAMERA_I;
    private double camera_D = Constants.CAMERA_D;

    public PIDController cameraPID = new PIDController(camera_P, camera_I, camera_D, 
                                                       Limelight.getInstance(), new CameraPIDOutput());

    // integer controls which direction driving
    public int m_driveDirection;

    public Chassis() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        right = new VictorSP(1);
        addChild("Right",right);
        right.setInverted(true);
        
        left = new VictorSP(0);
        addChild("Left",left);
        left.setInverted(true);
        
        differentialDrive = new DifferentialDrive(left, right);
        addChild("Differential Drive",differentialDrive);
        differentialDrive.setSafetyEnabled(true);
        differentialDrive.setExpiration(0.1);
        differentialDrive.setMaxOutput(1.0);

        
        gearShift = new Solenoid(0, 0);
        addChild("GearShift",gearShift);
        
        
        compressor = new Compressor(0);
        addChild("Compressor ",compressor);
        
        
        ultrasonic = new AnalogInput(0);
        addChild("Ultrasonic",ultrasonic);
        
        
        directionLights = new Relay(0);
        addChild("DirectionLights",directionLights);
        
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        // initialize drive direction as 1
        m_driveDirection = 1;

        // initialize gear shift in low gear
        // /******************************************************************************
        //  * NOTE: CURRENT GEAR SHIFT CODE IS INCORRECT, BUT CORRECT WAY DOES NOT WORK. *
        //  ******************************************************************************/
        // gearShift.set(true);

        resetNavXGyro();

        // angleGyroPID.setInputRange(-360, 360);

        // compressor.start(); // starts compressor
        // compressor.stop();
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new TeleopDrive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    /*********************************************************************
     * Method to control the drive through the specified joystick
     *********************************************************************/
    // private class AnglePIDOutput implements PIDOutput
    // {
    //     public void pidWrite(double PIDOutput)
    //     {
    //         differentialDrive.arcadeDrive(-m_magnitude, -PIDOutput, false);
    //     }
    // }
    private class CameraPIDOutput implements PIDOutput
    {
        public void pidWrite(double PIDOutput)
        {
            differentialDrive.arcadeDrive(Robot.oi.joystickDrive.getY(), PIDOutput, false);
        }
    }
    public void resetChassisPIDcontrollers()
    {
        // Reset the camera PID 
        cameraPID.reset();

        // Disable the camera PID controller
        cameraPID.disable();
    }
    public void driveToTargetWithCameraPID()
    {
        // Drive straight means keep current heading
        startCameraPID(camera_P, camera_I, camera_D, 
                     Constants.DRIVETRAIN_DRIVE_MINIMUM_OUTPUT, 
                     Constants.DRIVETRAIN_DRIVE_MAXIMUM_OUTPUT);
    }
    private void startCameraPID(double P, double I, double D, double minimumOutput, double maximumOutput)
    {
        // reset other PIDS
        resetChassisPIDcontrollers();

        // Initialize the Gryo angle PID parameters
        cameraPID.setPID(P, I, D);

        // Limit the output power when turning
        cameraPID.setOutputRange(minimumOutput, maximumOutput);

        // Enable the Gyro PID
        cameraPID.enable();
    }
    public void turnOnDirectionLights()
    {
        directionLights.set(Relay.Value.kOn);
    }
    public void setDirectionLights()
    {
        // Change lights that represents drive direction
        if (m_driveDirection == 1)
            directionLights.set(Relay.Value.kForward);
        else if (m_driveDirection == -1)
            directionLights.set(Relay.Value.kReverse);
        else
            directionLights.set(Relay.Value.kOff);
    }
    public void driveWithPower(double power)
    {
        differentialDrive.arcadeDrive(power, 0.0);
    }
    public void driveWithJoystick(Joystick stick)
    {
        double twist     =  stick.getTwist();
        double moveValue =  stick.getY();

        // Reduce the sensitivity of the joystick
        if (Math.abs(twist) > 0.2)
            // By default, positive
            twist *= 0.8;
  
        // Drive with arcade control
        // By default, negative
        differentialDrive.arcadeDrive((m_driveDirection * moveValue), -twist);
    }
    public void flipDriveDirection()
    {
        // Change drive direction
        m_driveDirection = -m_driveDirection;

        // Change direction lights
        setDirectionLights();
    }
    public void setDriveDirection(int direction)
    {
        // Change drive direction to desired
        // 1: (Back of Robot) // -1: (Front of Robot)
        m_driveDirection = direction;

        // Change direction lights
        setDirectionLights();
    }
    public boolean getDriveDirection()
    {
        // 1: Back of Robot, -1: Front of Robot
        if (m_driveDirection == -1)
            return true;
        else
            return false;
    }
    public void resetNavXGyro()
    {
        ahrs.reset();
    }
    /*********************************************************************
     * Gets angle of navx gyro
     *********************************************************************/
    public double getGyroAngle()
    {
        return (ahrs.getAngle());
    }
    /*********************************************************************
     * Gets ultrasonic distance in inches
     *********************************************************************/
    public double getUltrasonicDistance()
    {
        //get ultrasonic distance
        return ((Robot.constants.ULTRASONIC_SLOPE * ultrasonic.getVoltage()) + Robot.constants.ULTRASONIC_OFFSET);
    }
    /*********************************************************************
     * Shift to high gear
     *********************************************************************/
    public void shiftHighGear()
    {
        gearShift.set(true);
    }
    /*********************************************************************
     * Shift to low gear
     *********************************************************************/
    public void shiftLowGear()
    {
        gearShift.set(false);
    }
}
