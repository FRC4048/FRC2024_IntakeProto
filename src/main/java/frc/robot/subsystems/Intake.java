package frc.robot.subsystems;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.Constants;
import frc.robot.utils.IntakeState; 

public class Intake extends SubsystemBase {
    private final CANSparkMax CANSparkMax1;
    private final CANSparkMax CANSparkMax2;
    //private final CANSparkMax CANSparkMax3;
    //private final CANSparkMax CANSparkMax4;
    private double intakeSpeed = 0.75;
    private IntakeState currentState = IntakeState.STOPPED;

    public Intake(){
        this.CANSparkMax1 = new CANSparkMax(Constants.INTAKE_MOTOR1_ID, CANSparkLowLevel.MotorType.kBrushless);
        this.CANSparkMax2 = new CANSparkMax(Constants.INTAKE_MOTOR2_ID, CANSparkLowLevel.MotorType.kBrushless);
        //this.CANSparkMax3 = new CANSparkMax(Constants.INTAKE_MOTOR1_ID, CANSparkLowLevel.MotorType.kBrushless);
        //this.CANSparkMax4 = new CANSparkMax(Constants.INTAKE_MOTOR2_ID, CANSparkLowLevel.MotorType.kBrushless);
        SmartDashboard.putNumber("Intake Motor Speeds", 0.75);
    }
    /**
     * sets the speed of both motors to the IntakeSpeed defined in the {@link Constants} file
     * @param forward if true the motors will spin in the intake directions,
     *                if false the motors will spin in the outtake direction
     */
    public void spin(boolean forward){
        intakeSpeed = SmartDashboard.getNumber("Intake Motor Speeds", 0.75);
        double speed = forward ? intakeSpeed : intakeSpeed*-1;
        CANSparkMax1.set(speed);
        CANSparkMax2.set(speed);
        //CANSparkMax3.set(-speed);
        //CANSparkMax4.set(-speed);
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
