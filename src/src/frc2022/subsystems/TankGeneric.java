package src.frc2022.subsystems;

import src.frc2022.Utils;
import src.frc2022.commands.TankCommand;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class TankGeneric extends Subsystem {
	Talon[] talons;
	Talon[] talonLeft;
	Talon[] talonRight;
	DoubleSolenoid sole;
	 public TankGeneric(int[] ports, int[] duoSolenoid)
	 {
		 sole = new DoubleSolenoid(duoSolenoid[0],duoSolenoid[1]);
		 Talon[] newTalons = new Talon[ports.length];
	        if (checkEven(ports.length)) {

	            for (int i = 0; i < ports.length; i++) {
	            	newTalons[i] = new Talon(ports[i]);
	            }

	            this.talons = newTalons;
	            // hello world!
	            separateTalons(this.talons);
	            //assignLiveWindow();
	        } else {
	            System.out.println("Odd number of Jaguars");
	        }
	 }
	 public void extend(){
		 sole.set(DoubleSolenoid.Value.kForward);
	    }
	    
	    public void retract(){
	    	sole.set(DoubleSolenoid.Value.kReverse);
	    }
	 protected void initDefaultCommand() {
	        setDefaultCommand(new TankCommand());
	    }
	 public void setLeft(double speed) {
	        for (int i = 0; talonLeft.length > i; i++) {
	        	talonLeft[i].set(Utils.clamp(speed, 1, -1));
	        }
	    }

	    /**
	* Set the speed of the motors on the right side of the robot.
	*
	* @param speed The speed at which the motors move
	* @returns
	*/
	    public void setRight(double speed) {
	        for (int i = 0; talonRight.length > i; i++) {
	        	talonRight[i].set(Utils.clamp(speed, 1, -1));
	        }
	    }
	    /**
	* Set the speed of all the motors. Only allows for forward and backward
	* movement.
	*
	* @param speed The speed of the motors
	* @returns
	*/
	    public void drive(double speed) {
	        setRight(speed);
	        setLeft(speed);
	    }

	    /**
	* Set the speed of the motors. Each side can be set to a different speed.
	* Useful for a tank drive.
	*
	* @param speedLeft The speed of the left motors
	* @param speedRight The speed of the right motors
	* @returns
	*/
	    public void drive(double speedLeft, double speedRight) {
	        setRight(speedRight);
	        setLeft(speedLeft);
	    }

	    /**
	* Designed for use in mecanum drives. Set the speed for each motor. Must
	* have exactly 4 motors.
	*
	* @param speedLeftFront Speed of the front left wheel
	* @param speedRightFront Speed of the front right wheel
	* @param speedLeftBack Speed of the back left wheel
	* @param speedRightBack Speed of the back right wheel
	* @return
	*/
	    public void driveMecanum(double speedLeftFront, double speedRightFront, double speedLeftBack, double speedRightBack) {
	    	talonLeft[0].set(speedLeftFront);
	    	talonLeft[1].set(speedLeftBack);
	        talonRight[0].set(speedRightFront);
	        talonRight[1].set(speedRightBack);
	    }

	    /**
	* Force the motors to stop.
	*
	* @param
	* @return
	*/
	    public void stop() {
	        setRight(0);
	        setLeft(0);
	    }

	    /**
	* Function that checks if a number is even. Specifically used for checking
	* the size of arrays.
	*
	* @param size
	* @return whether or not the number passed through is even
	*/
	    public boolean checkEven(int size) {
	        if ((size % 2) == 1) {
	            return false;
	        } else {
	            return true;
	        }
	    } //end private boolean checkEven(int size)

	    /**
	* Separate the jaguars to left and right sides with odd numbered jaguars
	* being assigned to the left and even jaguars assigned on the right.
	*
	* @param jags
	* @return
	*/
	    public void separateTalons(Talon[] talons) {
	        talonLeft = new Talon[talons.length / 2];
	        talonRight = new Talon[talons.length / 2];
	        for (int i = 0, j = 0, k = 0; i < talons.length; i++) {
	            if (checkEven(i)) {
	            	talonRight[j] = talons[i];
	                j++;
	            } else if (!checkEven(i)) {
	            	talonLeft[k] = talons[i];
	                k++;
	            }
	        }
	    }

	    /**
	* Allows the front of the robot to become the back by switching the
	* jaguars. Useful for tank drives.
	*
	* @param
	* @return
	*/
	    public void flipTalon() {

	        int length = talonLeft.length / 2;
	        Talon[] tempTalons;

	        for (int i = 0; i < length; i++) {
	            Talon temp = talonLeft[i];
	            talonLeft[i] = talonLeft[length - 1 - i];
	            talonLeft[length - 1 - i] = temp;
	        }

	        for (int i = 0; i < length; i++) {
	            Talon temp = talonRight[i];
	            talonRight[i] = talonRight[length - 1 - i];
	            talonRight[length - 1 - i] = temp;
	        }

	        tempTalons = talonRight;
	        talonRight = talonLeft;
	        talonLeft = tempTalons;

	        // Does not work
	        //assignLiveWindow();
	    }
}
