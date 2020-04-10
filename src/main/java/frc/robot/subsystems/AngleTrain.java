/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AngleTrain extends SubsystemBase{
    public WPI_TalonFX frontRight = new WPI_TalonFX(Constants.frontRightAngleMotorID);
    public WPI_TalonFX rearRight = new WPI_TalonFX(Constants.rearRightAngleMotorID);
    public WPI_TalonFX frontLeft = new WPI_TalonFX(Constants.frontLeftAngleMotorID);
    public WPI_TalonFX rearLeft = new WPI_TalonFX(Constants.rearLeftDriveMotorID);

    DutyCycleEncoder frontRightEncoder = new DutyCycleEncoder(Constants.frontRightEncoderID);
    DutyCycleEncoder rearRightEncoder = new DutyCycleEncoder(Constants.rearRightEncoderID);
    DutyCycleEncoder frontLeftEncoder = new DutyCycleEncoder(Constants.frontLeftEncoderID);
    DutyCycleEncoder rearLeftEncoder = new DutyCycleEncoder(Constants.rearLeftEncoderID);
    
    double frontRightAngle;
    double rearRightAngle;
    double frontLeftAngle;
    double rearLeftAngle;
  
  public AngleTrain() { 

  }

  public double getFrontRightAngle(){
    frontRightAngle = frontRightEncoder.get();
    return frontRightAngle;
  }

  public double getRearRightAngle(){
    rearRightAngle = rearRightEncoder.get();
    return rearRightAngle;
  }

  public double getFrontLeftAngle(){
    frontLeftAngle = frontLeftEncoder.get();
    return frontLeftAngle;
  }

  public double getRearLeftAngle(){
    rearLeftAngle = rearLeftEncoder.get();
    return rearLeftAngle;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
