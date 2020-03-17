/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.other;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.Command;

public class Trigger{
    boolean active;
    double triggerValue;

    public boolean active(XboxController _controller, String side){
        if(side == "left"){
            triggerValue = _controller.getTriggerAxis(Hand.kLeft);
        } else if(side == "right"){
            triggerValue = _controller.getTriggerAxis(Hand.kRight);
        } else{
            triggerValue = 0;
        }
        
        if(triggerValue > 0.2){
            active = true;
        } else{
            active = false;
        }
        return active;
    }

    public void whileHeld(Command _Command){
        if(active){
            _Command.schedule();
        }
    }


}
