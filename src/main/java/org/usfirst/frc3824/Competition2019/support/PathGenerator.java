/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc3824.Competition2019.support;

import java.util.ArrayList;

import org.usfirst.frc3824.Competition2019.Constants;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.modifiers.TankModifier;

public class PathGenerator {

    private ArrayList<Waypoint> pointList;

    private Trajectory leftTraj;
    private Trajectory rightTraj;

    // Add waypoint to be used in path generation; params: (x, y, exitAngleRadians)
    public void addWaypoint(double x, double y, double angleDegrees) {
        pointList.add(new Waypoint(x, y, Pathfinder.d2r(angleDegrees)));
    }

    // Remove all waypoints from waypoint list
    public void clearWaypoints() {
        pointList.clear();
    }
    
    // Generate trajectory from path; params: (fitMethod, sampleRate, deltaTime, maxVelocity, maxAcceleration, maxJerk)
    public void calcTrajectory() {
        Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, Constants.PATH_DT, Constants.PATH_MAX_VELOCITY, Constants.PATH_MAX_ACC, Constants.PATH_MAX_JERK);
        Waypoint[] points = pointList.toArray(new Waypoint[pointList.size()]);

        // Generate trajectory
        Trajectory trajectory = Pathfinder.generate(points, config);

        // Change trajectory to produce trajectory for left and right side of the west coast drive drivebase
        TankModifier tankMod = new TankModifier(trajectory).modify(Constants.PATH_WHEELBASE);
        leftTraj = tankMod.getLeftTrajectory();
        rightTraj = tankMod.getRightTrajectory();
    }

    // Gets calculated trajectory for left side of the drivetrain
    public Trajectory getLeftTraj() {
        return leftTraj;
    }

    // Gets calculated trajectory for right side of the drivetrain
    public Trajectory getRightTraj() {
        return rightTraj;
    }
}
