
public class OnlineCourse extends Course {
	private int lecturesNum;

	// Constructor
	public OnlineCourse(String courseName, int lecturesNum) {
		super(courseName);
		setLecturesNum(lecturesNum);
		price = calculatePrice();
	}

	// Copy constructor
	public OnlineCourse(OnlineCourse c) {
		super(c.courseName);
		setLecturesNum(c.lecturesNum);
		price = calculatePrice();
	}

	// Setter for lectures Number
	public void setLecturesNum(int lecturesNum) {
		this.lecturesNum = lecturesNum;
	}

	@Override
	// It calculates the price by multiplying each Lecture by 50 SR
	public double calculatePrice() {
		return lecturesNum * 50;
	}

	// To string for In Person Course
	public String toString() {
		return super.toString() + " type: [Online Course] ,Number of Lectures: " + lecturesNum;
	}
}
