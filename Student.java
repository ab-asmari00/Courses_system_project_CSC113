
public class Student {
	private String studentName;
	private int age;
	private String major;
	private Course[] studentCourses;
	private int cCount;

	// Constructor
	public Student(String studentName, int age, String major, int size) {
		setStudentName(studentName);
		setAge(age);
		setMajor(major);
		studentCourses = new Course[size];
		cCount = 0;
	}

	// Constructor with only size for quick run
	public Student(int size) {
		setStudentName("Guest");
		setAge(0);
		setMajor("Guest");
		studentCourses = new Course[size];
		cCount = 0;
	}

	// add a course to Student Courses
	public boolean joinCourse(int choice) {
		if (cCount >= studentCourses.length || choice <= 0 || choice > Teacher.cCount)
			return false;
		if (search(Teacher.availableCourses[choice - 1]) != -1)
			return false;

		studentCourses[cCount++] = Teacher.availableCourses[choice - 1];
		return true;
	}

	// Delete course form student courses
	public boolean leaveCourse(int choice) {
		if (choice > cCount || choice <= 0)
			return false;
		studentCourses[choice - 1] = studentCourses[cCount - 1];
		studentCourses[--cCount] = null;
		return true;
	}

	// Search method
	public int search(Course c) {
		for (int i = 0; i < cCount; i++)
			if (studentCourses[i].equals(c))
				return i;
		return -1;
	}

	// display Student Courses
	public void viewStudentCourses() {
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Student Courses: ");
		for (int i = 0; i < cCount; i++)
			System.out.println("  " + (i + 1) + " - " + studentCourses[i]);
		System.out.println("--------------------------------------------------------------------------------");
	}

	// display available Courses
	public void viewAvailableCourses() {
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Available Courses: ");
		for (int i = 0; i < Teacher.cCount; i++)
			System.out.println("  " + (i + 1) + " - " + Teacher.availableCourses[i]);
		System.out.println("--------------------------------------------------------------------------------");
	}

	// setter for student name
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	// setter for student age
	public void setAge(int age) {
		this.age = age;
	}

	// setter for student major
	public void setMajor(String major) {
		this.major = major;
	}

	// getter for student cCount
	public int getcCount() {
		return cCount;
	}

	// Total price of all courses a student added
	public double totalPrice() {
		double total = 0;
		for (int i = 0; i < cCount; i++)
			total += studentCourses[i].price;
		return total;
	}

	// to String for the student
	public String toString() {
		return "Student: " + studentName + ", Age: " + age + ", Major: " + major;
	}

}
