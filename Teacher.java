
public class Teacher {
	private String teacherName;
	private String email;
	public static Course[] availableCourses;
	public static int cCount;

	// Constructor
	public Teacher(String teacherName, String email, int size) {
		setTeacherName(teacherName);
		setEmail(email);
		availableCourses = new Course[size];
		cCount = 0;
	}

	// Constructor with only size for quick run
	public Teacher(int size) {
		setTeacherName("Guest");
		setEmail("Guest");
		availableCourses = new Course[size];
		cCount = 0;
	}

	// Add course to available Courses method
	public boolean addCourse(Course c) {
		if (cCount >= availableCourses.length)
			return false;
		if (search(c) != -1)
			return false;
		if (c instanceof OnlineCourse)
			availableCourses[cCount++] = new OnlineCourse((OnlineCourse) c);
		if (c instanceof InPersonCourse)
			availableCourses[cCount++] = new InPersonCourse((InPersonCourse) c);
		return true;
	}

	// Delete course
	public boolean deleteCourse(int choice) {
		if (choice > cCount || choice <= 0)
			return false;
		availableCourses[choice - 1] = availableCourses[cCount - 1];
		availableCourses[--cCount] = null;
		return true;
	}

	// Search method
	public int search(Course c) {
		for (int i = 0; i < cCount; i++)
			if (availableCourses[i].equals(c))
				return i;
		return -1;
	}

	// display Available Courses
	public void viewAvailableCourses() {
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Available Courses: ");
		for (int i = 0; i < cCount; i++)
			System.out.println("  " + (i + 1) + " - " + availableCourses[i]);
		System.out.println("--------------------------------------------------------------------------------");
	}

	// Setter for Teacher Name
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	// Setter for Teacher Email
	public void setEmail(String email) {
		this.email = email;
	}

	// to String for the Teacher
	public String toString() {
		return "Teacher: " + teacherName + ", Email: " + email;
	}
}
