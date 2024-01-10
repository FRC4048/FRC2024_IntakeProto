package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

/**
 * Switch Intake from: <br>
 *Stopped -> Forward -> Backward - <br>
 * ^&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp| <br>
 * |_____________________________| <br>
 */
public class ToggleIntakeStates extends CommandBase {
    private final Intake intake;
    public ToggleIntakeStates(Intake intake){
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        switch (intake.getState()){
            case FORWARD -> intake.spin(false);
            case BACKWARD -> intake.stop();
            case STOPPED -> intake.spin(true);
        }
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
