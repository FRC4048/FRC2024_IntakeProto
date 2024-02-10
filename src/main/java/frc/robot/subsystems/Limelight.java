// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.nio.file.FileSystems;

import edu.wpi.first.apriltag.AprilTagFieldLayout;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {
  /** Creates a new Limelight. */
  NetworkTable table;
  NetworkTableEntry tv;
  NetworkTableEntry tx;
  NetworkTableEntry ty;
  NetworkTableEntry ta;
  NetworkTableEntry thor;
  NetworkTableEntry tvert;
  NetworkTableEntry tid;
  NetworkTableEntry tshort;
  NetworkTableEntry tlong;
  double cameraHeight = 21; //inches
  double targetHeight = 50; //height to the bottom of the target in inches
  double cameraAngle = 24; //mounting angle
  double robotAngle = 0;

  
  public Limelight() {
    table = NetworkTableInstance.getDefault().getTable("limelight");
    tv = table.getEntry("tv");
    tx = table.getEntry("tx");
    ty = table.getEntry("ty");
    ta = table.getEntry("ta");
    tid = table.getEntry("tid");
  }
  @Override
  public void periodic() {
    double forwardDistance = (targetHeight - cameraHeight) / Math.tan(Math.toRadians(cameraAngle + ty.getDouble(0.0)));
    double sidewaysDistance = forwardDistance * Math.tan(Math.toRadians(robotAngle + ty.getDouble(0.0))); //Middle of the camera to the middle of the tag
    SmartDashboard.putNumber("tv", tv.getDouble(0.0));
    SmartDashboard.putNumber("tx", tx.getDouble(0.0));
    SmartDashboard.putNumber("ty", ty.getDouble(0.0));
    SmartDashboard.putNumber("ta",  ta.getDouble(0.0));
    SmartDashboard.putNumber("tid", tid.getDouble(0.0));
    SmartDashboard.putNumber("tforwardDistance", forwardDistance);
    SmartDashboard.putNumber("tsidewaysDistance", sidewaysDistance);
  }
}
