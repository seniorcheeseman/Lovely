package src.frc2022.commands;

import src.frc2022.joysticks.SomeController;

public class SwerveCommand extends CommandBase  {
	SomeController control;
	public SwerveCommand() {
		requires(pwmDriveBase);

    }

	
	protected void initialize() {
		// TODO Auto-generated method stub
		pwmDriveBase.stop();
	}

	
	protected void execute() {
		// TODO Auto-generated method stub
//		control = oi.getControls();
//		double controlTriggers = control.GetTriggers();
		double speed = 0.5; //temporary test speed
		pwmDriveBase.setSpeed(speed,0);
	}

	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	
	protected void end() {
		// TODO Auto-generated method stub
		pwmDriveBase.stop();
	}

	
	protected void interrupted() {
		// TODO Auto-generated method stub
		pwmDriveBase.stop();
	}
	

}
