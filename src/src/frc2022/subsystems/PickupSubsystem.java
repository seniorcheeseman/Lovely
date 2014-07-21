package src.frc2022.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PickupSubsystem extends Subsystem {
	private Solenoid s1;
	private boolean isDown = false;
	Talon t1; 
	/*
	 * Constructs the Pickupsystem
	 * @param solenoidport the port for the solenoid
	 * @param rollerPort the port for the Talon for the roller
	 */
	public PickupSubsystem(int solenoidPort, int rollerPort)
	{
		s1 = new Solenoid(solenoidPort); 
		t1 = new Talon(rollerPort);
	}
	protected void initDefaultCommand() {
		
		
	}
	/*
	 * Turns the solenoid on and off 
	 */
	public void moveSolenoid()
	{
		if(isDown == false)
		{
			s1.set(true);
			isDown = true;
		}
		else
		{
			s1.set(false);
			isDown = false;
		}
			
	}
	public void moveTalon(double speed)
	{
		t1.set(speed);
	}
}
