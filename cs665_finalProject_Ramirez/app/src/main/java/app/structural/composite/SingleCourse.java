package app.structural.composite;

import app.model.course.Course;

/**
 * Leaf class in the Composite Design Pattern.
 * Represents a single course that implements CourseComponent.
 */
public class SingleCourse implements CourseComponent {

    private final Course course;

    /**
     * Constructs a wrapper around a single Course.
     *
     * @param course The course to represent as a leaf
     */
    public SingleCourse(Course course) {
        this.course = course;
    }

    /**
     * Delegates formatting to the underlying Course object.
     *
     * @return HTML-formatted string for the course
     */
    @Override
    public String format() {
        return course.format();
    }

    @Override
    public String toString() {
        return course.getTitle();
    }
}

