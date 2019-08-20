package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.revrobotics.SparkMax;
public class DriveSubsystem extends Subsystem{
    private Spark m_frontLeft  = new Spark(4);
    private Spark m_rearLeft   = new Spark(3);
    private Spark m_frontRight = new Spark(2);	
    private Spark m_rearRight  = new Spark(1);

    SpeedControllerGroup left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
	SpeedControllerGroup right = new SpeedControllerGroup(m_frontRight, m_rearRight);
    private DifferentialDrive m_robotDrive = new DifferentialDrive(left, right);
    @Override
    protected void initDefaultCommand() {
        m_frontLeft.setInverted(true);
    }
    public void drive(double x, double y, double theta){
        m_robotDrive.arcadeDrive(y, theta);
    }
}