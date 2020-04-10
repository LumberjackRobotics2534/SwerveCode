package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /*public SwerveModule frontRight = new SwerveModule(Constants.frontRightDriveMotorID, Constants.frontRightAngleMotorID, Constants.frontRightEncoderID);
  public SwerveModule rearRight = new SwerveModule(Constants.rearRightDriveMotorID, Constants.rearRightAngleMotorID, Constants.rearRightEncoderID);
  public SwerveModule frontLeft = new SwerveModule(Constants.frontLeftDriveMotorID, Constants.frontLeftAngleMotorID, Constants.frontLeftEncoderID);
  public SwerveModule rearLeft = new SwerveModule(Constants.rearLeftDriveMotorID, Constants.rearLeftAngleMotorID, Constants.rearLeftEncoderID);*/
  public WPI_TalonFX frontRight = new WPI_TalonFX(Constants.frontRightDriveMotorID);
  public WPI_TalonFX rearRight = new WPI_TalonFX(Constants.rearRightDriveMotorID);
  public WPI_TalonFX frontLeft = new WPI_TalonFX(Constants.frontLeftDriveMotorID);
  public WPI_TalonFX rearLeft = new WPI_TalonFX(Constants.rearLeftDriveMotorID);
  double frontRightAngle;
  double rearRightAngle;
  double frontLeftAngle;
  double rearLeftAngle;

  public DriveTrain() {

  }

  public void drive(double driveSpeed){
    frontRight.set(driveSpeed);
    rearRight.set(driveSpeed);
    frontLeft.set(driveSpeed);
    rearLeft.set(driveSpeed);
  }

  /*public double getFrontRightAngle(){
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
  }*/

  @Override
  public void periodic() {
    
  }
}
