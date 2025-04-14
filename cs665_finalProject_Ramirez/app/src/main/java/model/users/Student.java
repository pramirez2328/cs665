package model.users;

import behavioral.strategy.StandardGpa;
import behavioral.strategy.GpaStrategy;
import model.common.Semester;
import model.common.Thesis;
import model.course.Course;
import model.program.Program;

import java.util.*;

public class Student {
    private String id;
    private String name;
    private Program program;
    private Map<Semester, List<Course>> enrolledCourses = new HashMap<>();
    private Thesis thesis;
    private GpaStrategy gpaStrategy = new StandardGpa(); // default


    public Student(String id, String name, Program program) {
        this.id = id;
        this.name = name;
        this.program = program;
    }

    public void enrollInCourse(Semester semester, Course course) {
        enrolledCourses.putIfAbsent(semester, new ArrayList<>());
        enrolledCourses.get(semester).add(course);
    }

    public void dropCourse(Semester semester, Course course) {
        if (enrolledCourses.containsKey(semester)) {
            enrolledCourses.get(semester).remove(course);
        }
    }

    public double calculateGpa(Map<Course, String> grades) {
        return gpaStrategy.calculate(grades);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Program getProgram() {
        return program;
    }

    public Thesis getThesis() {
        return thesis;
    }

    public void setThesis(Thesis thesis) {
        this.thesis = thesis;
    }

    public Map<Semester, List<Course>> getEnrolledCourses() {
        return enrolledCourses;
    }

    @Override
    public String toString() {
        return "Student: " + name + " (ID: " + id + ")";
    }

    public void setGpaStrategy(GpaStrategy strategy) {
        if (strategy != null) {
            this.gpaStrategy = strategy;
        }
    }


}
