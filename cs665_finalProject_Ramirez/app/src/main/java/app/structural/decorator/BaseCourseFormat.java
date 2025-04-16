package app.structural.decorator;

import app.model.course.Course;

/**
 * BaseCourseFormat is the concrete component in the Decorator pattern.
 * It wraps a Course object and provides the default formatting behavior.
 */
public class BaseCourseFormat implements CourseFormat {
    private Course course;

    public BaseCourseFormat(Course course) {
        this.course = course;
    }

    @Override
    public String format() {
        // Delegates formatting to the Course's built-in format method
        return course.format();
    }
}
