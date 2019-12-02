package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import frc.robot.RobotMap;

public class DriveSubsystem extends Subsystem{
    

    // private CANSparkMax m_frontLeft  = new CANSparkMax(4, MotorType.kBrushless);
    // // private CANSparkMax m_rearLeft   = new CANSparkMax(3, MotorType.kBrushless);
    // private CANSparkMax m_frontRight = new CANSparkMax(2, MotorType.kBrushless);
        
    // // private CANSparkMax m_rearRight  = new CANSparkMax(1, MotorType.kBrushless);
    private int counter = 0;

    // // SpeedControllerGroup left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
    // // SpeedControllerGroup right = new SpeedControllerGroup(m_frontRight, m_rearRight);
    // private DifferentialDrive m_robotDrive = new DifferentialDrive(m_frontLeft, m_frontRight);


    CANSparkMax m_frontLeft = new CANSparkMax(RobotMap.CAN.FRONT_LEFT_MOTOR, MotorType.kBrushless);
    CANSparkMax m_rearLeft = new CANSparkMax(RobotMap.CAN.FRONT_RIGHT_MOTOR, MotorType.kBrushless);
	SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);

    CANSparkMax m_frontRight = new CANSparkMax(RobotMap.CAN.FRONT_RIGHT_MOTOR, MotorType.kBrushless);
    CANSparkMax m_rearRight = new CANSparkMax(RobotMap.CAN.REAR_RIGHT_MOTOR, MotorType.kBrushless);
    SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);
    
    DifferentialDrive m_robotDrive = new DifferentialDrive(m_left, m_right);
    

    @Override
    protected void initDefaultCommand() {
        m_frontLeft.getEncoder();
        m_frontRight.getEncoder();
        m_rearLeft.getEncoder();
        m_rearRight.getEncoder();
    }
    public void drive(double x, double y){
        counter += 2;
        SmartDashboard.putNumber("Counter2", counter);
        m_robotDrive.arcadeDrive(y, x);
        SmartDashboard.putNumber("Front motor speed", m_frontLeft.get());
    }
}
