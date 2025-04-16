package app.model.common;

import app.model.course.Course;
import app.model.users.Student;

import java.util.*;

public class Department {
    private static Department instance;
    private Map<Semester, List<Course>> coursesBySemester = new HashMap<>();
    private Map<Course, Map<Semester, List<Student>>> enrollments = new HashMap<>();

    private Department() {
    }

    public static Department getInstance() {
        if (instance == null) {
            instance = new Department();
        }
        return instance;
    }

    public void offerCourse(Semester semester, Course course) {
        coursesBySemester.putIfAbsent(semester, new ArrayList<>());
        coursesBySemester.get(semester).add(course);
    }

    public List<Course> getCoursesOffered(Semester semester) {
        return coursesBySemester.getOrDefault(semester, Collections.emptyList());
    }

    public void enrollStudent(Semester semester, Course course, Student student) {
        enrollments.putIfAbsent(course, new HashMap<>());
        enrollments.get(course).putIfAbsent(semester, new ArrayList<>());
        enrollments.get(course).get(semester).add(student);
    }

    public List<Student> getEnrolledStudents(Course course, Semester semester) {
        return enrollments.getOrDefault(course, new HashMap<>())
                .getOrDefault(semester, Collections.emptyList());
    }
}
