package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.EmergencyIntakeStop;
import frc.robot.commands.Shoot;
import frc.robot.commands.StopFeedingBalls;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class OperatorInterface {
    private Robot robot;
    private Joystick driveStick;
    private JoystickButton shootButton;
    private JoystickButton emergencyIntakeStop;
    
    public OperatorInterface(Robot robot){
      this.robot = robot;
      createButtons();
      createCommands();

    }
  
    protected void createButtons() {
      driveStick = new Joystick(RobotMap.GAMEPAD.driverStick);
      shootButton = new JoystickButton(driveStick, RobotMap.BUTTONS.shootButton);
      emergencyIntakeStop = new JoystickButton(driveStick, RobotMap.BUTTONS.emergencyStopIntakeButton);
    }
    
    protected void createCommands() { 
        shootButton.whenPressed(new Shoot(this.robot.getShooterSubsystem()));
        shootButton.whenReleased(new StopFeedingBalls(this.robot.getShooterSubsystem()));
        emergencyIntakeStop.whenPressed(new EmergencyIntakeStop(this.robot.getIntakeSubsystem()));
    }
    
    public double getDriveInputX(){
      SmartDashboard.putNumber("Joystick X", driveStick.getX());
        return driveStick.getX();
    }

    public double getDriveInputY(){
      SmartDashboard.putNumber("Joystick Y", driveStick.getY());
      return -driveStick.getY();
  }
  }