import java.util.ArrayList;
/*
 * 
 *  THIS IS IMPORTANT! We will use a boolean array to represent availability,
 *  the following indexes from 0-13 represent which array index in the boolean
 *  array the values represent.
 *  
 *  SunAM 0 | MonAM 2 | TueAM 4 | WedAM 6 | ThuAM 8 | FriAM 10 | SatAM 12
 *  
 *  SunPM 1 | MonPM 3 | TuePM 5 | WedPM 7 | ThuPM 9 | FriPM 11 | SatPM 13
 *  
 */
public class Choreperson {
	// name of person on chore
	private String name;
	// are they previous MEC or not?
	private boolean isMec;
	/*
	 * The schedule of their availability, in order
	 * from SunAM to SatPM
	 */
	private boolean[] availability = new boolean[14];
	// How many chores does the dude wanna do
	private int choreCount;
	/*
	 * Constructor for chore person
	 */
	public Choreperson(String name, boolean isMec, boolean[] availability, int choreCount) {
		this.name = new String(name);
		this.isMec = isMec;
		/*
		 * we dont want a privacy leak.
		 */
		availability = new boolean[14];
		for (int i = 0; i < availability.length; i++) {
			this.availability[i] = (availability[i]);
		}
		this.choreCount = choreCount;
	}
	public Choreperson(Choreperson choreperson) {
		this.name = choreperson.name;
		this.isMec = choreperson.isMec;
		availability = new boolean[14];
		for (int i = 0; i < availability.length; i++) {
			this.availability[i] = choreperson.availability[i];
		}
		this.choreCount = choreperson.choreCount;
	}
	/*
	 * Getter for name
	 */
	public String getName() {
		return this.name;
	}
	public int getChoreCount() {
		return choreCount;
	}
	
	public void decrementChoreCount() {
		choreCount--;
	}
	/*
	 * Getter for whether the member is in MEC
	 */
	public boolean getIsMec() {
		return this.isMec;
	}
	/*
	 * Getter for Availability
	 */
	public boolean[] getAvailabilty() {
		boolean[] getAvail = new boolean[14];
		for (int i = 0; i < 14; i++) {
			getAvail[i] = this.availability[i];
		}
		return getAvail;
	}
	/*
	 * Getter for Availability per chore
	 */
	public boolean getAvailabiltyForChore(int i) {
		return this.availability[i];
	}
	public void setAvailability(int index) {
		this.availability[index] = true;
	}
	@Override
	public String toString() {
		StringBuffer schedule = new StringBuffer("");
		for (int i = 0; i < 14; i++) {
			if (availability[i] == true) {
				schedule.append(i + 1 + ":" + "T ");
			} else {
				schedule.append("F ");
			}
		}
		return "Name: " + this.name + " Former Mec: " + isMec + " Schedule: " + schedule + "Chore Count " + choreCount;
	}
}
