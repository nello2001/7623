/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

//import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.Move;

/**
 * Add your docs here.
 */

public class driveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private WPI_VictorSPX leftFront = new WPI_VictorSPX(RobotMap.frontLeftDrive);
  private WPI_VictorSPX leftBack = new WPI_VictorSPX(RobotMap.backLeftDrive);
  private WPI_VictorSPX rightFront = new WPI_VictorSPX(RobotMap.frontRightDrive);
  private WPI_VictorSPX rightBack = new WPI_VictorSPX(RobotMap.backRightDrive);

  SpeedControllerGroup left = new SpeedControllerGroup(leftFront, leftBack);
  SpeedControllerGroup right = new SpeedControllerGroup(rightFront, rightBack);

  public void drive(double leftInput, double rightInput){

    left.set(-leftInput);
    right.set(-rightInput);

    //DifferentialDrive m_drive = new DifferentialDrive(left, right);

    //m_drive.curvatureDrive(leftInput, rightInput, false);
    //m_drive.arcadeDrive(leftInput, rightInput);
    //m_drive.tankDrive(leftInput, rightInput);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Move());
  }
}
