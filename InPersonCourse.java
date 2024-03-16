
public class InPersonCourse extends Course {
	private int hours;
	private String date;

	// Constructor
	public InPersonCourse(String courseName, int hours, String date) {
		super(courseName);
		setHours(hours);
		setDate(date);
		price = calculatePrice();
	}

	// Copy constructor
	public InPersonCourse(InPersonCourse c) {
		super(c.courseName);
		setHours(c.hours);
		setDate(c.date);
		price = calculatePrice();
	}

	// Setter for hours
	public void setHours(int hours) {
		this.hours = hours;
	}

	// setter for starting date
	public void setDate(String date) {
		this.date = date;
	}

	@Override
	// If the course is over 20 hours you pay 35SR for an hour
	// if it's under 20 hours you pay 50SR for an hour
	public double calculatePrice() {
		if (hours >= 20)
			return hours * 45;
		return hours * 50;
	}

	// To string for In Person Course
	public String toString() {
		return super.toString() + " type: [In Person Course] ,starting Date: (" + date + ") ,Hours: " + hours;
	}
}
