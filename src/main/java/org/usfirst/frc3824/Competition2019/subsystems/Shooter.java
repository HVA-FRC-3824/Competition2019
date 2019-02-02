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


import org.usfirst.frc3824.Competition2019.Constants;
import org.usfirst.frc3824.Competition2019.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Shooter extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private WPI_TalonSRX shooterWheelsTop;
    private WPI_TalonSRX shooterWheelsBottom;
    private Solenoid shooterPusher;
    private WPI_TalonSRX shooterAngle;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    private double shooterAnglePIDParamF = Constants.SHOOTER_ANGLE_F;
    private double shooterAnglePIDParamP = Constants.SHOOTER_ANGLE_P;
    private double shooterAnglePIDParamI = Constants.SHOOTER_ANGLE_I;
    private double shooterAnglePIDParamD = Constants.SHOOTER_ANGLE_D;
    private int    shooterAngleCruisevelocity = Constants.SHOOTER_ANGLE_CRUISE_VELOCITY;
    private int    shooterAngleAcceleration   = Constants.SHOOTER_ANGLE_ACCELERATION;

    private double shooterAngleSetpoint       = 0;

    public Shooter() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        shooterWheelsTop = new WPI_TalonSRX(0);
        
        
        
        shooterWheelsBottom = new WPI_TalonSRX(1);
        
        
        
        shooterPusher = new Solenoid(0, 3);
        addChild("ShooterPusher",shooterPusher);
        
        
        shooterAngle = new WPI_TalonSRX(2);
        
        
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        shooterAngle.configFactoryDefault();
        shooterAngle.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,
                                                  Constants.K_PID_LOOP_IDX,
                                                  Constants.K_TIMEOUT_MS);

        shooterAngle.setSensorPhase(true);
        shooterAngle.setInverted(false);
        
        shooterAngle.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, Constants.K_TIMEOUT_MS);
        shooterAngle.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, Constants.K_TIMEOUT_MS);
    
        shooterAngle.configNominalOutputForward(0, Constants.K_TIMEOUT_MS);
        shooterAngle.configNominalOutputReverse(0, Constants.K_TIMEOUT_MS);
        shooterAngle.configPeakOutputForward(1, Constants.K_TIMEOUT_MS);
        shooterAngle.configPeakOutputReverse(-1, Constants.K_TIMEOUT_MS);

        shooterAngle.selectProfileSlot(Constants.K_SLOT_IDX, Constants.K_PID_LOOP_IDX);
        shooterAngle.config_kF(Constants.K_SLOT_IDX, shooterAnglePIDParamF, Constants.K_TIMEOUT_MS);
        shooterAngle.config_kP(Constants.K_SLOT_IDX, shooterAnglePIDParamP, Constants.K_TIMEOUT_MS);
        shooterAngle.config_kI(Constants.K_SLOT_IDX, shooterAnglePIDParamI, Constants.K_TIMEOUT_MS);
        shooterAngle.config_kD(Constants.K_SLOT_IDX, shooterAnglePIDParamD, Constants.K_TIMEOUT_MS);

        shooterAngle.configMotionCruiseVelocity(shooterAngleCruisevelocity, Constants.K_TIMEOUT_MS);
        shooterAngle.configMotionAcceleration(shooterAngleAcceleration, Constants.K_TIMEOUT_MS);
    
        shooterAngle.setSelectedSensorPosition(0, Constants.K_PID_LOOP_IDX, Constants.K_TIMEOUT_MS);
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


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
    /****************************************************************
     * Set wheels speed of shooter -- PID's not implemeneted/needed *
     ****************************************************************/
    public void setWheelSpeed(double speed)
    {
        shooterWheelsTop.set(speed);
        shooterWheelsBottom.set(speed);
    }
    /**********************************
     * Returns velocity of top wheels *
     **********************************/
    public double getWheelTopVelocity()
    {
        return shooterWheelsTop.getSelectedSensorVelocity();
    }
    /*************************************
     * Returns velocity of bottom wheels *
     *************************************/
    public double getWheelBottomVelocity()
    {
        return shooterWheelsBottom.getSelectedSensorVelocity();
    }
    /**************************************
     * Extend/Retract piston for shooting *
     **************************************/
    public void setPusher(boolean status)
    {
        shooterPusher.set(status);
    }
    /****************************************************************
     * Accepts degrees as parameter and sets angle as encoder value *
     ****************************************************************/
    public void setAngle(double angle)
    {
        // prevents going over maximum and minimum angles
        if (angle > Constants.SHOOTER_ANGLE_MAXIMUM)
            angle = Constants.SHOOTER_ANGLE_MAXIMUM;
        else if (angle < Constants.SHOOTER_ANGLE_MINIMUM)
            angle = Constants.SHOOTER_ANGLE_MINIMUM;

        // calculate encoder value from given degrees angle
        // 4096 ticks/rev
        shooterAngleSetpoint = (angle * (Constants.SHOOTER_ANGLE_ENCODER_YINTERCEPT / 90)) + Constants.SHOOTER_ANGLE_ENCODER_YINTERCEPT;

        shooterAngle.set(ControlMode.MotionMagic, shooterAngleSetpoint);
    }
    /***********************************
     * Returns error of PID controller *
     ***********************************/
    public double getAngleError()
    {
        return shooterAngle.getClosedLoopError();
    }
    /****************************************************
     * Returns percent of maximum output of angle motor *
     ****************************************************/
    public double getAngleMotorPercent()
    {
        return shooterAngle.getMotorOutputPercent();
    }
    /***************************************
     * Returns control mode of angle motor *
     ***************************************/
    public ControlMode getAngleMotorControlMode()
    {
        return shooterAngle.getControlMode();
    }
    /****************************************************
     * Returns setpoint of angle motor as encoder value *
     ****************************************************/
    public double getAngleSetpoint()
    {
        return 0; //CHANGE THIS
    }
    /***********************************
     * Returns velocity of angle motor *
     ***********************************/
    public double getAngleVelocity()
    {
        return shooterAngle.getSelectedSensorVelocity();
    }
    /*******************************************
     * Returns angle of motor as encoder value *
     *******************************************/
    public double getAnglePositionEncoder()
    {
        return shooterAngle.getSelectedSensorPosition(0);
    }
    /******************************
     * Resets angle encoder value *
     ******************************/
    public void resetAngleEncoders()
    {
        shooterAngle.setSelectedSensorPosition(0, 0, Constants.K_TIMEOUT_MS);
    }
    /***********************************************************
     * Allows for editing of PID values for easier calibrating *
     ***********************************************************/
    public void setAnglePID()
    {
        shooterAnglePIDParamF = SmartDashboard.getNumber("SHOOTER ANGLE F", Constants.SHOOTER_ANGLE_F);
        shooterAnglePIDParamP = SmartDashboard.getNumber("SHOOTER ANGLE P", Constants.SHOOTER_ANGLE_P);
        shooterAnglePIDParamP = SmartDashboard.getNumber("SHOOTER ANGLE I", Constants.SHOOTER_ANGLE_I);
        shooterAnglePIDParamP = SmartDashboard.getNumber("SHOOTER ANGLE D", Constants.SHOOTER_ANGLE_D);
        shooterAngleCruisevelocity = (int)SmartDashboard.getNumber("SHOOTER ANGLE CRUISE VELOCITY", Constants.SHOOTER_ANGLE_CRUISE_VELOCITY);
        shooterAngleAcceleration = (int)SmartDashboard.getNumber("SHOOTER ANGLE ACCELERATION", Constants.SHOOTER_ANGLE_ACCELERATION);

        shooterAngle.config_kF(0, shooterAnglePIDParamF, Constants.K_TIMEOUT_MS);
        shooterAngle.config_kP(0, shooterAnglePIDParamP, Constants.K_TIMEOUT_MS);
        shooterAngle.config_kI(0, shooterAnglePIDParamI, Constants.K_TIMEOUT_MS);
        shooterAngle.config_kD(0, shooterAnglePIDParamD, Constants.K_TIMEOUT_MS);

        shooterAngle.configMotionCruiseVelocity(shooterAngleCruisevelocity, Constants.K_TIMEOUT_MS);
        shooterAngle.configMotionAcceleration(shooterAngleAcceleration, Constants.K_TIMEOUT_MS);
    }
}
