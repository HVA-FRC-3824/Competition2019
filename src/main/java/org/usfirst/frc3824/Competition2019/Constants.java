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
     * CAMERA
     */
    public static final double CAMERA_P = 0.0;
    public static final double CAMERA_I = 0.0;
    public static final double CAMERA_D = 0.0;

    public static final int DRIVE_TO_TARGET_BUTTON = 10;

    /*********
     * PID K *
     *********/
    public static final int K_SLOT_IDX                                   = 0;
    public static final int K_PID_LOOP_IDX                               = 0;
    public static final int K_TIMEOUT_MS                                 = 30;

    /*****************
     * SHOOTER ANGLE *
     *****************/
    public static final double SHOOTER_ANGLE_F                           = 0.08;
    public static final double SHOOTER_ANGLE_P                           = 1.0;
    public static final double SHOOTER_ANGLE_I                           = 0.0002;
    public static final double SHOOTER_ANGLE_D                           = 0.0;

    public static final int SHOOTER_ANGLE_ACCELERATION                   = 1000;
    public static final int SHOOTER_ANGLE_CRUISE_VELOCITY                = 1000;

    public static final int SHOOTER_ANGLE_MINIMUM                        = -180;
    public static final int SHOOTER_ANGLE_MAXIMUM                        = 180;

    public static final double SHOOTER_ANGLE_ENCODER_YINTERCEPT          = 0.0;

    /**********************
     * SHOOTER WHEELS TOP *
     **********************/
    public static final double SHOOTER_WHEELS_TOP_F                      = 0.0;
    public static final double SHOOTER_WHEELS_TOP_P                      = 0.2;//0.1
    public static final double SHOOTER_WHEELS_TOP_I                      = 0.0;//0.001;
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
    public static final int SHOOTER_SPACESHIP_FRONT_TOP_ANGLE_POSITION        = 6750;
    public static final int SHOOTER_SPACESHIP_FRONT_MIDDLE_ANGLE_POSITION     = 7800;
    public static final int SHOOTER_SPACESHIP_BACK_TOP_ANGLE_POSITION         = 2000;
    public static final int SHOOTER_SPACESHIP_BACK_MIDDLE_ANGLE_POSITION      = 1000;
    public static final int SHOOTER_SPACESHIP_BOTTOM_ANGLE_POSITION           = 11420;

    public static final int SHOOTER_CARGOSHIP_FRONT_ANGLE_POSITION            = 6050;
    public static final int SHOOTER_CARGOSHIP_BACK_ANGLE_POSITION             = 3000;

    /**********************
     * SHOOTER SHOOT RPMS *
     **********************/
    public static final int SHOOTER_TOPWHEEL_SPACESHIP_FRONT_TOP_RPM            = -3000;
    public static final int SHOOTER_BOTTOMWHEEL_SPACESHIP_FRONT_TOP_RPM         = -3000;
    public static final int SHOOTER_TOPWHEEL_SPACESHIP_BACK_TOP_RPM             = -3000;
    public static final int SHOOTER_BOTTOMWHEEL_SPACESHIP_BACK_TOP_RPM          = -3000;
    public static final int SHOOTER_TOPWHEEL_SPACESHIP_FRONT_MIDDLE_RPM         = -1000;
    public static final int SHOOTER_BOTTOMWHEEL_SPACESHIP_FRONT_MIDDLE_RPM      = -1000;
    public static final int SHOOTER_TOPWHEEL_SPACESHIP_BACK_MIDDLE_RPM          = -1000;
    public static final int SHOOTER_BOTTOMWHEEL_SPACESHIP_BACK_MIDDLE_RPM       = -1000;
    public static final int SHOOTER_TOPWHEEL_SPACESHIP_BOTTOM_RPM               = -200;
    public static final int SHOOTER_BOTTOMWHEEL_SPACESHIP_BOTTOM_RPM            = -200;

    public static final int SHOOTER_TOPWHEEL_CARGOSHIP_FRONT_RPM                = -275;
    public static final int SHOOTER_BOTTOMWHEEL_CARGOSHIP_FRONT_RPM             = -275;
    public static final int SHOOTER_TOPWHEEL_CARGOSHIP_BACK_RPM                 = -275;
    public static final int SHOOTER_BOTTOMWHEEL_CARGOSHIP_BACK_RPM              = -275;

    /*****************
     * Climber Front *
     *****************/
    public static final double CLIMBER_FRONT_F                           = 0.0;
    public static final double CLIMBER_FRONT_P                           = 5.0;
    public static final double CLIMBER_FRONT_I                           = 0.01;
    public static final double CLIMBER_FRONT_D                           = 0.0;

    public static final int CLIMBER_FRONT_ACCELERATION                   = 1000;
    public static final int CLIMBER_FRONT_CRUISE_VELOCITY                = 200;

    /****************
     * Climber Back *
     ****************/
    public static final double CLIMBER_BACK_F                           = 0.0;
    public static final double CLIMBER_BACK_P                           = 5.0;
    public static final double CLIMBER_BACK_I                           = 0.01;
    public static final double CLIMBER_BACK_D                           = 0.0;

    public static final int CLIMBER_BACK_ACCELERATION                   = 1000;
    public static final int CLIMBER_BACK_CRUISE_VELOCITY                = 200;

    /****************************
     * All Systems Climb Center *
     ****************************/
    public static final int ALL_CENTER_SHOOTER_CLIMB_START_POSITION            = 4500;
    public static final double ALL_CENTER_CHASSIS_INITIAL_POWER                = 0.25; 
    public static final int ALL_CENTER_CHASSIS_INITIAL_TIME                    = 1;
    public static final int ALL_CENTER_FRONT_CLIMBER_EXTEND_POSITION           = 16750;
    public static final int ALL_CENTER_BACK_CLIMBER_EXTEND_POSITION            = 16750;
    public static final int ALL_CENTER_SHOOTER_PULL_IN_POSITION                = 13000;
    public static final int ALL_CENTER_SHOOTER_PULL_IN_RPM                     = -2000;
    public static final double ALL_CENTER_CHASSIS_PLATFORM_POWER               = 0.25;
    public static final int ALL_CENTER_BACK_CLIMBER_RETRACT_POSITION           = 50;
    public static final int ALL_CENTER_FRONT_CLIMBER_RETRACT_POSITION          = 50;
    public static final int ALL_CENTER_SHOOTER_HOME_POSITION                   = 0;

    public static final int ALL_CENTER_CHASSIS_PLATFORM_TIME                   = 2;
    public static final double ALL_CENTER_CHASSIS_TIMEOUT                      = 3.0;

    /**************************
     * All Systems Climb Side *
     **************************/
    public static final int ALL_SIDE_SHOOTER_CLIMB_START_POSITION            = 4500;
    public static final double ALL_SIDE_CHASSIS_INITIAL_POWER                = 0.25; 
    public static final int ALL_SIDE_CHASSIS_INITIAL_TIME                    = 1;
    public static final int ALL_SIDE_FRONT_CLIMBER_EXTEND_POSITION           = 5000;
    public static final int ALL_SIDE_BACK_CLIMBER_EXTEND_POSITION            = 5000;
    public static final int ALL_SIDE_SHOOTER_PULL_IN_POSITION                = 13000;
    public static final int ALL_SIDE_SHOOTER_PULL_IN_RPM                     = -2000;
    public static final double ALL_SIDE_CHASSIS_PLATFORM_POWER               = 0.25;
    public static final int ALL_SIDE_BACK_CLIMBER_RETRACT_POSITION           = 50;
    public static final int ALL_SIDE_FRONT_CLIMBER_RETRACT_POSITION          = 50;
    public static final int ALL_SIDE_SHOOTER_HOME_POSITION                   = 0;

    public static final int ALL_SIDE_CHASSIS_PLATFORM_TIME                   = 2;
    public static final double ALL_SIDE_CHASSIS_TIMEOUT                      = 3.0;

    /***************************
     * HATCHPANEL PICKUP ANGLE *
     ***************************/
    public static final double HATCH_PICKUP_ANGLE_F                          = 0.0;
    public static final double HATCH_PICKUP_ANGLE_P                          = 0.0;
    public static final double HATCH_PICKUP_ANGLE_I                          = 0.0;
    public static final double HATCH_PICKUP_ANGLE_D                          = 0.0;

    public static final int HATCH_PICKUP_ANGLE_CRUISE_VELOCITY               = 0;
    public static final int HATCH_PICKUP_ANGLE_ACCELERATION                  = 0;
}