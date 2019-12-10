package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.RobotMap;



public class ShooterSubsystem extends Subsystem{
    private Timer stopWatch = new Timer();
    

    private double m_speed = 0;
    private double h_speed = 0;

    private final WPI_TalonSRX m_ShooterMotor  = new WPI_TalonSRX(RobotMap.CAN.SHOOTER_MOTOR);

    // private WPI_TalonSRX m_HopperMotor = new WPI_TalonSRX(RobotMap.CAN.HOPPER_MOTOR);

    //private final Solenoid m_solenoid1 = new Solenoid(RobotMap.CAN.PCM_ID, RobotMap.PNEUMATICS.solenoid1);
    //private final Solenoid m_solenoid2 = new Solenoid(RobotMap.CAN.PCM_ID, RobotMap.PNEUMATICS.solenoid2);


    @Override
    protected void initDefaultCommand() {
        m_ShooterMotor.set(0);
        // m_HopperMotor.set(0);
    }
    public void setVelocityOfShooter(final double speed){
        m_speed = speed;
    }

    public void triggerOpen(){
        //m_solenoid1.set(false);
        //m_solenoid2.set(true);
    }

    public void triggerClose(){
        //m_solenoid1.set(true);
        //m_solenoid2.set(false);
    }

    public void shoot(){
        m_ShooterMotor.set(m_speed);
        triggerOpen();
        // m_HopperMotor.set(h_speed);
    }


    public void stop_shooting(){
        // m_HopperMotor.set(0);
        stopWatch.start();
        triggerClose();

        stopWatch.delay(2);
        stopWatch.stop();
        setVelocityOfShooter(0);
        shoot();
        
        
    }
}
