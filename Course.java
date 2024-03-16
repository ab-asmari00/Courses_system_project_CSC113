
public abstract class Course {
	protected String courseName;
	protected double price;

	// Constructor
	public Course(String courseName) {
		this.courseName = courseName;
		// price = calculatePrice();
	}

	// Abstract method to calculate the price of the course
	public abstract double calculatePrice();

	// equal method to compare
	public boolean equals(Object obj) {
		if (!(obj instanceof Course))
			return false;
		Course other = (Course) obj;
		if (this.courseName.equals(other.courseName) && this.price == other.price)
			return true;
		return false;
	}

	// Setter for name
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	// Getter for price
	public double getPrice() {
		return price;
	}

	// to String method for Course (super)
	public String toString() {
		return "Course: " + courseName + " price: " + price;
	}

}
