/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class SpeedDriveCommand extends CommandBase {
  DriveTrain driveTrain;
  double joyLeftY;
  double joyLeftX;
  double speed = 0.0;
  public SpeedDriveCommand(DriveTrain _DriveTrain, Double _joyLeftY, Double _joyLeftX){
    driveTrain = _DriveTrain;
    joyLeftY = _joyLeftY;
    joyLeftX = _joyLeftX;
    addRequirements(driveTrain);
  }

// Called when the command is initially scheduled.
  @Override
  public void initialize(){
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute(){
    speed = Math.sqrt(Math.pow(joyLeftY, 2) + Math.pow(joyLeftX, 2));
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
