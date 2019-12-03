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
    private JoystickButtonManager buttons;

    
    public OperatorInterface(Robot robot){
        this.robot = robot;
        createButtons();
    }
  
    protected void createButtons() {
        try{ 
            driveStick = new Joystick(RobotMap.GAMEPAD.driverStick);
            buttons.newButton(RobotMap.BUTTONS.shootButton)
                .whenPressed(new Shoot(this.robot.getShooterSubsystem()))
                .whenReleased(new StopFeedingBalls(this.robot.getShooterSubsystem()))
                .add();

            buttons.newButton(RobotMap.BUTTONS.emergencyStopIntakeButton)
                .whenPressed(new EmergencyIntakeStop(this.robot.getIntakeSubsystem()))
                .add();
        } catch(Exception e){ }
    }
    
    public double getDriveInputX(){
        SmartDashboard.putNumber("Joystick X", driveStick.getX());
        return driveStick.getX();
    }

    public double getDriveInputY(){
        SmartDashboard.putNumber("Joystick Y", driveStick.getY());
        return - driveStick.getY();
    }
}