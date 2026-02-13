// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

  private final TalonSRX leftLeader;
  private final TalonSRX leftFollower;
  private final TalonSRX rightLeader;
  private final TalonSRX rightFollower;

  private final DifferentialDrive drive;

  public DriveSubsystem() {
    // Subject to change
    leftLeader = new TalonSRX(51);
    leftFollower = new TalonSRX(55);
    rightLeader = new TalonSRX(52);
    rightFollower = new TalonSRX(1);

    leftFollower.follow(leftLeader);
    rightFollower.follow(rightLeader);

    leftLeader.setInverted(false);
    rightLeader.setInverted(true);

    leftFollower.setInverted(InvertType.FollowMaster);
    rightFollower.setInverted(InvertType.FollowMaster);
  
    drive = new DifferentialDrive((x) -> SetLeftMotor(x), (x) -> SetRightMotor(x)); //new DifferentialDrive(SetLeftMotor , SetRightMotor);

  }

  private void SetLeftMotor(double speed){
    SetMotor(leftLeader,speed);
  }
    private void SetRightMotor(double speed){
    SetMotor(rightLeader,speed);
  }

  private void SetMotor(TalonSRX motor, double speed)
  {
    motor.set(TalonSRXControlMode.PercentOutput, speed);
  }
  public void driveArcade(double xSpeed, double zRotation) {
    drive.arcadeDrive(xSpeed, zRotation);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
