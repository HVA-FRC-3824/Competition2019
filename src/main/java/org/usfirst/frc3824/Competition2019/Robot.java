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

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc3824.Competition2019.commands.*;
import org.usfirst.frc3824.Competition2019.subsystems.*;
import org.usfirst.frc3824.Competition2019.support.Limelight;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends TimedRobot {

    Command autonomousCommand;
    SendableChooser<Command> chooser = new SendableChooser<>();

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Chassis chassis;
    public static Climber climber;
    public static Shooter shooter;
    public static HatchPanel hatchPanel;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static Constants constants;

    private static boolean killClimber = false;
    private static int nextGamepiece = 0;
    private static boolean readyToPlace = false;
    private static PowerDistributionPanel pdp;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        chassis = new Chassis();
        climber = new Climber();
        shooter = new Shooter();
        hatchPanel = new HatchPanel();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();
        constants = new Constants();
        pdp = new PowerDistributionPanel();

        // Add commands to Autonomous Sendable Chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        
        // begin capturing of USB cameras
        CameraServer.getInstance().startAutomaticCapture(0);
        CameraServer.getInstance().startAutomaticCapture(1);

        // set kill climber to false
        killClimber = false;

        // Create SmartDashboard F,P,I,D,Velocity,Acceleration for calibrating Shooter Angle PID's
        // SmartDashboard.putNumber("SHOOTER ANGLE F", 0.0);
        // SmartDashboard.putNumber("SHOOTER ANGLE P", 0.0);
        // SmartDashboard.putNumber("SHOOTER ANGLE I", 0.0);
        // SmartDashboard.putNumber("SHOOTER ANGLE D", 0.0);
        // SmartDashboard.putNumber("SHOOTER ANGLE CRUISE VELOCITY", 0);
        // SmartDashboard.putNumber("SHOOTER ANGLE ACCELERATION", 0);

        // SmartDashboard.putNumber("SHOOTER TOP F", 0.0);
        // SmartDashboard.putNumber("SHOOTER TOP P", 0.0);
        // SmartDashboard.putNumber("SHOOTER TOP I", 0.0);
        // SmartDashboard.putNumber("SHOOTER TOP D", 0.0);

        // SmartDashboard.putNumber("SHOOTER BOTTOM F", 0.0);
        // SmartDashboard.putNumber("SHOOTER BOTTOM P", 0.0);
        // SmartDashboard.putNumber("SHOOTER BOTTOM I", 0.0);
        // SmartDashboard.putNumber("SHOOTER BOTTOM D", 0.0);

        // SmartDashboard.putNumber("CLIMBER FRONT F", 0.0);
        // SmartDashboard.putNumber("CLIMBER FRONT P", 0.0);
        // SmartDashboard.putNumber("CLIMBER FRONT I", 0.0);
        // SmartDashboard.putNumber("CLIMBER FRONT D", 0.0);
        // SmartDashboard.putNumber("CLIMBER FRONT CRUISE VELOCITY", 0);
        // SmartDashboard.putNumber("CLIMBER FRONT ACCELERATION", 0);

        // SmartDashboard.putNumber("CLIMBER BACK F", 0.0);
        // SmartDashboard.putNumber("CLIMBER BACK P", 0.0);
        // SmartDashboard.putNumber("CLIMBER BACK I", 0.0);
        // SmartDashboard.putNumber("CLIMBER BACK D", 0.0);
        // SmartDashboard.putNumber("CLIMBER BACK CRUISE VELOCITY", 0);
        // SmartDashboard.putNumber("CLIMBER BACK ACCELERATION", 0);

        // SmartDashboard.putNumber("HATCH PICKUP ANGLE F", 0.0);
        // SmartDashboard.putNumber("HATCH PICKUP ANGLE P", 0.0);
        // SmartDashboard.putNumber("HATCH PICKUP ANGLE I", 0.0);
        // SmartDashboard.putNumber("HATCH PICKUP ANGLE D", 0.0);
        // SmartDashboard.putNumber("HATCH PICKUP ANGLE CRUISE VELOCITY", 0);
        // SmartDashboard.putNumber("HATCH PICKUP ANGLE ACCELERATION", 0);
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit(){

    } 

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();

        displaySmartDashboardInfo();

        chassis.turnOnDirectionLights();
    }

    @Override
    public void autonomousInit() {
        autonomousCommand = chooser.getSelected();
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
        // cancel autonomous command in order to jump to driveWithJoystick command for sandstorm
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();

        displaySmartDashboardInfo();
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();

        // set direction lights to drive direction
        Robot.chassis.setDirectionLights();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();

        displaySmartDashboardInfo();
    }
    /*********************************************************************
     * Displays robot information on SmartDashboard
     *********************************************************************/
    public void displaySmartDashboardInfo()
    {
        SmartDashboard.putData("Auto mode", chooser);

        // SmartDashboard.putNumber("Ultrasonic: ", chassis.getUltrasonicDistance());
        SmartDashboard.putNumber("Gyro Angle: ", chassis.getGyroAngle());

        // Drive Direction
        // True = Green = Front of Robot
        // False = Red = Back of Robot
        SmartDashboard.putBoolean("Drive Direction", chassis.getDriveDirection());
        SmartDashboard.putNumber("Drive Left Output", chassis.getLeftOutput());
        SmartDashboard.putNumber("Drive Right Output", chassis.getRightOutput());
        SmartDashboard.putNumber("Drive Current Right", pdp.getCurrent(14));
        SmartDashboard.putNumber("Drive Current Left", pdp.getCurrent(15));

        // Vision Data
        SmartDashboard.putNumber("tx", Limelight.getInstance().getTargetOffset_x());
        SmartDashboard.putNumber("Gamepiece in Possession", nextGamepiece);
        SmartDashboard.putBoolean("Ready To Place", readyToPlace);
        
        // Shooter Data

        SmartDashboard.putBoolean("Shooter Pusher", shooter.getPusherStatus());

        // SmartDashboard.putNumber("Wheel Top Velocity", shooter.getWheelTopVelocity());
        // SmartDashboard.putNumber("Wheel Top Motor Percent Output", shooter.getWheelsTopMotorOutput());
        // SmartDashboard.putNumber("Wheel Top Error", shooter.getWheelTopError());
        
        // SmartDashboard.putNumber("Wheel Bottom Velocity", shooter.getWheelBottomVelocity());
        // SmartDashboard.putNumber("Wheel Bottom Motor Percent Output", shooter.getWheelsBottomMotorOutput());
        // SmartDashboard.putNumber("Wheel Bottom Error", shooter.getWheelBottomError());

        // SmartDashboard.putNumber("Shooter Angle Error", shooter.getAngleError());
        // SmartDashboard.putNumber("Shooter Angle MotorPercent", shooter.getAngleMotorPercent());
        // SmartDashboard.putNumber("Shooter Angle Setpoint", shooter.getAngleSetpoint());
        // SmartDashboard.putNumber("Shooter Angle Position", shooter.getAnglePositionEncoder());
        // SmartDashboard.putNumber("Shooter Angle Velocity", shooter.getAngleVelocity());
        // SmartDashboard.putNumber("Shooter Angle Current", shooter.getAngleCurrent());

        // // Climber Data
        // SmartDashboard.putNumber("Climber Front Setpoint", climber.getFrontSetpoint());
        // SmartDashboard.putNumber("Climber Front Velocity", climber.getFrontVelocity());
        // SmartDashboard.putNumber("Climber Front Position", climber.getFrontPosition());
        // SmartDashboard.putNumber("Climber Front Error", climber.getFrontError());
        // SmartDashboard.putNumber("Climber Front Motor Output", climber.getFrontMotorOutput());

        // SmartDashboard.putNumber("Climber Back Setpoint", climber.getBackSetpoint());
        // SmartDashboard.putNumber("Climber Back Velocity", climber.getBackVelocity());
        // SmartDashboard.putNumber("Climber Back Position", climber.getBackPosition());
        // SmartDashboard.putNumber("Climber Back Error", climber.getBackError());
        // SmartDashboard.putNumber("Climber Back Motor Output", climber.getBackMotorOutput());

        // Hatch Panel Data
        SmartDashboard.putBoolean("Latch", hatchPanel.getLatchStatus());
    }
    public static void setKillClimber(boolean status)
    {
        killClimber = status;
    }
    public static boolean getKillClimber()
    {
        return killClimber;
    }
    
    // Sets next gamepiece to be placed using vision-based auto driving
    // 1 = Hatch; 2 = Cargo; 0 = Neither
    public static void setNextGamepiece(int piece)
    {
        nextGamepiece = piece;
    }
    public static int getNextGamepiece()
    {
        return nextGamepiece;
    }
    
    public static void setReadyToPlace(boolean ready)
    {
        readyToPlace = ready;
    }
    public static boolean getReadyToPlace()
    {
        return readyToPlace;
    }
}
