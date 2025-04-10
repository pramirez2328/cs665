package model.users;

import model.course.Course;

import java.util.ArrayList;
import java.util.List;

public abstract class Faculty {
    protected String id;
    protected String name;
    protected List<Course> coursesTaught;

    public Faculty(String id, String name) {
        this.id = id;
        this.name = name;
        this.coursesTaught = new ArrayList<>();
    }

    public void assignCourse(Course course) {
        coursesTaught.add(course);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public List<Course> getCoursesTaught() {
        return coursesTaught;
    }

    public void receiveQuery(String studentName, String question) {
        System.out.printf("📬 Faculty %s received query from %s: \"%s\"\n", name, studentName, question);
    }
    
    public abstract int getMaxCoursesPerSemester();
}
