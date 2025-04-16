package app.model.course;

import app.model.users.Faculty;
import app.model.users.Student;
import app.behavioral.observer.Observer;
import app.behavioral.observer.Subject;


import java.util.*;

public class Course implements Subject {

    private String code;
    private String title;
    private String description;
    private Faculty instructor;
    private int enrollmentLimit;
    private List<Student> enrolledStudents = new ArrayList<>();
    private Queue<Student> waitlist = new LinkedList<>();
    private List<Observer> observers = new ArrayList<>();

    public Course(String code, String title, String description, Faculty instructor, int enrollmentLimit) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.instructor = instructor;
        this.enrollmentLimit = enrollmentLimit;
    }

    public boolean enroll(Student student) {
        if (enrolledStudents.size() < enrollmentLimit) {
            enrolledStudents.add(student);
            return true;
        } else {
            waitlist.add(student);
            notifyObservers("Enrollment limit reached for course: " + title);
            return false;
        }
    }

    public void drop(Student student) {
        if (enrolledStudents.remove(student)) {
            if (!waitlist.isEmpty()) {
                Student next = waitlist.poll();
                enrolledStudents.add(next);
                System.out.println("Auto-enrolled from waitlist: " + next.getName() + " for course: " + title);

            }
        } else {
            waitlist.remove(student);
        }
    }

    public String format() {
        return "<h1>" + title + "</h1><p>" + description + "</p>";
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public Faculty getInstructor() {
        return instructor;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public Queue<Student> getWaitlist() {
        return waitlist;
    }

    @Override
    public String toString() {
        return "[" + code + "] " + title;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

}
