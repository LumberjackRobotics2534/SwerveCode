package frc.robot.other;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.Command;

public class Trigger{
    boolean active;
    double triggerValue;

    public Trigger(XboxController _controller, Side _side){
        if(_side == Side.kLeft){
            triggerValue = _controller.getTriggerAxis(Hand.kLeft);
        } else if(_side == Side.kRight){
            triggerValue = _controller.getTriggerAxis(Hand.kRight);
        } else{
            triggerValue = 0;
        }
    }

    public boolean active(XboxController _controller, String side){
        if(triggerValue > 0.2){
            active = true;
        } else{
            active = false;
        }
        return active;
    }

    public void whileHeld(Command _Command){
        while(active){
            _Command.schedule();
        }
    }

    public enum Side {
        kLeft(0), kRight(1);
    
        @SuppressWarnings("MemberName")
        public final int value;
    
        Side(int value) {
          this.value = value;
        }
      }


}
