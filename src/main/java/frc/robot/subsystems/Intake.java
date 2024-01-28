package frc.robot.subsystems;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.Constants;
import frc.robot.utils.IntakeState; 

public class Intake extends SubsystemBase {
    private final CANSparkMax CANSparkMax1;
    private final CANSparkMax CANSparkMax2;
    //private final CANSparkMax CANSparkMax3;
    //private final CANSparkMax CANSparkMax4;

    private double intakeSpeed1 = 0.5;
    private double intakeSpeed2 = 0.5;
    //private double intakeSpeed3 = 0.5;
    //private double intakeSpeed4 = 0.5;
    
    private IntakeState currentState = IntakeState.STOPPED;

    public Intake(){
        this.CANSparkMax1 = new CANSparkMax(Constants.INTAKE_MOTOR1_ID, CANSparkLowLevel.MotorType.kBrushless);
        this.CANSparkMax2 = new CANSparkMax(Constants.INTAKE_MOTOR2_ID, CANSparkLowLevel.MotorType.kBrushless);
        //this.CANSparkMax3 = new CANSparkMax(Constants.INTAKE_MOTOR3_ID, CANSparkLowLevel.MotorType.kBrushless);
        //this.CANSparkMax4 = new CANSparkMax(Constants.INTAKE_MOTOR4_ID, CANSparkLowLevel.MotorType.kBrushless);

        this.CANSparkMax1.setIdleMode(IdleMode.kCoast);
        this.CANSparkMax2.setIdleMode(IdleMode.kCoast);
        //this.CANSparkMax3.setIdleMode(IdleMode.kCoast);
        //this.CANSparkMax4.setIdleMode(IdleMode.kCoast);

        CANSparkMax1.restoreFactoryDefaults();
        CANSparkMax2.restoreFactoryDefaults();
        //CANSparkMax3.restoreFactoryDefaults();
        //CANSparkMax4.restoreFactoryDefaults();

        SmartDashboard.putNumber("Intake Motor Speed 1", 0.5);
        SmartDashboard.putNumber("Intake Motor Speed 2", 0.5);
        //SmartDashboard.putNumber("Intake Motor Speed 3", 0.5);
        //SmartDashboard.putNumber("Intake Motor Speed 4", 0.5);

        CANSparkMax1.set(0);
        CANSparkMax2.set(0);
        //CANSparkMax3.set(0);
        //CANSparkMax4.set(0);

        currentState = IntakeState.STOPPED;

    }
    /**
     * sets the speed of both motors to the IntakeSpeed defined in the {@link Constants} file
     * @param forward if true the motors will spin in the intake directions,
     *                if false the motors will spin in the outtake direction
     */
    public void spin(boolean forward){
        intakeSpeed1 = SmartDashboard.getNumber("Intake Motor Speed 1", 0.5);
        intakeSpeed2 = SmartDashboard.getNumber("Intake Motor Speed 2", 0.5);
        //intakeSpeed3 = SmartDashboard.getNumber("Intake Motor Speed 3", 0.5);
        //intakeSpeed4 = SmartDashboard.getNumber("Intake Motor Speed 4", 0.5);

        intakeSpeed1 = forward ? intakeSpeed1 : intakeSpeed1 * -1;
        intakeSpeed2 = !forward ? intakeSpeed2 : intakeSpeed2 * -1;
        //intakeSpeed3 = !forward ? intakeSpeed3 : intakeSpeed3 * -1;
        //intakeSpeed4 = !forward ? intakeSpeed4 : intakeSpeed4 * -1;

        CANSparkMax1.set(intakeSpeed1);
        CANSparkMax2.set(intakeSpeed2);
        //CANSparkMax3.set(intakeSpeed3);
        //CANSparkMax4.set(intakeSpeed3);

        currentState = forward ? IntakeState.FORWARD: IntakeState.BACKWARD;
    }
    public void stop(){
        CANSparkMax1.set(0);
        CANSparkMax2.set(0);
        //CANSparkMax3.set(0);
        //CANSparkMax4.set(0);

        currentState = IntakeState.STOPPED;
    }

    public IntakeState getState() {
        return currentState;
    }
    @Override
    public void periodic() {

    }

}
