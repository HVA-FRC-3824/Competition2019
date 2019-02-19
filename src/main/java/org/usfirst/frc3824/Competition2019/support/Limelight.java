/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc3824.Competition2019.support;
import com.sun.jdi.IntegerValue;

import edu.wpi.first.networktables.*;

/**
 * Add your docs here.
 */
public class Limelight {
    private static Limelight instance = null;
    private static NetworkTable table;
    private static NetworkTableEntry tx;
    private static NetworkTableEntry ty;
    private static NetworkTableEntry tv;
    private static NetworkTableEntry ta;
    private static NetworkTableEntry camMode;
    private static NetworkTableEntry ledMode;
    private static NetworkTableEntry pipeline;
    private static NetworkTableEntry stream;
    private static CamMode lastCamMode;

    public enum CamMode {
        VISION(0),
        DRIVER(1);

        private int modeValue;
        private CamMode(int modeVal){
            this.modeValue = modeVal;
        }
    } 

    public enum LedMode {
        PIPELINE(0),
        OFF(1),
        BLINK(2),
        ON(3);

        private int modeValue;
        private LedMode(int modeVal){
            this.modeValue = modeVal;
        }
    }

    public enum StreamMode {
        STANDARD(0),
        PIP_MAIN(1),
        PIP_SECONDARY(2);

        private int modeValue;
        private StreamMode(int modeVal){
            this.modeValue = modeVal;
        }
    }

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
        ledMode = table.getEntry("ledMode");  // 0: pipeline, 1: off, 2: blink, 3: on
        camMode = table.getEntry("camMode");  // 0: vision processing, 1: driver camera
        pipeline = table.getEntry("pipeline");    // 0-9
        stream = table.getEntry("stream"); // 0:standard, 1:pip Main, 2:pip secondary
    }

    public double getTargetOffset_x(){
        return (double) tx.getDouble(0);
    }

    public double getTargetOffset_y(){
        return (double) ty.getDouble(0);
    }

    public boolean isTargetAvailable(){
        return tv.getNumber(0).intValue() == 1 ? true : false;
    }

    public double getTargetArea(){
        return (double) ta.getDouble(0);
    }

    public void setCamModeVision(){
        lastCamMode = getCamMode();
        setCamMode(CamMode.VISION);
    }

    public void setCamModeDriver(){
        lastCamMode = getCamMode();
        setCamMode(CamMode.DRIVER);
    }

    public void restoreLastCamMode(){
        setCamMode(lastCamMode);
    }

    public int getCurrentPipeline(){
        return pipeline.getNumber(0).intValue();
    }

    private CamMode getCamMode(){
        return camMode.getNumber(0).intValue() == 1 ? CamMode.DRIVER : CamMode.VISION;
    }

    private void setCamMode(CamMode mode){
        camMode.setNumber(mode.modeValue);
    }

    public void setLedMode(LedMode mode){
        ledMode.setNumber(mode.modeValue);
    }

    public void setStreamMode(StreamMode mode){
        streamMode.setNumber(mode.modeValue);
    }
}
