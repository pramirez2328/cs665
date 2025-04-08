package structural;

import model.course.Course;

public class BaseCourseFormat implements CourseFormat {
    private Course course;

    public BaseCourseFormat(Course course) {
        this.course = course;
    }

    @Override
    public String format() {
        return course.format(); // Reuse existing method
    }
}
