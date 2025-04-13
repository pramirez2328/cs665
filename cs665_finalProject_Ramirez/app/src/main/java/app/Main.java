package app;

import behavioral.*;
import creational.*;
import model.common.*;
import model.course.*;
import model.program.Program;
import model.users.*;
import structural.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            runAll();
        } else {
            switch (args[0]) {
                case "creational" -> runCreationalPattern();
                case "structural" -> runStructuralPattern();
                case "behavioral" -> runBehavioralPattern();
                default -> runAll();
            }
        }
    }


    public static void runCreationalPattern() {
        System.out.println("\n=== SINGLETON, FACTORY, AND BUILDER PATTERNS ===");

        // Singleton: Chairperson instance
        System.out.println("--- Chairperson Singleton ---");
        Chairperson chair = Chairperson.getInstance("C1", "Dr. Smith");
        System.out.println("Chairperson Created: " + chair.getName());

        System.out.println("\n------------------------------------------");
        // Factory: Create Programs
        System.out.println("\n--- Program Factories ---");
        ProgramFactory bachelorFactory = new BachelorProgramFactory();
        ProgramFactory masterFactory = new MasterProgramFactory();

        Course java = new Course("CS501", "Java", "Intro to Java", null, 20);
        Course python = new Course("CS502", "Python", "Intro to Python", null, 20);
        Course ai = new Course("CS601", "AI", "Intro to AI", null, 20);
        Course ml = new Course("CS602", "ML", "Machine Learning", null, 20);

        Program bsCS = bachelorFactory.createProgram("B.S. Computer Science", List.of(java, python), List.of(ai));
        Program msDS = masterFactory.createProgram("M.S. Data Science", List.of(ai, ml), List.of(python));

        // Print program descriptions
        System.out.println("\n-- Programs Created --");
        System.out.println(bsCS.format());
        System.out.println(msDS.format());

        // Create students enrolled in those programs
        Student alice = new Student("S1", "Alice", bsCS);
        Student bob = new Student("S2", "Bob", bsCS);
        Student dana = new Student("S3", "Dana", msDS);

        // Assign thesis to Master's student
        FullTimeFaculty drJones = new FullTimeFaculty("F1", "Dr. Jones");
        dana.setThesis(new Thesis("Big Data Ethics", drJones));

        // Display students and programs
        System.out.println("\n-- Enrolled Students --");
        List<Student> students = List.of(alice, bob, dana);
        for (Student s : students) {
            System.out.println(s);
            System.out.println("Program: " + s.getProgram().format());
            if (s.getThesis() != null) {
                System.out.println("Thesis: " + s.getThesis());
            }
            System.out.println();
        }

        // Add a Certificate Program for extensibility
        ProgramFactory certFactory = new CertificateProgramFactory();
        Program certAnalytics = certFactory.createProgram("Cert. Analytics", List.of(ai, ml), List.of());

        System.out.println("\n-- Certificate Program Created --");
        System.out.println(certAnalytics.format());

        System.out.println("\n------------------------------------------");
        System.out.println("\n--- Thesis Builder Pattern ---");
        // Builder: create a new thesis
        Thesis aiThesis = new ThesisBuilder()
                .setTitle("AI in Healthcare")
                .setAdvisor(drJones)
                .setSummary("Explores the impact of AI on diagnostics and patient outcomes.")
                .addKeywords(List.of("AI", "Healthcare", "Machine Learning"))
                .build();

        dana.setThesis(aiThesis);
        System.out.println("\n-- Thesis Created Using Builder Pattern --");
        System.out.println(aiThesis);

    }

    public static void runStructuralPattern() {
        System.out.println("\n=== STRUCTURAL PATTERNS: COMPOSITE & DECORATOR ===");

        // Decorator
        Course java = new Course("CS501", "Java", "Intro to Java", null, 20);
        Course ai = new Course("CS601", "AI", "Intro to AI", null, 20);

        CourseFormat decoratedJava = new CapstoneCourseDecorator(new LabRequiredDecorator(new BaseCourseFormat(java)));
        CourseFormat decoratedAI = new CapstoneCourseDecorator(new BaseCourseFormat(ai));

        System.out.println("\n--- Decorated Course Output ---");
        System.out.println(decoratedJava.format());
        System.out.println(decoratedAI.format());

        // Composite
        Course ml = new Course("CS602", "ML", "Machine Learning", null, 20);
        Course python = new Course("CS502", "Python", "Intro to Python", null, 20);

        Concentration mlTrack = new Concentration("Machine Learning Track");
        mlTrack.addComponent(new SingleCourse(ml));
        mlTrack.addComponent(new SingleCourse(ai));

        Concentration dataSci = new Concentration("Data Science");
        dataSci.addComponent(mlTrack);
        dataSci.addComponent(new SingleCourse(python));

        System.out.println("\n--- Composite Concentration Output ---");
        System.out.println(dataSci.format());
    }

    public static void runBehavioralPattern() {
        System.out.println("\n=== BEHAVIORAL PATTERNS: OBSERVER, STRATEGY, INTERACTION ===");

        Semester spring2025 = new Semester("Spring 2025");
        Department dept = Department.getInstance();

        // Faculty + Observer setup
        Chairperson chair = Chairperson.getInstance("C1", "Dr. Smith");
        FullTimeFaculty drJones = new FullTimeFaculty("F1", "Dr. Jones");
        Faculty drWhite = new PartTimeFaculty("F2", "Dr. White");

        Course java = new Course("CS501", "Java", "Intro to Java", drJones, 1);
        Course ai = new Course("CS601", "AI", "Intro to AI", drWhite, 1);
        Course ml = new Course("CS602", "ML", "Machine Learning", drWhite, 1);

        java.registerObserver(chair);
        ai.registerObserver(chair);

        // Students
        ProgramFactory bachelorFactory = new BachelorProgramFactory();
        Program bsCS = bachelorFactory.createProgram("B.S. CS", List.of(java), List.of(ai, ml));

        Student alice = new Student("S1", "Alice", bsCS);
        Student bob = new Student("S2", "Bob", bsCS);
        Student dana = new Student("S3", "Dana", bsCS);

        // Enroll + Observer + Waitlist
        java.enroll(alice);      // Enrolled
        java.enroll(bob);        // Waitlisted
        java.drop(alice);        // Bob auto-enrolled

        ai.enroll(dana);
        ai.enroll(alice);        // Waitlisted

        // GPA (Strategy Pattern)
        Map<Course, String> grades = Map.of(java, "A", ai, "B");

        alice.setGpaStrategy(new StandardGpa());
        System.out.printf("\nAlice Standard GPA: %.2f\n", alice.calculateGpa(grades));

        alice.setGpaStrategy(new PassFailGpa());
        System.out.printf("Alice Pass/Fail GPA: %.2f\n", alice.calculateGpa(grades));

        // Thesis + Advisor
        alice.setThesis(new Thesis("AI in Education", drJones));
        System.out.println("\nAlice Thesis: " + alice.getThesis());

        // Student-Faculty Interaction
        System.out.println("\n--- Student Queries ---");
        drJones.receiveQuery(alice.getName(), "Can I review my thesis draft?");
        chair.receiveQuery(bob.getName(), "Can I change advisors?");
    }

    public static void runAll() {
        runCreationalPattern();
        runStructuralPattern();
        runBehavioralPattern();
    }
}
