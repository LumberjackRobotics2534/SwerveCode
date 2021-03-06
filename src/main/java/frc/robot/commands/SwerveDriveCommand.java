/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.AngleTrain;
import frc.robot.subsystems.DriveTrain;

public class SwerveDriveCommand extends ParallelCommandGroup {
  
  public SwerveDriveCommand(DriveTrain _DriveTrain, AngleTrain _AngleTrain,double _joyLeftY, double _joyLeftX, double _joyRightX,double _targetAngle) {
    super(
      new SpeedDriveCommand(_DriveTrain, _joyLeftY, _joyLeftX),
      new WheelAnglePID(_AngleTrain, _targetAngle),
      new TurnCommand(_AngleTrain, _DriveTrain, _joyRightX)
    );
  }
}
