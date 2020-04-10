/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AngleTrain;
import frc.robot.subsystems.DriveTrain;

public class TurnCommand extends CommandBase {
  AngleTrain angleTrain;
  DriveTrain driveTrain;
  double joyRightX;
  double angle;
  SpeedControllerGroup front = new SpeedControllerGroup(driveTrain.frontLeft, driveTrain.frontRight);
  SpeedControllerGroup rear = new SpeedControllerGroup(driveTrain.rearLeft, driveTrain.rearRight);
  SpeedControllerGroup left = new SpeedControllerGroup(driveTrain.frontLeft, driveTrain.rearLeft);
  SpeedControllerGroup right = new SpeedControllerGroup(driveTrain.frontRight, driveTrain.rearRight);

  public TurnCommand(AngleTrain _AngleTrain, DriveTrain _DriveTrain, double _joyRightX) {
    angleTrain = _AngleTrain;
    driveTrain = _DriveTrain;
    joyRightX = _joyRightX;
    addRequirements(angleTrain, driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    angle = angleTrain.getFrontLeftAngle();
    if(-45 < angle && angle < 45 || -135 > angle && angle > 135){
      right.set(joyRightX);
      left.set(-joyRightX);
    } else if(-45 < angle && angle <= -90 || 45 < angle && angle <= 90 || 90 >= angle && angle > 135 || -90 >= angle && angle > -135){
      front.set(joyRightX);
      rear.set(-joyRightX);
    } else if(angle == 45 || angle == -135){
      driveTrain.frontRight.set(joyRightX);
      driveTrain.rearLeft.set(-joyRightX);
    } else if(angle == -45 || angle == 135){
      driveTrain.frontLeft.set(joyRightX);
      driveTrain.rearRight.set(-joyRightX);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
