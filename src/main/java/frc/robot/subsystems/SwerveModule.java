/*----------------------------------------------------------------------------*/
/*                                                                            */
/*                                                                            */
/*                            Ignore this Joe                                 */
/*                                                                            */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class SwerveModule extends SpeedControllerGroup {
    static CANSparkMax driveMotor;
    static CANSparkMax angleMotor;
    static AnalogInput angleEncoder;
    double angle;

    public SwerveModule(int _driveMotorID, int _angleMotorID, int _encoderID) {
        super(driveMotor, angleMotor);
        driveMotor = new CANSparkMax(_driveMotorID, MotorType.kBrushless);
        angleMotor = new CANSparkMax(_angleMotorID, MotorType.kBrushless);
        angleEncoder = new AnalogInput(_encoderID);
    }

    public void setDriveSpeed(double driveSpeed) {
        driveMotor.set(driveSpeed);
    }

    public void setAngleSpeed(double speed) {
        angleMotor.set(speed);
    }

    public double getAngle() {
        angle = (angleEncoder.getVoltage() / 5) * 360;
        return angle;
    }
}
