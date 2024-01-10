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
public class ToggleIntakeStates extends CommandBase {
    private final Intake intake;
    public ToggleIntakeStates(Intake intake){
        this.intake = intake;
        addRequirements(intake);
    }
    Timer timer = new Timer();
    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        
        switch (intake.getState()){
            case FORWARD:
                intake.spin(false);
                break;
            case BACKWARD:
                intake.stop();
                break;
            case STOPPED:
                intake.spin(true);
                break;
        }
    }

    @Override
    public boolean isFinished() {
        if (timer.advanceIfElapsed(10)) {
            return true;
        } else {
            return false;
        }
    }
}