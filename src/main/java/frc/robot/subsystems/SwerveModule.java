/*----------------------------------------------------------------------------*/
/*                                                                            */
/*                                                                            */
/*                            Ignore this Joe                                 */
/*                                                                            */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class SwerveModule extends SpeedControllerGroup {
    static WPI_TalonFX driveMotor;
    static WPI_TalonFX angleMotor;
    static DutyCycleEncoder angleEncoder;
    double angle;

    public SwerveModule(int _driveMotorID, int _angleMotorID, int _encoderID) {
        super(driveMotor, angleMotor);
        driveMotor = new WPI_TalonFX(_driveMotorID);
        angleMotor = new WPI_TalonFX(_angleMotorID);
        angleEncoder = new DutyCycleEncoder(_encoderID);
    }

    public void setDriveSpeed(double driveSpeed) {
        driveMotor.set(driveSpeed);
    }

    public void setAngleSpeed(double speed) {
        angleMotor.set(speed);
    }

    public double getAngle() {
        angle = angleEncoder.get();
        return angle;
    }
}
