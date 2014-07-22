
package src.frc2022;

import src.frc2022.joysticks.SomeController;


public class OI {
    // Process operator interface input here.
	private SomeController sex;

//	private JoystickButton someShit;
	public OI() {
		sex = new SomeController(1);
		
	}
	public SomeController getControls() {
        return sex;
    }
}

