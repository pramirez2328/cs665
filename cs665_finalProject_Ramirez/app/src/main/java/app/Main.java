package app;

import behavioral.*;
import factory.*;
import model.common.Department;
import model.common.Semester;
import model.common.Thesis;
import model.course.*;
import model.program.Program;
import model.users.*;
import structural.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. Singleton: Create a Chairperson
        Chairperson chair = Chairperson.getInstance("C1", "Dr. Smith");

        // 2. Faculty
        FullTimeFaculty drJones = new FullTimeFaculty("F1", "Dr. Jones");
        Faculty drWhite = new PartTimeFaculty("F2", "Dr. White");

        // 3. Courses
        Course java = new Course("CS501", "Java", "Intro to Java", drJones, 1);
        Course python = new Course("CS502", "Python", "Intro to Python", drJones, 2);
        Course ai = new Course("CS601", "AI", "Intro to AI", drWhite, 1);
        Course ml = new Course("CS602", "Machine Learning", "Supervised and Unsupervised", drWhite, 1);

        // Register Observer (Chair)
        java.registerObserver(chair);
        ai.registerObserver(chair);

        // Assign courses to each faculty and enforce max per semester
        assignCourseIfAllowed(drJones, java);
        assignCourseIfAllowed(drJones, python);
        assignCourseIfAllowed(drJones, ml); // should be OK (3 max)
        assignCourseIfAllowed(drJones, ai); // should fail

        assignCourseIfAllowed(drWhite, ml); // should be OK (1 max)
        assignCourseIfAllowed(drWhite, ai); // should fail

        assignCourseIfAllowed(chair, java); // should be OK
        assignCourseIfAllowed(chair, python); // should fail

        // Advisor assignment enforcement
        FullTimeFaculty profLin = new FullTimeFaculty("F3", "Dr. Lin");
        FullTimeFaculty profNg = new FullTimeFaculty("F4", "Dr. Ng");

        FullTimeFaculty.assignGraduateAdvisor(drJones); // ✅
        FullTimeFaculty.assignGraduateAdvisor(profLin); // ❌ already assigned

        FullTimeFaculty.assignUndergraduateAdvisor(profLin); // ✅
        FullTimeFaculty.assignUndergraduateAdvisor(profNg); // ❌ already assigned

        // 4. Decorator: Add features to multiple courses
        CourseFormat javaDecorated = new CapstoneCourseDecorator(new LabRequiredDecorator(new BaseCourseFormat(java)));
        CourseFormat aiDecorated = new CapstoneCourseDecorator(new BaseCourseFormat(ai));

        System.out.println("\n--- Decorated Java Course ---");
        System.out.println(javaDecorated.format());

        System.out.println("\n--- Decorated AI Course ---");
        System.out.println(aiDecorated.format());

        // 5. Composite: Build concentration trees
        Concentration mlTrack = new Concentration("Machine Learning Track");
        mlTrack.addComponent(new SingleCourse(ml));
        mlTrack.addComponent(new SingleCourse(ai));

        Concentration dataSci = new Concentration("Data Science");
        dataSci.addComponent(mlTrack);
        dataSci.addComponent(new SingleCourse(python));

        System.out.println("\n--- Composite Concentration (Data Science) ---");
        System.out.println(dataSci.format());

        // Assign coordinators
        mlTrack.setCoordinator(drJones);
        dataSci.setCoordinator(profLin);

        // Chairperson takes responsibility for top-level concentrations
        chair.addConcentration(dataSci);


        // 6. Factory: Create both Bachelor and Master programs
        ProgramFactory bachelorFactory = new BachelorProgramFactory();
        ProgramFactory masterFactory = new MasterProgramFactory();

        Program bsCS = bachelorFactory.createProgram("B.S. Computer Science", List.of(java, python), List.of(ai));
        Program msDS = masterFactory.createProgram("M.S. Data Science", List.of(ai, ml), List.of(python));

        // 7. Students
        Student alice = new Student("S1", "Alice", bsCS);
        Student bob = new Student("S2", "Bob", bsCS);
        Student charlie = new Student("S3", "Charlie", bsCS);
        Student dana = new Student("S4", "Dana", msDS);
        Student eric = new Student("S5", "Eric", msDS);

        // Student sends queries
        System.out.println("\n--- Student Queries ---");
        alice.getProgram().format(); // Ensures advisor is known

        drJones.receiveQuery(alice.getName(), "Can you help with my thesis topic?");
        profLin.receiveQuery(bob.getName(), "What electives should I pick?");
        chair.receiveQuery(dana.getName(), "I have a complaint about course overload.");

        // 8. Enrollments (Observer triggers + waitlist)
        java.enroll(alice);      // enrolled
        java.enroll(bob);        // waitlisted & chair notified
        java.drop(alice);        // bob auto-enrolled

        ai.enroll(dana);         // enrolled
        ai.enroll(eric);         // waitlisted & chair notified

        // 9. GPA Strategies
        Map<Course, String> gradesAlice = new HashMap<>();
        gradesAlice.put(java, "A");
        gradesAlice.put(python, "B");

        alice.setGpaStrategy(new StandardGpa());
        System.out.printf("\nAlice's Standard GPA: %.2f\n", alice.calculateGpa(gradesAlice));

        alice.setGpaStrategy(new PassFailGpa());
        System.out.printf("Alice's Pass/Fail GPA: %.2f\n", alice.calculateGpa(gradesAlice));

        // Dana's grades
        Map<Course, String> gradesDana = new HashMap<>();
        gradesDana.put(ai, "A");
        gradesDana.put(ml, "A");

        dana.setGpaStrategy(new StandardGpa());
        System.out.printf("\nDana's Standard GPA: %.2f\n", dana.calculateGpa(gradesDana));

        // 10. Assign Thesis
        alice.setThesis(new Thesis("AI in Education", drJones));
        dana.setThesis(new Thesis("Big Data in Finance", drWhite));

        // 11. Output student + program summaries
        List<Student> students = List.of(alice, bob, charlie, dana, eric);

        System.out.println("\n--- Student Summaries ---");
        for (Student s : students) {
            System.out.println(s);
            System.out.println("Program: " + s.getProgram().format());

            if (s.getThesis() != null) {
                System.out.println("Thesis: " + s.getThesis());
            }

            // Print semester-wise course enrollment
            if (!s.getEnrolledCourses().isEmpty()) {
                System.out.println("Courses by semester:");
                for (Map.Entry<Semester, List<Course>> entry : s.getEnrolledCourses().entrySet()) {
                    String semester = entry.getKey().getName();
                    List<String> courseTitles = entry.getValue().stream().map(Course::getTitle).toList();
                    System.out.println("  " + semester + ": " + courseTitles);
                }
            }

            System.out.println();
        }


        // 12. Display course enrollments
        System.out.println("--- Course Enrollments ---");
        List<Course> allCourses = List.of(java, python, ai, ml);
        for (Course c : allCourses) {
            System.out.println("Course: " + c.getTitle());
            System.out.println("Enrolled Students: " + c.getEnrolledStudents().size());
            System.out.println("Waitlist Size: " + c.getWaitlist().size());
            System.out.println();
        }

        // 13. The Department keeps track of the courses
        Semester spring2025 = new Semester("Spring 2025");

        Department dept = Department.getInstance();
        dept.offerCourse(spring2025, java);
        dept.offerCourse(spring2025, python);
        dept.offerCourse(spring2025, ai);
        dept.offerCourse(spring2025, ml);

        // Enroll students & track department-wide
        alice.enrollInCourse(spring2025, java);
        dept.enrollStudent(spring2025, java, alice);

        bob.enrollInCourse(spring2025, java);
        dept.enrollStudent(spring2025, java, bob);

        dana.enrollInCourse(spring2025, ai);
        dept.enrollStudent(spring2025, ai, dana);

        System.out.println("--- Courses Offered by Semester ---");
        for (Course c : dept.getCoursesOffered(spring2025)) {
            System.out.println(c.getTitle());
        }

        System.out.println("\n--- Department View: Students Enrolled by Course and Semester ---");
        for (Course c : allCourses) {
            List<Student> studentsInCourse = dept.getEnrolledStudents(c, spring2025);
            if (!studentsInCourse.isEmpty()) {
                System.out.println("Course: " + c.getTitle() + " (Semester: Spring 2025)");
                for (Student s : studentsInCourse) {
                    System.out.println("  - " + s.getName());
                }
            }
        }

        // 14. Print decorated course HTML again
        System.out.println("\n--- Course HTML Output (Decorated) ---");
        System.out.println(javaDecorated.format());
        System.out.println(aiDecorated.format());
    }

    public static void assignCourseIfAllowed(Faculty faculty, Course course) {
        if (faculty.getCoursesTaught().size() < faculty.getMaxCoursesPerSemester()) {
            faculty.assignCourse(course);
            System.out.printf("✅ Assigned %s to %s\n", course.getTitle(), faculty.getName());
        } else {
            System.out.printf("❌ Cannot assign %s to %s (course limit reached)\n", course.getTitle(), faculty.getName());
        }
    }

}
