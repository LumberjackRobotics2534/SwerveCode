
package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AngleTrain extends SubsystemBase{
    public CANSparkMax frontRight = new CANSparkMax(Constants.frontRightAngleMotorID, MotorType.kBrushless);
    public CANSparkMax rearRight = new CANSparkMax(Constants.rearRightAngleMotorID, MotorType.kBrushless);
    public CANSparkMax frontLeft = new CANSparkMax(Constants.frontLeftAngleMotorID, MotorType.kBrushless);
    public CANSparkMax rearLeft = new CANSparkMax(Constants.rearLeftDriveMotorID, MotorType.kBrushless);

    public AnalogInput frontRightEncoder = new AnalogInput(Constants.frontRightEncoderID);
    public AnalogInput frontLeftEncoder = new AnalogInput(Constants.frontLeftEncoderID);
    public AnalogInput rearRightEncoder = new AnalogInput(Constants.rearRightEncoderID);
    public AnalogInput rearLeftEncoder = new AnalogInput(Constants.rearLeftEncoderID);
    
    double frontRightAngle;
    double rearRightAngle;
    double frontLeftAngle;
    double rearLeftAngle;
  
  public AngleTrain() { 

  }

  public double getFrontRightAngle(){
    frontRightAngle = (frontRightEncoder.getVoltage() / 5) * 360 ;
    return frontRightAngle;
  }

  public double getRearRightAngle(){
    rearRightAngle = (rearRightEncoder.getVoltage() / 5) * 360;
    return rearRightAngle;
  }

  public double getFrontLeftAngle(){
    frontLeftAngle = (frontLeftEncoder.getVoltage() / 5) * 360;
    return frontLeftAngle;
  }

  public double getRearLeftAngle(){
    rearLeftAngle = (rearLeftEncoder.getVoltage() / 5) * 360;
    return rearLeftAngle;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
