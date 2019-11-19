/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */


public class Robot extends TimedRobot {
  
  DriveSubsystem robotDrive = new DriveSubsystem();

  ShooterSubsystem shoot = new ShooterSubsystem();
  private OperatorInterface oi = new OperatorInterface(this);
  

  //Define joystick being used at USB port 1 on the Driver Station
  Joystick m_driveStick = new Joystick(0);

  @Override
  public void robotInit() {
     oi.doNothing();
  }

  @Override
  public void teleopPeriodic(){
    Scheduler.getInstance().run();
    SmartDashboard.putNumber("Joystick X", m_driveStick.getX());
    SmartDashboard.putNumber("Joystick Y", m_driveStick.getY());
    SmartDashboard.putNumber("Joystick Z", m_driveStick.getZ());
    robotDrive.drive(m_driveStick.getX(), -m_driveStick.getY());
  }

  @Override
  public void disabledPeriodic(){
    Scheduler.getInstance().run();
    robotDrive.drive(m_driveStick.getX(), -m_driveStick.getY());
  }

  public ShooterSubsystem getShooterSubsystem(){
    return shoot;
  }
  
}
