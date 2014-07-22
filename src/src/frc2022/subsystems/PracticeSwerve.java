package src.frc2022.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import src.frc2022.Utils;
import src.frc2022.commands.SwerveCommand;

public class PracticeSwerve extends Subsystem{
	Talon talon[];
	public PracticeSwerve(int[] port)
	{
		talon = new Talon[port.length];
		
	}
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new SwerveCommand());
	}
	public void setSpeed(double speed,int index)
	{
		talon[index].set(Utils.clamp(speed, 1, -1));
	}
	public void stop()
	{
		for(int x = 0; x<talon.length;x++)
		{
		talon[x].set(0);
		}
	}
		
}
