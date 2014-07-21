package src.frc2022.commands;

import src.frc2022.joysticks.SomeController;

public class TankCommand extends CommandBase {
	private SomeController controls;
	public TankCommand() {
        //initializes command system, system has no dependencies
        requires(pwmTankDrive);
        pwmTankDrive.flipTalon();
        
    }
	 protected void execute() {
	        controls = oi.getControls();
	        double xboxTriggers = controls.GetTriggers();
	        double leftSpeed, rightSpeed;
	        leftSpeed = controls.GetLeftY()/2.0;
	        rightSpeed = controls.GetRightY()/2.0;
	        boolean piston = controls.GetAValue();
	        if(piston == true)
	        {
	        	pwmTankDrive.extend();
	        }
	        else
	        {
	        	pwmTankDrive.retract();
	        }
	        if (xboxTriggers > 0.5) {
	            leftSpeed /= 2.0;
	            rightSpeed /= 2.0;
	        } else if (xboxTriggers < -0.5) {
	            leftSpeed *= 2.0;
	            rightSpeed *= 2.0;
	        }
	        
	        if (Math.abs(leftSpeed) < 0.1) {
	            leftSpeed = 0;
	        }
	        if (Math.abs(rightSpeed) < 0.1) {
	            rightSpeed = 0;
	        }
	        pwmTankDrive.drive(-leftSpeed, rightSpeed); //the robot will move!
	        
	    }
	
	protected void end() {
		// TODO Auto-generated method stub
		
	}
	
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}
	
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
