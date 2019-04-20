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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.DemandType;
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
    private WPI_TalonSRX shooterAngleMaster;
    private WPI_TalonSRX shooterAngleSlave;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    private double shooterAnglePIDParamF = Constants.SHOOTER_ANGLE_F;
    private double shooterAnglePIDParamP = Constants.SHOOTER_ANGLE_P;
    private double shooterAnglePIDParamI = Constants.SHOOTER_ANGLE_I;
    private double shooterAnglePIDParamD = Constants.SHOOTER_ANGLE_D;
    private int    shooterAngleCruiseVelocity = Constants.SHOOTER_ANGLE_CRUISE_VELOCITY;
    private int    shooterAngleAcceleration   = Constants.SHOOTER_ANGLE_ACCELERATION;

    private int shooterAngleSetpoint       = 0;

    private double shooterWheelsTopPIDParamF = Constants.SHOOTER_WHEELS_TOP_F;
    private double shooterWheelsTopPIDParamP = Constants.SHOOTER_WHEELS_TOP_P;
    private double shooterWheelsTopPIDParamI = Constants.SHOOTER_WHEELS_TOP_I;
    private double shooterWheelsTopPIDParamD = Constants.SHOOTER_WHEELS_TOP_D;

    private double shooterWheelsBottomPIDParamF = Constants.SHOOTER_WHEELS_BOTTOM_F;
    private double shooterWheelsBottomPIDParamP = Constants.SHOOTER_WHEELS_BOTTOM_P;
    private double shooterWheelsBottomPIDParamI = Constants.SHOOTER_WHEELS_BOTTOM_I;
    private double shooterWheelsBottomPIDParamD = Constants.SHOOTER_WHEELS_BOTTOM_D;

    private boolean pusherStatus = false;

    /***
     * Boolean shows if cargo shoot angle or spaceship shoot angle 
     */
    private boolean shooterAngleType = false;

    public Shooter() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        shooterWheelsTop = new WPI_TalonSRX(4);
        
        
        
        shooterWheelsBottom = new WPI_TalonSRX(3);
        
        
        
        shooterPusher = new Solenoid(0, 1);
        addChild("ShooterPusher",shooterPusher);
        
        
        shooterAngleMaster = new WPI_TalonSRX(2);
        
        
        
        shooterAngleSlave = new WPI_TalonSRX(1);
        
        
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        /*********************
         * Shooter Angle PID *
         *********************/

        shooterAngleMaster.configFactoryDefault();
        shooterAngleMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,
                                                  Constants.K_PID_LOOP_IDX,
                                                  Constants.K_TIMEOUT_MS);

        shooterAngleMaster.setSensorPhase(false);
        shooterAngleMaster.setInverted(true);
        
        shooterAngleMaster.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, Constants.K_TIMEOUT_MS);
        shooterAngleMaster.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, Constants.K_TIMEOUT_MS);
    
        shooterAngleMaster.configNominalOutputForward(0, Constants.K_TIMEOUT_MS);
        shooterAngleMaster.configNominalOutputReverse(0, Constants.K_TIMEOUT_MS);
        shooterAngleMaster.configPeakOutputForward(1, Constants.K_TIMEOUT_MS);
        shooterAngleMaster.configPeakOutputReverse(-1, Constants.K_TIMEOUT_MS);

        shooterAngleMaster.selectProfileSlot(Constants.K_SLOT_IDX, Constants.K_PID_LOOP_IDX);
        shooterAngleMaster.config_kF(Constants.K_SLOT_IDX, shooterAnglePIDParamF, Constants.K_TIMEOUT_MS);
        shooterAngleMaster.config_kP(Constants.K_SLOT_IDX, shooterAnglePIDParamP, Constants.K_TIMEOUT_MS);
        shooterAngleMaster.config_kI(Constants.K_SLOT_IDX, shooterAnglePIDParamI, Constants.K_TIMEOUT_MS);
        shooterAngleMaster.config_kD(Constants.K_SLOT_IDX, shooterAnglePIDParamD, Constants.K_TIMEOUT_MS);

        shooterAngleMaster.configMotionCruiseVelocity(shooterAngleCruiseVelocity, Constants.K_TIMEOUT_MS);
        shooterAngleMaster.configMotionAcceleration(shooterAngleAcceleration, Constants.K_TIMEOUT_MS);
    
        shooterAngleMaster.setSelectedSensorPosition(0, Constants.K_PID_LOOP_IDX, Constants.K_TIMEOUT_MS);

        shooterAngleSlave.follow(shooterAngleMaster);
        shooterAngleSlave.setInverted(false);

        /**************************
         * Shooter Wheels Top PID *
         **************************/
        shooterWheelsTop.configFactoryDefault();
        shooterWheelsTop.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,
                                                        Constants.K_PID_LOOP_IDX,
                                                        Constants.K_TIMEOUT_MS);

        shooterWheelsTop.setSensorPhase(true);
        shooterWheelsTop.setInverted(true);

        shooterWheelsTop.configNominalOutputForward(0, Constants.K_TIMEOUT_MS);
        shooterWheelsTop.configNominalOutputReverse(0, Constants.K_TIMEOUT_MS);
        shooterWheelsTop.configPeakOutputForward(1, Constants.K_TIMEOUT_MS);
        shooterWheelsTop.configPeakOutputReverse(-1, Constants.K_TIMEOUT_MS);

        shooterWheelsTop.config_kF(Constants.K_SLOT_IDX, shooterWheelsTopPIDParamF, Constants.K_TIMEOUT_MS);
        shooterWheelsTop.config_kP(Constants.K_SLOT_IDX, shooterWheelsTopPIDParamP, Constants.K_TIMEOUT_MS);
        shooterWheelsTop.config_kI(Constants.K_SLOT_IDX, shooterWheelsTopPIDParamI, Constants.K_TIMEOUT_MS);
        shooterWheelsTop.config_kD(Constants.K_SLOT_IDX, shooterWheelsTopPIDParamD, Constants.K_TIMEOUT_MS);

        /*****************************
         * Shooter Wheels Bottom PID *
         *****************************/
        shooterWheelsBottom.configFactoryDefault();
        shooterWheelsBottom.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,
                                                        Constants.K_PID_LOOP_IDX,
                                                        Constants.K_TIMEOUT_MS);

        shooterWheelsBottom.setSensorPhase(true);
        shooterWheelsBottom.setInverted(true);

        shooterWheelsBottom.configNominalOutputForward(0, Constants.K_TIMEOUT_MS);
        shooterWheelsBottom.configNominalOutputReverse(0, Constants.K_TIMEOUT_MS);
        shooterWheelsBottom.configPeakOutputForward(1, Constants.K_TIMEOUT_MS);
        shooterWheelsBottom.configPeakOutputReverse(-1, Constants.K_TIMEOUT_MS);

        shooterWheelsBottom.config_kF(Constants.K_SLOT_IDX, shooterWheelsBottomPIDParamF, Constants.K_TIMEOUT_MS);
        shooterWheelsBottom.config_kP(Constants.K_SLOT_IDX, shooterWheelsBottomPIDParamP, Constants.K_TIMEOUT_MS);
        shooterWheelsBottom.config_kI(Constants.K_SLOT_IDX, shooterWheelsBottomPIDParamI, Constants.K_TIMEOUT_MS);
        shooterWheelsBottom.config_kD(Constants.K_SLOT_IDX, shooterWheelsBottomPIDParamD, Constants.K_TIMEOUT_MS);

        shooterAngleMaster.set(ControlMode.MotionMagic, 0);
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

        // Constantly update feedforward based on gravity acting on shooter
        /*double arbFeedForward = Constants.SHOOTER_ANGLE_HORIZONTAL_STALL_OUTPUT * Math.cos(getAngleRadians());

        shooterAngleMaster.set(ControlMode.MotionMagic, shooterAngleSetpoint, DemandType.ArbitraryFeedForward, arbFeedForward);*/
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    /**********************************
     * Set wheels velocity with PID's *
     **********************************/
    public void setWheelVelocity(int rpm, boolean wheel)
    {
        // 4096 ticks per revolution
        // 60 seconds -> 600ms for 100ms PID loop
        double calculatedVelocity = rpm * 4096 / 600;

        if (wheel)
            shooterWheelsTop.set(ControlMode.Velocity, calculatedVelocity);
        else
            shooterWheelsBottom.set(ControlMode.Velocity, calculatedVelocity);
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
    public double getWheelTopEncoderValue()
    {
        return shooterWheelsTop.getSelectedSensorPosition();
    }
    public double getWheelBottomEncoderValue()
    {
        return shooterWheelsBottom.getSelectedSensorPosition();
    }
    public double getWheelTopError()
    {
        return shooterWheelsTop.getClosedLoopError();
    }
    public double getWheelBottomError()
    {
        return shooterWheelsBottom.getClosedLoopError();
    }
    public double getWheelsTopMotorOutput()
    {
        return shooterWheelsTop.getMotorOutputPercent();
    }
    public double getWheelsBottomMotorOutput()
    {
        return shooterWheelsBottom.getMotorOutputPercent();
    }
    public void setWheelsTopPID()
    {
        shooterWheelsTopPIDParamF = SmartDashboard.getNumber("SHOOTER TOP F", Constants.SHOOTER_WHEELS_TOP_F);
        shooterWheelsTopPIDParamP = SmartDashboard.getNumber("SHOOTER TOP P", Constants.SHOOTER_WHEELS_TOP_P);
        shooterWheelsTopPIDParamI = SmartDashboard.getNumber("SHOOTER TOP I", Constants.SHOOTER_WHEELS_TOP_I);
        shooterWheelsTopPIDParamD = SmartDashboard.getNumber("SHOOTER TOP D", Constants.SHOOTER_WHEELS_TOP_D);

        shooterWheelsTop.config_kF(0, shooterWheelsTopPIDParamF, Constants.K_TIMEOUT_MS);
        shooterWheelsTop.config_kP(0, shooterWheelsTopPIDParamP, Constants.K_TIMEOUT_MS);
        shooterWheelsTop.config_kI(0, shooterWheelsTopPIDParamI, Constants.K_TIMEOUT_MS);
        shooterWheelsTop.config_kD(0, shooterWheelsTopPIDParamD, Constants.K_TIMEOUT_MS);
    }
    public void setWheelsBottomPID()
    {
        shooterWheelsBottomPIDParamF = SmartDashboard.getNumber("SHOOTER BOTTOM F", Constants.SHOOTER_WHEELS_BOTTOM_F);
        shooterWheelsBottomPIDParamP = SmartDashboard.getNumber("SHOOTER BOTTOM P", Constants.SHOOTER_WHEELS_BOTTOM_P);
        shooterWheelsBottomPIDParamI = SmartDashboard.getNumber("SHOOTER BOTTOM I", Constants.SHOOTER_WHEELS_BOTTOM_I);
        shooterWheelsBottomPIDParamD = SmartDashboard.getNumber("SHOOTER BOTTOM D", Constants.SHOOTER_WHEELS_BOTTOM_D);

        shooterWheelsBottom.config_kF(0, shooterWheelsBottomPIDParamF, Constants.K_TIMEOUT_MS);
        shooterWheelsBottom.config_kP(0, shooterWheelsBottomPIDParamP, Constants.K_TIMEOUT_MS);
        shooterWheelsBottom.config_kI(0, shooterWheelsBottomPIDParamI, Constants.K_TIMEOUT_MS);
        shooterWheelsBottom.config_kD(0, shooterWheelsBottomPIDParamD, Constants.K_TIMEOUT_MS);
    }
    /**************************************
     * Extend/Retract piston for shooting *
     **************************************/
    public void setPusher(boolean status)
    {
        shooterPusher.set(status);
        pusherStatus = status;
    }
    public void setShooterType(boolean type)
    {
        // true = spaceship, false = cargoship
        shooterAngleType = type;
    }
    public boolean getShooterType()
    {
        return shooterAngleType;
    }
    /****************************************************************
     * Accepts degrees as parameter and sets angle as encoder value *
     ****************************************************************/
    public void setAngleDegrees(double angle)
    {
        // prevents going over maximum and minimum angles
        if (angle > Constants.SHOOTER_ANGLE_MAXIMUM)
            angle = Constants.SHOOTER_ANGLE_MAXIMUM;
        else if (angle < Constants.SHOOTER_ANGLE_MINIMUM)
            angle = Constants.SHOOTER_ANGLE_MINIMUM;

        // calculate encoder value from given degrees angle
        // 4096 ticks/rev
        shooterAngleSetpoint = (int) (angle * 11.378);
        SmartDashboard.putNumber("Shooter Degrees Angle", angle);

        shooterAngleMaster.set(ControlMode.MotionMagic, shooterAngleSetpoint);
    }
    public void setAngleEncoder(int ticks)
    {
        shooterAngleMaster.set(ControlMode.MotionMagic, ticks);
        
        // Sets new setpoint for shooter angle; actually sets motor controller output in periodic method
        shooterAngleSetpoint = ticks;

    }
    public void setAngleMotorPercent(double motorPercent)
    {
        shooterAngleMaster.set(motorPercent);
    }
    /********************************************************************************
     * Returns current position angle of the shooter in radians from the  horizontal*
     *******************************************************************************/
    public double getAngleRadians() {
        return Constants.SHOOTER_ANGLE_STARTING_OFFSET_FROM_HORIZONTAL_RADS - (getAnglePositionEncoder() * 0.00153398078);
    }
    /***********************************
     * Returns error of PID controller *
     ***********************************/
    public double getAngleError()
    {
        return shooterAngleMaster.getClosedLoopError();
    }
    /****************************************************
     * Returns percent of maximum output of angle motor *
     ****************************************************/
    public double getAngleMotorPercent()
    {
        return shooterAngleMaster.getMotorOutputPercent();
    }
    /***************************************
     * Returns control mode of angle motor *
     ***************************************/
    public ControlMode getAngleMotorControlMode()
    {
        return shooterAngleMaster.getControlMode();
    }
    /****************************************************
     * Returns setpoint of angle motor as encoder value *
     ****************************************************/
    public int getAngleSetpoint()
    {
        return shooterAngleSetpoint;
    }
    /***********************************
     * Returns velocity of angle motor *
     ***********************************/
    public double getAngleVelocity()
    {
        return shooterAngleMaster.getSelectedSensorVelocity();
    }
    /*******************************************
     * Returns angle of motor as encoder value *
     *******************************************/
    public double getAnglePositionEncoder()
    {
        return shooterAngleMaster.getSelectedSensorPosition(0);
    }
    public double getAngleCurrent()
    {
        return shooterAngleMaster.getOutputCurrent();
    }
    /******************************
     * Resets angle encoder value *
     ******************************/
    public void resetAngleEncoders()
    {
        shooterAngleMaster.setSelectedSensorPosition(0, 0, Constants.K_TIMEOUT_MS);
    }
    /***********************************************************
     * Allows for editing of PID values for easier calibrating *
     ***********************************************************/
    public void setAnglePID()
    {
        shooterAnglePIDParamF = SmartDashboard.getNumber("SHOOTER ANGLE F", Constants.SHOOTER_ANGLE_F);
        shooterAnglePIDParamP = SmartDashboard.getNumber("SHOOTER ANGLE P", Constants.SHOOTER_ANGLE_P);
        shooterAnglePIDParamI = SmartDashboard.getNumber("SHOOTER ANGLE I", Constants.SHOOTER_ANGLE_I);
        shooterAnglePIDParamD = SmartDashboard.getNumber("SHOOTER ANGLE D", Constants.SHOOTER_ANGLE_D);
        shooterAngleCruiseVelocity = (int)SmartDashboard.getNumber("SHOOTER ANGLE CRUISE VELOCITY", Constants.SHOOTER_ANGLE_CRUISE_VELOCITY);
        shooterAngleAcceleration = (int)SmartDashboard.getNumber("SHOOTER ANGLE ACCELERATION", Constants.SHOOTER_ANGLE_ACCELERATION);

        shooterAngleMaster.config_kF(0, shooterAnglePIDParamF, Constants.K_TIMEOUT_MS);
        shooterAngleMaster.config_kP(0, shooterAnglePIDParamP, Constants.K_TIMEOUT_MS);
        shooterAngleMaster.config_kI(0, shooterAnglePIDParamI, Constants.K_TIMEOUT_MS);
        shooterAngleMaster.config_kD(0, shooterAnglePIDParamD, Constants.K_TIMEOUT_MS);

        shooterAngleMaster.configMotionCruiseVelocity(shooterAngleCruiseVelocity, Constants.K_TIMEOUT_MS);
        shooterAngleMaster.configMotionAcceleration(shooterAngleAcceleration, Constants.K_TIMEOUT_MS);
    }

    public boolean getPusherStatus()
    {
        return pusherStatus;
    }
}
