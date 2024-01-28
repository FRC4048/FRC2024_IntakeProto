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
  double cameraHeight = 25; //inches
  double targetHeight = 50; //height to the bottom of the target in inches
  double cameraAngle = 15; //mounting angle

  
  public Limelight() {
    table = NetworkTableInstance.getDefault().getTable("limelight");
    tv = table.getEntry("tv");
    tx = table.getEntry("tx");
    ty = table.getEntry("ty");
    ta = table.getEntry("ta");
    thor = table.getEntry("thor");
    tvert = table.getEntry("tvert");
  }
  @Override
  public void periodic() {
    double forwardDistance = (targetHeight - cameraHeight) / Math.tan(Math.toRadians(cameraAngle + ty.getNumber(0.0).doubleValue()));
    double sidewaysDistance = forwardDistance * Math.tan(Math.toRadians(tx.getNumber(0.0).doubleValue())); //Middle of the camera to the middle of the tag
    SmartDashboard.putNumber("tv", tv.getNumber(0).doubleValue());
    SmartDashboard.putNumber("tx", tx.getNumber(0.0).doubleValue());
    SmartDashboard.putNumber("ty", ty.getNumber(0.0).doubleValue());
    SmartDashboard.putNumber("ta",  ta.getNumber(0.0).doubleValue());
    SmartDashboard.putNumber("thor", thor.getNumber(0.0).doubleValue());
    SmartDashboard.putNumber("tvert", tvert.getNumber(0.0).doubleValue());
    SmartDashboard.putNumber("tforwardDistance", forwardDistance);
    SmartDashboard.putNumber("tsidewaysDistance", sidewaysDistance);
  }
}
