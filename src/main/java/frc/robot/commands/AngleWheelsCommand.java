/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.AngleTrain;


// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AngleWheelsCommand extends ParallelCommandGroup {
  /**
   * Creates a new AngleWheelsCommand.
   */
  public AngleWheelsCommand(AngleTrain _angleTrain, double _targetAngle) {
    super(
      new FrontRightAnglePID(_angleTrain, _targetAngle),
      new RearRightAnglePID(_angleTrain, _targetAngle),
      new FrontLeftAnglePID(_angleTrain, _targetAngle),
      new RearLeftAnglePID(_angleTrain, _targetAngle)
    );
  }
}
