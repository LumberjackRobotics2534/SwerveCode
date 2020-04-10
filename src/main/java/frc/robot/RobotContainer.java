package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.SwerveDriveCommand;
import frc.robot.subsystems.AngleTrain;
import frc.robot.subsystems.DriveTrain;

public class RobotContainer {
  XboxController controller = new XboxController(0);
  DriveTrain driveTrain = new DriveTrain();
  AngleTrain angleTrain = new AngleTrain();
  double joyLeftY = 0.0;
  double joyLeftX = 0.0;
  double joyRightX = 0.0;
  double targetAngle = 0.0;
  double currentAngle = 0.0;
  double angleError = 0.0;
  public RobotContainer() {
    configureButtonBindings();
    joyLeftY = controller.getY(Hand.kLeft);
    joyLeftX = controller.getX(Hand.kLeft);
    joyRightX = controller.getX(Hand.kRight);
    getTargetAngle();
    driveTrain.setDefaultCommand(new SwerveDriveCommand(driveTrain, angleTrain, joyLeftY, joyLeftX, joyRightX, targetAngle));
  }

  private void configureButtonBindings() {

  }

  public Command getAutonomousCommand() {
    return null;
  }
  /*Since the Joysticks give a -1 to 1 value and I needed to convert that to 0 to 360 scale so that it could be compared to 
  the absolute encoder, arcsin works great for this*/

  public double getTargetAngle(){
    currentAngle = angleTrain.getFrontLeftAngle();
    angleError = targetAngle - currentAngle;
    if(Math.abs(angleError) <= 90){
      if(joyLeftY >= 0){
        if(joyLeftX >= 0){
          targetAngle = Math.asin(joyLeftX) * 180 / Math.PI;//0-90
        } else if(joyLeftX < 0){
          targetAngle = (Math.asin(joyLeftX) * -180 / Math.PI) + 180;//180-270
        }
      } else{        
        if(joyLeftX < 0){
          targetAngle = (Math.asin(joyLeftX) * -180 / Math.PI) + 180;//90-180
        } else{
          targetAngle = (Math.asin(joyLeftX) * 180 / Math.PI) + 360;//270-360
          }
        }
    } else if(Math.abs(angleError) >= 90 && currentAngle <= 180){
      targetAngle = targetAngle - 180;
    } else if(Math.abs(angleError) >= 90 && currentAngle > 180){
      targetAngle = targetAngle + 180;
    }
    if(targetAngle >= 360){
      targetAngle = targetAngle - 360;
    }
    return targetAngle;
  }
}
