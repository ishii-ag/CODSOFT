import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task5 {
    private List<Course> courses;
    private List<Student> students;

    public Task5() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayCourses() {
        System.out.println("\nAvailable Courses:");
        for (Course course : courses) {
            System.out.println("Course Code: " + course.getCode() + 
                               ", Title: " + course.getTitle() + 
                               ", Description: " + course.getDescription() + 
                               ", Capacity: " + course.getCapacity() + 
                               ", Enrolled: " + course.getEnrolledStudents() + 
                               ", Schedule: " + course.getSchedule());
        }
    }

    public Student findStudent(String studentID) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    public Course findCourse(String courseCode) {
        for (Course course : courses) {
            if (course.getCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Task5 system = new Task5();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Course");
            System.out.println("2. Add Student");
            System.out.println("3. Display Available Courses");
            System.out.println("4. Register for a Course");
            System.out.println("5. Drop a Course");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Course Code: ");
                    String courseCode = scanner.nextLine();
                    System.out.print("Enter Course Title: ");
                    String courseTitle = scanner.nextLine();
                    System.out.print("Enter Course Description: ");
                    String courseDescription = scanner.nextLine();
                    System.out.print("Enter Course Capacity: ");
                    int courseCapacity = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Course Schedule: ");
                    String courseSchedule = scanner.nextLine();
                    Course course = new Course(courseCode, courseTitle, courseDescription, courseCapacity, courseSchedule);
                    system.addCourse(course);
                    System.out.println("Course added successfully.");
                    break;
                case 2:
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Student ID: ");
                    String studentID = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    Student student = new Student(studentID, studentName);
                    system.addStudent(student);
                    System.out.println("Student added successfully.");
                    break;
                case 3:
                    system.displayCourses();
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.next();
                    student = system.findStudent(studentID);
                    if (student != null) {
                        System.out.print("Enter Course Code: ");
                        courseCode = scanner.next();
                        course = system.findCourse(courseCode);
                        if (course != null) {
                            if (student.registerCourse(course)) {
                                System.out.println("Successfully registered for the course.");
                            } else {
                                System.out.println("Failed to register for the course. It might be full or already registered.");
                            }
                        } else {
                            System.out.println("Course not found.");
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.next();
                    student = system.findStudent(studentID);
                    if (student != null) {
                        System.out.print("Enter Course Code: ");
                        courseCode = scanner.next();
                        course = system.findCourse(courseCode);
                        if (course != null) {
                            if (student.dropCourse(course)) {
                                System.out.println("Successfully dropped the course.");
                            } else {
                                System.out.println("Failed to drop the course. It might not be registered.");
                            }
                        } else {
                            System.out.println("Course not found.");
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
