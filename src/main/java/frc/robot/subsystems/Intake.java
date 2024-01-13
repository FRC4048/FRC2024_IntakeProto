package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.Constants;
import frc.robot.utils.IntakeState; 

public class Intake extends SubsystemBase {
    private final CANSparkMax CANSparkMax1;
    private final CANSparkMax CANSparkMax2;
    private IntakeState currentState = IntakeState.STOPPED;

    public Intake(){
        this.CANSparkMax1 = new CANSparkMax(Constants.INTAKE_MOTOR1_ID, MotorType.kBrushless);
        this.CANSparkMax2 = new CANSparkMax(Constants.INTAKE_MOTOR2_ID, MotorType.kBrushless);
    }
    //Replace PWMTalonSRX w/sparkmaxes and 
    /**
     * sets the speed of both motors to the IntakeSpeed defined in the {@link Constants} file
     * @param forward if true the motors will spin in the intake directions,
     *                if false the motors will spin in the outtake direction
     */
    public void spin(boolean forward){
        double speed = forward ? Constants.INTAKE_SPEED : Constants.INTAKE_SPEED*-1;
        CANSparkMax1.set(speed);
        CANSparkMax2.set(-speed);
        currentState = forward ? IntakeState.FORWARD: IntakeState.BACKWARD;
    }
    public void stop(){
        CANSparkMax1.set(0);
        CANSparkMax2.set(0);
        currentState = IntakeState.STOPPED;
    }

    public IntakeState getState() {
        return currentState;
    }
}
