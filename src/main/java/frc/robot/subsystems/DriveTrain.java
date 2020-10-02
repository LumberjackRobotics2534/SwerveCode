package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  public CANSparkMax frontRight = new CANSparkMax(Constants.frontRightDriveMotorID, MotorType.kBrushless);
  public CANSparkMax rearRight = new CANSparkMax(Constants.rearRightDriveMotorID, MotorType.kBrushless);
  public CANSparkMax frontLeft = new CANSparkMax(Constants.frontLeftDriveMotorID, MotorType.kBrushless);
  public CANSparkMax rearLeft = new CANSparkMax(Constants.rearLeftDriveMotorID, MotorType.kBrushless);
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

  @Override
  public void periodic() {
    
  }
}
