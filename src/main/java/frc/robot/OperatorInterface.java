package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.Shoot;
import frc.robot.commands.StopFeedingBalls;
import frc.robot.Robot;

public class OperatorInterface {
    private Robot robot;
    private Joystick driveStick;
    
    // Robot Alignment
    private JoystickButton shootButton;

    
    public OperatorInterface(Robot robot){
      this.robot = robot;
      createButtons();
      createCommands();

    }
  
    protected void createButtons() {
      driveStick = new Joystick(0);
      
      // Target Alignment
      shootButton = new JoystickButton(driveStick, 7);
    }
    
    protected void createCommands() { 
        shootButton.whenPressed(new Shoot(this.robot.getShooterSubsystem()));
        shootButton.whenReleased(new StopFeedingBalls(this.robot.getShooterSubsystem()));
    }
    
    public void doNothing(){
        
    }
  }