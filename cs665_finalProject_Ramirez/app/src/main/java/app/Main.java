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
        // 1. Create a Chairperson (Singleton)
        Chairperson chair = Chairperson.getInstance("C1", "Dr. Smith");

        // 2. Create faculty
        Faculty drJones = new FullTimeFaculty("F1", "Dr. Jones");

        // 3. Create courses
        Course java = new Course("CS501", "Java", "Intro to Java", drJones, 1);
        Course python = new Course("CS502", "Python", "Intro to Python", drJones, 2);

        // Register observer (Observer Pattern)
        java.registerObserver(chair);

        // 4. Decorate course (Decorator Pattern)
        CourseFormat decoratedJava = new CapstoneCourseDecorator(new LabRequiredDecorator(new BaseCourseFormat(java)));
        System.out.println("\n--- Decorated Course Output ---");
        System.out.println(decoratedJava.format());

        // 5. Create concentrations (Composite Pattern)
        Concentration progLang = new Concentration("Programming Languages");
        Concentration oop = new Concentration("Object-Oriented Languages");

        oop.addComponent(new SingleCourse(java));
        progLang.addComponent(oop);
        progLang.addComponent(new SingleCourse(python));

        System.out.println("\n--- Composite Concentration Output ---");
        System.out.println(progLang.format());

        // 6. Create program using Factory Pattern
        ProgramFactory factory = new BachelorProgramFactory();
        Program bsCS = factory.createProgram("B.S. Computer Science", List.of(java), List.of(python));

        // 7. Create students
        Student alice = new Student("S1", "Alice", bsCS);
        Student bob = new Student("S2", "Bob", bsCS);
        Student charlie = new Student("S3", "Charlie", bsCS);

        // 8. Enroll Alice in Java (OK)
        java.enroll(alice);

        // 9. Enroll Bob in Java (Triggers observer: course full)
        java.enroll(bob);

        // 10. Drop Alice (Charlie should be auto-enrolled from waitlist)
        java.drop(alice);

        // 11. GPA Calculation (Strategy Pattern)
        Map<Course, String> grades = new HashMap<>();
        grades.put(java, "A");
        grades.put(python, "B");

        // Standard GPA
        alice.setGpaStrategy(new StandardGpa());
        System.out.println("\nAlice Standard GPA: " + alice.calculateGpa(grades));

        // Pass/Fail GPA
        alice.setGpaStrategy(new PassFailGpa());
        System.out.println("Alice Pass/Fail GPA: " + alice.calculateGpa(grades));

        // 12. Assign thesis
        alice.setThesis(new Thesis("AI in Education", drJones));
        System.out.println("\nAlice Thesis: " + alice.getThesis());

        // 13. Print student info
        System.out.println("\n--- Student Summary ---");
        System.out.println(alice);
        System.out.println("Program: " + alice.getProgram().format());
    }
}
