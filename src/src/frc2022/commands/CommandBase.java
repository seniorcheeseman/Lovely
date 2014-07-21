package src.frc2022.commands;

import src.frc2022.OI;
import src.frc2022.RobotMap;
import src.frc2022.subsystems.PickupSubsystem;
import src.frc2022.subsystems.PracticeSwerve;
import src.frc2022.subsystems.TankGeneric;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {
	public static PracticeSwerve pwmDriveBase = new PracticeSwerve(RobotMap.portsTalon);
	public static TankGeneric pwmTankDrive = new TankGeneric(RobotMap.portsTalon, RobotMap.portsSole);
	public static OI oi;
    public static PickupSubsystem collector = new PickupSubsystem(RobotMap.solenoidPort,RobotMap.rollerPort);
    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        //SmartDashboard.putData(pwmDriveBase);
        SmartDashboard.putData(pwmTankDrive);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
