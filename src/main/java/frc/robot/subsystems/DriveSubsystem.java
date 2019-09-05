package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class DriveSubsystem extends Subsystem{
    private CANSparkMax m_frontLeft  = new CANSparkMax(4, MotorType.kBrushless);
    private CANSparkMax m_rearLeft   = new CANSparkMax(3, MotorType.kBrushless);
    private CANSparkMax m_frontRight = new CANSparkMax(2, MotorType.kBrushless);	
    private CANSparkMax m_rearRight  = new CANSparkMax(1, MotorType.kBrushless);
    private int counter = 0;

    SpeedControllerGroup left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
	SpeedControllerGroup right = new SpeedControllerGroup(m_frontRight, m_rearRight);
    private DifferentialDrive m_robotDrive = new DifferentialDrive(left, right);
    @Override
    protected void initDefaultCommand() {
        m_frontLeft.setInverted(true);
    }
    public void drive(double x, double y, double theta){
        counter += 1;
        SmartDashboard.putNumber("Counter", counter);
        m_robotDrive.arcadeDrive(y, theta);
    }
}
