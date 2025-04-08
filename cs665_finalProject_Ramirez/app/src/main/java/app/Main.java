package app;

import behavioral.*;
import factory.*;
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
        Faculty drJones = new FullTimeFaculty("F1", "Dr. Jones");
        Faculty drWhite = new PartTimeFaculty("F2", "Dr. White");

        // 3. Courses
        Course java = new Course("CS501", "Java", "Intro to Java", drJones, 1);
        Course python = new Course("CS502", "Python", "Intro to Python", drJones, 2);
        Course ai = new Course("CS601", "AI", "Intro to AI", drWhite, 1);
        Course ml = new Course("CS602", "Machine Learning", "Supervised and Unsupervised", drWhite, 1);

        // Register Observer (Chair)
        java.registerObserver(chair);
        ai.registerObserver(chair);

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

        // 13. Print decorated course HTML again
        System.out.println("--- Course HTML Output (Decorated) ---");
        System.out.println(javaDecorated.format());
        System.out.println(aiDecorated.format());
    }
}
