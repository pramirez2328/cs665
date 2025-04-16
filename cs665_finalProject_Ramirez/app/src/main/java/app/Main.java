package app;

import app.behavioral.strategy.strategy.PassFailGpa;
import app.behavioral.strategy.strategy.StandardGpa;
import app.creational.builder.ThesisBuilder;
import app.creational.factory.BachelorProgramFactory;
import app.creational.factory.CertificateProgramFactory;
import app.creational.factory.MasterProgramFactory;
import app.creational.factory.ProgramFactory;
import app.creational.singleton.Chairperson;
import app.model.common.Department;
import app.model.common.Semester;
import app.model.common.Thesis;
import app.model.course.Course;
import app.model.program.Program;
import app.model.users.Faculty;
import app.model.users.FullTimeFaculty;
import app.model.users.PartTimeFaculty;
import app.model.users.Student;
import app.structural.composite.Concentration;
import app.structural.composite.SingleCourse;
import app.structural.decorator.BaseCourseFormat;
import app.structural.decorator.CapstoneCourseDecorator;
import app.structural.decorator.CourseFormat;
import app.structural.decorator.LabRequiredDecorator;

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

        // --- DECORATOR PATTERN ---
        System.out.println("\n--- Decorator Pattern: Enhanced Course Formatting ---");

        Course java = new Course("CS501", "Java", "Intro to Java", null, 20);
        Course ai = new Course("CS601", "AI", "Intro to AI", null, 20);

        CourseFormat baseJava = new BaseCourseFormat(java);
        System.out.println("\nBase Java Course Format:");
        System.out.println(baseJava.format());

        CourseFormat labJava = new LabRequiredDecorator(baseJava);
        System.out.println("\nJava with Lab Decorator:");
        System.out.println(labJava.format());

        CourseFormat capstoneJava = new CapstoneCourseDecorator(labJava);
        System.out.println("\nJava with Lab + Capstone Decorators:");
        System.out.println(capstoneJava.format());

        CourseFormat decoratedAI = new CapstoneCourseDecorator(new BaseCourseFormat(ai));
        System.out.println("\nAI Course with Capstone Decorator:");
        System.out.println(decoratedAI.format());

        // --- COMPOSITE PATTERN ---
        System.out.println("\n--- Composite Pattern: Concentrations with Sub-Concentrations ---");

        Course ml = new Course("CS602", "ML", "Machine Learning", null, 20);
        Course python = new Course("CS502", "Python", "Intro to Python", null, 20);

        SingleCourse mlCourse = new SingleCourse(ml);
        SingleCourse aiCourse = new SingleCourse(ai);
        SingleCourse pythonCourse = new SingleCourse(python);

        Concentration mlTrack = new Concentration("Machine Learning Track");
        mlTrack.addComponent(mlCourse);
        mlTrack.addComponent(aiCourse);
        System.out.println("\nMachine Learning Sub-Concentration:");
        System.out.println(mlTrack.format());

        Concentration dataSci = new Concentration("Data Science");
        dataSci.addComponent(mlTrack);
        dataSci.addComponent(pythonCourse);

        System.out.println("\nFull Data Science Concentration:");
        System.out.println(dataSci.format());
    }


    public static void runBehavioralPattern() {
        System.out.println("\n=== BEHAVIORAL PATTERNS: OBSERVER & STRATEGY ===");

        System.out.println("\n--- Department Setup ---");
        Semester spring2025 = new Semester("Spring 2025");
        Department dept = Department.getInstance();
        System.out.println("✅ Department initialized");
        System.out.println("✅ Semester created: " + spring2025.getName());

        // -- Observer Pattern Setup --
        System.out.println("\n--- Observer Pattern: Enrollment Notifications ---");

        Chairperson chair = Chairperson.getInstance("C1", "Dr. Smith");
        System.out.println("✅ Chairperson instance: " + chair.getName());

        FullTimeFaculty drJones = new FullTimeFaculty("F1", "Dr. Jones");
        Faculty drWhite = new PartTimeFaculty("F2", "Dr. White");
        System.out.println("✅ Faculty created: " + drJones.getName() + " (Full-Time)");
        System.out.println("✅ Faculty created: " + drWhite.getName() + " (Part-Time)");

        Course java = new Course("CS501", "Java", "Intro to Java", drJones, 1);
        Course ai = new Course("CS601", "AI", "Intro to AI", drWhite, 1);
        System.out.println("✅ Course created: Java (Instructor: " + drJones.getName() + ")");
        System.out.println("✅ Course created: AI (Instructor: " + drWhite.getName() + ")");

        // Register Chairperson as observer
        java.registerObserver(chair);
        ai.registerObserver(chair);
        System.out.println("🔔 Chairperson registered as observer for Java & AI");

        // Create program and students
        ProgramFactory bachelorFactory = new BachelorProgramFactory();
        Program bsCS = bachelorFactory.createProgram("B.S. CS", List.of(java), List.of(ai));
        System.out.println("✅ Bachelor Program created: B.S. CS");

        System.out.println("\n--- Student Enrollments ---");
        Student alice = new Student("S1", "Alice", bsCS);
        Student bob = new Student("S2", "Bob", bsCS);
        Student dana = new Student("S3", "Dana", bsCS);
        System.out.println("✅ Students created: Alice, Bob, Dana");

        System.out.println("📘 Alice enrolling in Java...");
        java.enroll(alice); // OK

        System.out.println("📘 Bob enrolling in Java (should trigger waitlist & notification)...");
        java.enroll(bob);   // Triggers observer

        System.out.println("📘 Alice dropping Java (Bob should be auto-enrolled)...");
        java.drop(alice);   // Bob auto-enrolled

        System.out.println("📘 Dana enrolling in AI...");
        ai.enroll(dana);    // OK

        System.out.println("📘 Alice enrolling in AI (should trigger waitlist & notification)...");
        ai.enroll(alice);   // Triggers observer

        // Grades setup
        Map<Course, String> grades = Map.of(
                java, "A",
                ai, "B"
        );

        System.out.println("\n------------------------------------------");

        // -- Strategy Pattern Setup --
        System.out.println("\n--- Strategy Pattern: GPA Calculation ---");

        System.out.println("📊 Calculating GPA using StandardGpa strategy...");
        alice.setGpaStrategy(new StandardGpa());
        System.out.printf("✔️ Alice Standard GPA: %.2f\n", alice.calculateGpa(grades));

        System.out.println("📊 Switching to PassFailGpa strategy...");
        alice.setGpaStrategy(new PassFailGpa());
        System.out.printf("✔️ Alice Pass/Fail GPA: %.2f\n", alice.calculateGpa(grades));

        // -- Advisor Interaction --
        System.out.println("\n--- Student Queries ---");

        alice.setThesis(new Thesis("AI in Education", drJones));
        System.out.println("🧠 Alice Thesis assigned: " + alice.getThesis());

        System.out.println("📩 Alice sends a query to Dr. Jones...");
        drJones.receiveQuery(alice.getName(), "Can I review my thesis draft?");

        System.out.println("📩 Bob sends a query to Chairperson...");
        chair.receiveQuery(bob.getName(), "Can I change advisors?");
    }


    public static void runAll() {
        runCreationalPattern();
        runStructuralPattern();
        runBehavioralPattern();
    }
}
