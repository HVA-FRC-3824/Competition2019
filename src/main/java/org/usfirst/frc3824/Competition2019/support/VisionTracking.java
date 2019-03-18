/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc3824.Competition2019.support;

import org.usfirst.frc3824.Competition2019.Constants;
import org.usfirst.frc3824.Competition2019.Robot;

import jaci.pathfinder.Trajectory;

public class VisionTracking {

    // Create path based on current position relative to target; calculate trajectory
    public static void createPath() {
        double currentHeading = Robot.chassis.getGyroAngle();
        double yawFromTarget = currentHeading - Limelight.getInstance().getTargetOffset_x();
        double distanceFromTarget = getDistanceFromVisionTarget();
        double posFromTargetX = distanceFromTarget * Math.sin(Math.toRadians(yawFromTarget));//TODO: Change yaw to actual triangle angle from target
        double posFromTargetY = distanceFromTarget * Math.cos(Math.toRadians(yawFromTarget));
        double finalHeading = currentHeading - yawFromTarget;

        PathGenerator.addWaypoint(0, 0, Robot.chassis.getGyroAngle());
        PathGenerator.addWaypoint(-(posFromTargetX + posFromTargetY) / 2, -Constants.VISION_DISTANCE_FROM_TAR_MID_WAYPOINT, (currentHeading + finalHeading) / 2);
        // PathGenerator.addWaypoint(-posFromTargetX, , finalHeading);

        PathGenerator.calcTrajectory();
    }

    // Use camera's physical placement to calculate the distance of the robot from the target
    public static double getDistanceFromVisionTarget() {
        double mountAngleRads = Math.toRadians(Constants.VISION_CAM_MOUNT_ANGLE);
        double targetOffsetYRads = Math.toRadians(Limelight.getInstance().getTargetOffset_y());

        return (Constants.VISION_TARGETS_FROM_GROUND_FIELD_HEIGHT - Constants.VISION_CAM_MOUNT_HEIGHT) / Math.tan(mountAngleRads + targetOffsetYRads);
    }

    public static Trajectory getLeftTraj() {
        return PathGenerator.getLeftTraj();
    }

    public static Trajectory getRightTraj() {
        return PathGenerator.getRightTraj();
    }
}
