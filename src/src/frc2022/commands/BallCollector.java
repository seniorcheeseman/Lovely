package src.frc2022.commands;

import src.frc2022.joysticks.SomeController;

public class BallCollector extends CommandBase {
	private SomeController temp = oi.getControls();
	
	 public BallCollector(boolean isCollecting) {
	        requires(collector);
	        
	    }
	protected void end() {
		
		
	}

	protected void execute() {
		
		while(temp.getRawButton(2)== true) {collector.moveSolenoid();}//TODO eventually change this to some button
		while(temp.getRawButton(1)== true) {collector.moveSolenoid();}//TODO eventually change this to some button
		while(temp.getRawButton(3) == true){collector.moveTalon(0.5);}//TODO change this shit
	}

	protected void initialize() {
		
		
	}

	protected void interrupted() {
		
		
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
