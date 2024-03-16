import java.util.Scanner;

public class CourseTest {

	void mainScreen() {
		System.out.println("****************************************");
		System.out.println("*    -{ Welcome to Courses system }-   *");
		System.out.println("*                                      *");
		System.out.println("* Please choose an option:             *");
		System.out.println("* 1 - Login as a Teacher               *");
		System.out.println("* 2 - Login as a Student               *");
		System.out.println("* 3 - Exit program                     *");
		System.out.println("****************************************");
	}

	void registerOrGuest() {
		System.out.println("****************************************");
		System.out.println("* Please choose an option              *");
		System.out.println("* 1 - Register                         *");
		System.out.println("* 2 - Continue as a guest              *");
		System.out.println("****************************************");
	}

	void enterName() {
		System.out.println("Please enter your name:");
	}

	void enterEmail() {
		System.out.println("Please enter your Email:");
	}

	void enterNumOfCourses() {
		System.out.println("Please enter the number of courses to add:");
	}

	void teacherOptions() {
		System.out.println("****************************************");
		System.out.println("*          [Teacher's page]            *");
		System.out.println("* Please choose an option              *");
		System.out.println("* 1 - Add courses                      *");
		System.out.println("* 2 - Delete course                    *");
		System.out.println("* 3 - View available courses           *");
		System.out.println("* 4 - Back to main menu                *");
		System.out.println("****************************************");
	}

	void addOptions() {
		System.out.println("****************************************");
		System.out.println("*          [Teacher's page]            *");
		System.out.println("* Please choose an option              *");
		System.out.println("* 1 - Add Online courses               *");
		System.out.println("* 2 - Add In Person course             *");
		System.out.println("* 3 - Back                             *");
		System.out.println("****************************************");
	}

	void enterCourseName() {
		System.out.println("Please enter course name:");
	}

	void enterCourseLectures() {
		System.out.println("Please enter the number of lectures:");
	}

	void enterCourseHours() {
		System.out.println("Please enter how many hours the course is:");
	}

	void enterCourseDate() {
		System.out.println("Please enter the starting date of the course:");
	}

	void enterNumOfDelete() {
		System.out.println("Please enter the number of the course to Delete it, to go back choose 0:");
	}

	void enterAge() {
		System.out.println("Please enter your age:");
	}

	void enterMajor() {
		System.out.println("Please enter your Major:");
	}

	void enterStudentCourses() {
		System.out.println("Please enter the number of courses you want to join:");
	}

	void enterNumOfJoin() {
		System.out.println("Please enter the number of the course to join it, to go back choose 0:");
	}

	void enterNumOfLeave() {
		System.out.println("Please enter the number of the course to leave it, to go back choose 0:");
	}

	void studentOptions() {
		System.out.println("****************************************");
		System.out.println("*          [Student's page]            *");
		System.out.println("* Please choose an option              *");
		System.out.println("* 1 - Join courses                     *");
		System.out.println("* 2 - Leave course                     *");
		System.out.println("* 3 - View available courses           *");
		System.out.println("* 4 - View student courses             *");
		System.out.println("* 5 - Back to main menu                *");
		System.out.println("****************************************");
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CourseTest menu = new CourseTest();
		Teacher teacher = null;
		Student student = null;
		boolean teacherLogin = true, studentLogin = true;
		int numOfCourses = 0, studentCourses = 0;
		while (true) {
			menu.mainScreen();
			int option = scan.nextInt();
			switch (option) {
			// Teacher
			case 1:

				// Check if the teacher has logged on before
				if (teacherLogin) {
					menu.registerOrGuest();
					option = scan.nextInt();
					switch (option) {
					// Register
					case 1:
						menu.enterName();
						String name = scan.next();
						menu.enterEmail();
						String email = scan.next();
						menu.enterNumOfCourses();
						numOfCourses = scan.nextInt();
						while (numOfCourses < 1) {
							System.out.println("Invalid input! please try again; must be over 1");
							numOfCourses = scan.nextInt();
						}
						teacher = new Teacher(name, email, numOfCourses);
						teacherLogin = false;
						break;
					// Continue as a guest
					case 2:
						menu.enterNumOfCourses();
						numOfCourses = scan.nextInt();
						while (numOfCourses < 1) {
							System.out.println("Invalid input! please try again; must be over 1");
							numOfCourses = scan.nextInt();
						}
						teacher = new Teacher(numOfCourses);
						teacherLogin = false;
						break;
					default:
						System.out.println("Invalid input please try again");
						break;
					}
				}

				boolean teacherMenu = true;
				while (teacherMenu) {
					menu.teacherOptions();
					option = scan.nextInt();

					switch (option) {

					// Add course
					case 1:
						if (Teacher.cCount < numOfCourses) {
							menu.addOptions();
							option = scan.nextInt();
							switch (option) {
							// Online course
							case 1:
								menu.enterCourseName();
								String name = scan.next();
								menu.enterCourseLectures();
								int numOfLectures = scan.nextInt();
								while (numOfLectures < 1) {
									System.out.println("Invalid input! please try again; must be over 1");
									numOfLectures = scan.nextInt();
								}
								teacher.addCourse(new OnlineCourse(name, numOfLectures));
								break;
							// In person course
							case 2:
								menu.enterCourseName();
								String name2 = scan.next();
								menu.enterCourseHours();
								int hours = scan.nextInt();
								while (hours < 1) {
									System.out.println("Invalid input! please try again; must be over 1");
									hours = scan.nextInt();
								}
								menu.enterCourseDate();
								String date = scan.next();
								teacher.addCourse(new InPersonCourse(name2, hours, date));
								System.out.println("The course has been successfully added");
								break;
							// Back to the main menu
							case 3:
								break;

							default:
								System.out.println("Invalid input please try again");
								break;
							}
						} else
							System.out.println("Number of courses has reached the limit!");
						break;

					// Delete course
					case 2:
						teacher.viewAvailableCourses();
						menu.enterNumOfDelete();
						int num = scan.nextInt();

						while (num < 0 || num > Teacher.cCount) {
							System.out.println("Invalid input! please try again; input not matching the options");
							num = scan.nextInt();
						}
						if (num != 0) {
							if (teacher.deleteCourse(num))
								;
							System.out.println("The course has been successfully deleted");
						}

						break;
					// View available courses
					case 3:
						teacher.viewAvailableCourses();
						break;
					// Exits the teacher menu and goes back to the main menu
					case 4:
						teacherMenu = false;
						break;
					default:
						System.out.println("Invalid input please try again");
						break;
					}
				}

				break;

			// Student
			case 2:

				// Check if the student has logged on before
				if (studentLogin) {
					menu.registerOrGuest();
					option = scan.nextInt();
					switch (option) {
					// Register
					case 1:
						menu.enterName();
						String name = scan.next();
						menu.enterAge();
						int age = scan.nextInt();
						menu.enterMajor();
						String major = scan.next();
						menu.enterStudentCourses();
						studentCourses = scan.nextInt();
						while (studentCourses < 1) {
							System.out.println("Invalid input! please try again; must be over 1");
							studentCourses = scan.nextInt();
						}
						student = new Student(name, age, major, studentCourses);
						studentLogin = false;
						break;
					// Continue as a guest
					case 2:
						menu.enterStudentCourses();
						studentCourses = scan.nextInt();
						while (studentCourses < 1) {
							System.out.println("Invalid input! please try again; must be over 1");
							studentCourses = scan.nextInt();
						}
						student = new Student(studentCourses);
						studentLogin = false;
						break;
					default:
						System.out.println("Invalid input please try again");
						break;
					}
				}

				boolean studentMenu = true;
				while (studentMenu) {
					menu.studentOptions();
					option = scan.nextInt();

					switch (option) {

					// Join course
					case 1:
						if (student.getcCount() < studentCourses) {
							student.viewAvailableCourses();
							menu.enterNumOfJoin();
							int num = scan.nextInt();

							while (num < 0 || num > Teacher.cCount) {
								System.out.println("Invalid input! please try again; input not matching the options");
								num = scan.nextInt();
							}
							if (num != 0) {
								if (student.joinCourse(num))
									System.out.println("The course has been successfully joined");
							}
						} else
							System.out.println("Number of courses has reached the limit!");
						break;

					// Leave course
					case 2:
						student.viewStudentCourses();
						menu.enterNumOfLeave();
						int num = scan.nextInt();

						while (num < 0 || num > student.getcCount()) {
							System.out.println("Invalid input! please try again; input not matching the options");
							num = scan.nextInt();
						}
						if (num != 0) {
							if (student.leaveCourse(num))
								;
							System.out.println("The course has been successfully leaved");
						}
						break;
					// View available courses
					case 3:
						student.viewAvailableCourses();
						break;
					// View Student courses
					case 4:
						student.viewStudentCourses();
						break;
					// Exits the student menu and goes back to the main menu
					case 5:
						studentMenu = false;
					default:
						System.out.println("Invalid input please try again");
						break;
					}
				}

				break;
			// Exit the program
			case 3:
				System.exit(0);
				break;

			default:
				System.out.println("Invalid input please try again");
				break;

			}
		}
	}

}
