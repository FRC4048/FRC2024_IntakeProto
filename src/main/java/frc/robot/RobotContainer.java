// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.ToggleIntakeStates;
import frc.robot.commands.ToggleReverseIntakeStates;
import frc.robot.commands.ToggleStopIntake;
import frc.robot.subsystems.Intake;
import frc.robot.utils.Constants;

public class RobotContainer {
    private final CommandXboxController controller = new CommandXboxController(Constants.CONTROLLER_ID);
    private final Intake intake;
    public RobotContainer() {
        this.intake = new Intake();
        configureBindings();
    }
    private void configureBindings() {
        controller.button(XboxController.Button.kA.value).onTrue(new ToggleIntakeStates(intake));
        controller.button(XboxController.Button.kB.value).onTrue(new ToggleReverseIntakeStates(intake));
        controller.button(XboxController.Button.kY.value).onTrue(new ToggleStopIntake(intake));
    }

}
