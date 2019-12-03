/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.ShooterSubsystem;;

public class Shoot extends Command {
  // Use requires() here to declare subsystem dependencies
  private ShooterSubsystem shooter;
  
  public Shoot(ShooterSubsystem shooter) {
    this.shooter = shooter;
    requires(shooter);
}

// Called just before this Command runs the first time
  @Override
  protected void initialize() {
    shooter.setShooterSpeed(0.8);
    SmartDashboard.putNumber("Button Pressed", 1);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    SmartDashboard.putNumber("Button Pressed", 1);
    shooter.shoot();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}