package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.Timer;

/**
 * Switch Intake from: <br>
 *Stopped -> Forward -> Backward - <br>
 * ^&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp| <br>
 * |_____________________________| <br>
 */
public class ToggleStopIntake extends CommandBase {
    private final Intake intake;
    public ToggleStopIntake(Intake intake){
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        
        intake.stop();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
