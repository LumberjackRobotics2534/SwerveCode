/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class RearRightAnglePID extends PIDCommand {
  
  public RearRightAnglePID(DriveTrain _driveTrain, double _targetAngle) {
    super(
        new PIDController(0, 0, 0),
        _driveTrain::getRearRightAngle,
        _targetAngle,
        output -> {
          _driveTrain.rearRight.setAngleSpeed(output);
        },
        _driveTrain);
      getController().enableContinuousInput(Constants.anglePIDMinInput, Constants.anglePIDMaxInput);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
