package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.RobotMap;


public class IntakeSubsystem extends Subsystem{
    

    private double intakeSpeed = 0.75;

    private final WPI_TalonSRX m_IntakeMotor  = new WPI_TalonSRX(RobotMap.CAN.INTAKE_MOTOR);


    @Override
    protected void initDefaultCommand() {
        m_IntakeMotor.set(intakeSpeed);
        // m_HopperMotor.set(0);
    }

    public void emergencyStopBringingInBalls(){
        m_IntakeMotor.set(0);
    }
}
