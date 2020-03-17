package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  public SwerveModule frontRight = new SwerveModule(Constants.frontRightDriveMotorID, Constants.frontRightAngleMotorID, Constants.frontRightEncoderID);
  public SwerveModule rearRight = new SwerveModule(Constants.rearRightDriveMotorID, Constants.rearRightAngleMotorID, Constants.rearRightEncoderID);
  public SwerveModule frontLeft = new SwerveModule(Constants.frontLeftDriveMotorID, Constants.frontLeftAngleMotorID, Constants.frontLeftEncoderID);
  public SwerveModule rearLeft = new SwerveModule(Constants.rearLeftDriveMotorID, Constants.rearLeftAngleMotorID, Constants.rearLeftEncoderID);
  double frontRightAngle;
  double rearRightAngle;
  double frontLeftAngle;
  double rearLeftAngle;

  public DriveTrain() {

  }

  public void drive(double driveSpeed){
    frontRight.setDriveSpeed(driveSpeed);
    rearRight.setDriveSpeed(driveSpeed);
    frontLeft.setDriveSpeed(driveSpeed);
    rearLeft.setDriveSpeed(driveSpeed);
  }

  public double getFrontRightAngle(){
    frontRightAngle = frontRight.getAngle();
    return frontRightAngle;
  }

  public double getRearRightAngle(){
    rearRightAngle = rearRight.getAngle();
    return rearRightAngle;
  }

  public double getFrontLeftAngle(){
    frontLeftAngle = frontLeft.getAngle();
    return frontLeftAngle;
  }

  public double getRearLeftAngle(){
    rearLeftAngle = rearLeft.getAngle();
    return rearLeftAngle;
  }

  @Override
  public void periodic() {
    
  }
}
