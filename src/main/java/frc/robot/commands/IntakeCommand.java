package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class IntakeCommand extends Command {

    ShooterSubsystem shooter;
    IndexerSubsystem indexer;

    public IntakeCommand(ShooterSubsystem _shooter, IndexerSubsystem _indexer) {
        shooter = _shooter; 
        indexer = _indexer;
        addRequirements(_shooter, _indexer);
    }

      // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooter.ShooterStop();
    indexer.ShooterStop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooter.ShooterOut(.9); //change later dude
    indexer.ShooterOut(.9);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.ShooterStop();
    indexer.ShooterStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
    
}
