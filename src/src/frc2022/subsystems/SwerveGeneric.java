package src.frc2022.subsystems;

import src.frc2022.commands.SwerveCommand;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SwerveGeneric extends Subsystem {
	public SwerveGeneric()
	{
		
	}

	
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		 setDefaultCommand(new SwerveCommand());
	}
}
