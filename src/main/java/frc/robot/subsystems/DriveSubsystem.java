package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.Spark;
public class DriveSubsystem extends Subsystem{
    private Spark m_frontLeft  = new Spark(4);
    private Spark m_rearLeft   = new Spark(3);
    private Spark m_frontRight = new Spark(2);	
    private Spark m_rearRight  = new Spark(1);
    private MecanumDrive m_robotDrive = new MecanumDrive(m_frontLeft,m_rearLeft,m_frontRight,m_rearRight);
    @Override
    protected void initDefaultCommand() {
        m_frontLeft.setInverted(true);
    }
    public void drive(double x, double y, double theta){
        m_robotDrive.driveCartesian(x, y, theta);
    }
}