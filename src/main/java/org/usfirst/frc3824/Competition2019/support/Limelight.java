/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc3824.Competition2019.support;
import edu.wpi.first.networktables.*;

/**
 * Add your docs here.
 */
public class Limelight {
    private static Limelight instance = null;
    private NetworkTable table;
    private NetworkTableEntry tx;
    private NetworkTableEntry ty;
    private NetworkTableEntry tv;
    private NetworkTableEntry ta;
    private NetworkTableEntry camMode;
    private NetworkTableEntry pipeline;

    public static Limelight getInstance(){
        if (instance == null)
            instance = new Limelight();

        return instance;
    }

    private Limelight(){
        table = NetworkTableInstance.getDefault().getTable("limelight");
        tx = table.getEntry("tx"); // Horizontal offset from crosshair to target (-27 to 27)
        ty = table.getEntry("ty"); // Vertical offset from crosshair to target (-20.5 to 20.5)
        tv = table.getEntry("tv"); // whether there are any valid targets (0 or 1)
        ta = table.getEntry("ta"); // target area (0% - 100% of image)
        camMode = table.getEntry("camMode");  // 0: vision processing, 1: driver camera
        pipeline = table.getEntry("pipeline");    // 0-9
    }

    public double getTx(){
        return (float) tx.getDouble(0);
    }
}
