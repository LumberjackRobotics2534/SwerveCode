package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.subsystems.AngleTrain;

public class WheelAnglePID extends PIDCommand {
  
  public WheelAnglePID(AngleTrain _angleTrain, double _targetAngle) {
    super(
        new PIDController(0, 0, 0),
        _angleTrain::getFrontLeftAngle,
        _targetAngle,
        output -> {
           _angleTrain.frontLeft.set(output);
           _angleTrain.frontRight.set(output);
           _angleTrain.rearLeft.set(output);
           _angleTrain.rearRight.set(output);
       },
        _angleTrain);
      getController().enableContinuousInput(Constants.anglePIDMinInput, Constants.anglePIDMaxInput);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
