package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;



public class ShooterSubsystem extends Subsystem{
    private Timer stopWatch = new Timer();
    

    private double m_speed = 0;
    // private double h_speed = 0;

    private final WPI_TalonSRX m_ShooterMotor  = new WPI_TalonSRX(4);

    //Change 2 to appropriate value
    // private WPI_TalonSRX m_HopperMotor = new WPI_TalonSRX(2);

    private final Solenoid m_solenoid1 = new Solenoid(10, 0);
    private final Solenoid m_solenoid2 = new Solenoid(10, 1);


    @Override
    protected void initDefaultCommand() {
        m_ShooterMotor.set(0);
        // m_HopperMotor.set(0);
    }
    public void setVelocityOfShooter(final double speed){
        m_speed = speed;
    }

    public double convertRateToSpeed(final double rate){
        // Add code here to convert rate of balls to speed of motor
        return rate;
    }

    // public void setShootRate(double ballsPerSecond){
    //     h_speed = convertRateToSpeed(ballsPerSecond); 
    // }

    public void triggerOpen(){
        m_solenoid1.set(false);
        m_solenoid2.set(true);
    }

    public void triggerClose(){
        m_solenoid1.set(true);
        m_solenoid2.set(false);
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
