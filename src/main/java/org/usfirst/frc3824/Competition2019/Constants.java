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

    /*********
     * PID K *
     *********/
    public static final int K_SLOT_IDX                                   = 0;
    public static final int K_PID_LOOP_IDX                               = 0;
    public static final int K_TIMEOUT_MS                                 = 30;

    /*****************
     * SHOOTER ANGLE *
     *****************/
    public static final double SHOOTER_ANGLE_F                           = 0.8;
    public static final double SHOOTER_ANGLE_P                           = 10.0;
    public static final double SHOOTER_ANGLE_I                           = 0.002;
    public static final double SHOOTER_ANGLE_D                           = 0.0;

    public static final double SHOOTER_ANGLE_PEAK_OUTPUT                 = 1.0;

    public static final int SHOOTER_ANGLE_ACCELERATION                   = 100;
    public static final int SHOOTER_ANGLE_CRUISE_VELOCITY                = 100;

    public static final int SHOOTER_ANGLE_MINIMUM                        = -180;
    public static final int SHOOTER_ANGLE_MAXIMUM                        = 180;

    public static final double SHOOTER_ANGLE_ENCODER_YINTERCEPT          = 0.0;

    /**********************
     * SHOOTER WHEELS TOP *
     **********************/
    public static final double SHOOTER_WHEELS_TOP_F                      = 0.0;
    public static final double SHOOTER_WHEELS_TOP_P                      = 0.1;
    public static final double SHOOTER_WHEELS_TOP_I                      = 0.001;
    public static final double SHOOTER_WHEELS_TOP_D                      = 0.0;

    /*************************
     * SHOOTER WHEELS BOTTOM *
     *************************/
    public static final double SHOOTER_WHEELS_BOTTOM_F                   = 0.0;
    public static final double SHOOTER_WHEELS_BOTTOM_P                   = 0.1;
    public static final double SHOOTER_WHEELS_BOTTOM_I                   = 0.001;
    public static final double SHOOTER_WHEELS_BOTTOM_D                   = 0.0;

    /*********************
     * SHOOTER POSITIONS *
     *********************/
    public static final int SHOOTER_SPACESHIP_TOP_ANGLE_POSITION         = 200;
    public static final int SHOOTER_SPACESHIP_MIDDLE_ANGLE_POSITION      = 100;
    public static final int SHOOTER_SPACESHIP_BOTTOM_ANGLE_POSITION      = 1265;

    /**********************
     * SHOOTER SHOOT RPMS *
     **********************/
    public static final int SHOOTER_TOPWHEEL_SPACESHIP_TOP_RPM           = -1500;
    public static final int SHOOTER_BOTTOMWHEEL_SPACESHIP_TOP_RPM        = -1500;
    public static final int SHOOTER_TOPWHEEL_SPACESHIP_BOTTOM_RPM        = -1500;
    public static final int SHOOTER_BOTTOMWHEEL_SPACESHIP_BOTTOM_RPM     = -1500;
    public static final int SHOOTER_TOPWHEEL_SPACESHIP_MIDDLE_RPM        = -1500;
    public static final int SHOOTER_BOTTOMWHEEL_SPACESHIP_MIDDLE_RPM     = -1500;

    public static final int SHOOTER_TOPWHEEL_CARGOSHIP_RPM               = -1500;
    public static final int SHOOTER_BOTTOMWHEEL_CARGOSHIP_RPM            = -1500;

    /*****************
     * Climber Front *
     *****************/
    public static final double CLIMBER_FRONT_F                           = 0.0;
    public static final double CLIMBER_FRONT_P                           = 5.0;
    public static final double CLIMBER_FRONT_I                           = 0.01;
    public static final double CLIMBER_FRONT_D                           = 0.0;

    public static final double CLIMBER_FRONT_PEAK_OUTPUT                 = 1.0;

    public static final int CLIMBER_FRONT_ACCELERATION                   = 1000;
    public static final int CLIMBER_FRONT_CRUISE_VELOCITY                = 50;

    /****************
     * Climber Back *
     ****************/
    public static final double CLIMBER_BACK_F                           = 0.0;
    public static final double CLIMBER_BACK_P                           = 5.0;
    public static final double CLIMBER_BACK_I                           = 0.01;
    public static final double CLIMBER_BACK_D                           = 0.0;

    public static final double CLIMBER_BACK_PEAK_OUTPUT                 = 1.0;

    public static final int CLIMBER_BACK_ACCELERATION                   = 1000;
    public static final int CLIMBER_BACK_CRUISE_VELOCITY                = 50;

    /*********************
     * All Systems Climb *
     *********************/
    public static final int ALL_SHOOTER_CLIMB_START_POSITION            = 3000;
    public static final double ALL_CHASSIS_INITIAL_POWER                = 0.25; 
    public static final int ALL_FRONT_CLIMBER_EXTEND_POSITION           = 6000;
    public static final int ALL_BACK_CLIMBER_EXTEND_POSITION            = 6000;
    public static final int ALL_SHOOTER_PULL_IN_POSITION                = 4500;
    public static final int ALL_SHOOTER_PULL_IN_RPM                     = 50;
    public static final double ALL_CHASSIS_PLATFORM_POWER               = 0.25;
    public static final int ALL_FRONT_CLIMBER_RETRACT_POSITION          = 50;
    public static final int ALL_BACK_CLIMBER_RETRACT_POSITION           = 50;
    public static final int ALL_SHOOTER_HOME_POSITION                   = 0;
}