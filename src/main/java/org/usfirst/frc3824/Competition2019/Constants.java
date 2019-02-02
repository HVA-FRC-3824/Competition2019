package org.usfirst.frc3824.Competition2019;

public class Constants
{
    public static final double CHASSIS_TURN_THRESHOLD                   = 5.0;
    public static final double CHASSIS_TURN_TIMEOUT_TIME_DEFAULT        = 3.0;
    public static final double CHASSIS_TURN_TIMEOUT_TIME                = 1.0;

    public static final double TURNANGLE_MINIMUM_OUTPUT                 = -0.4;
    public static final double TURNANGLE_MAXIMUM_OUTPUT                 = 0.4;

    public static final double TURNANGLE_F                              = 0;
    public static final double TURNANGLE_P                              = 0.06;
    public static final double TURNANGLE_I                              = 0;
    public static final double TURNANGLE_D                              = 0.15;

    public static final double DRIVETRAIN_DRIVE_MINIMUM_OUTPUT          = -1.0;
    public static final double DRIVETRAIN_DRIVE_MAXIMUM_OUTPUT          = 1.0;

    public static final double DRIVETRAIN_DRIVE_STRAIGHT_F              = 0.0;
    public static final double DRIVETRAIN_DRIVE_STRAIGHT_P              = 0.05;
    public static final double DRIVETRAIN_DRIVE_STRAIGHT_I              = 0.00005;
    public static final double DRIVETRAIN_DRIVE_STRAIGHT_D              = 0.0;

    public static final double ULTRASONIC_SLOPE = 9.41;
    public static final double ULTRASONIC_OFFSET = 0.00533;

    /**
     * SHOOTER
     */
    public static final int K_SLOT_IDX                                   = 0;
    public static final int K_PID_LOOP_IDX                               = 0;
    public static final int K_TIMEOUT_MS                                 = 30;

    public static final double SHOOTER_ANGLE_F                           = 0.0;
    public static final double SHOOTER_ANGLE_P                           = 0.0;
    public static final double SHOOTER_ANGLE_I                           = 0.0;
    public static final double SHOOTER_ANGLE_D                           = 0.0;

    public static final double SHOOTER_ANGLE_PEAK_OUTPUT                 = 1.0;

    public static final int SHOOTER_ANGLE_ACCELERATION                   = 6000;
    public static final int SHOOTER_ANGLE_CRUISE_VELOCITY                = 15000;

    public static final int SHOOTER_ANGLE_MINIMUM                        = 180;
    public static final int SHOOTER_ANGLE_MAXIMUM                        = 0;

    public static final double SHOOTER_ANGLE_ENCODER_YINTERCEPT          = 0.0;
}