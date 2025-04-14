package structural.decorator;

/**
 * Abstract base class for all course decorators.
 * Implements CourseFormat and holds a reference to another CourseFormat.
 * Allows subclasses to enhance or modify formatting behavior.
 */
public abstract class CourseDecorator implements CourseFormat {
    protected CourseFormat decoratedCourse;

    public CourseDecorator(CourseFormat decoratedCourse) {
        this.decoratedCourse = decoratedCourse;
    }

    @Override
    public String format() {
        // Delegates formatting to the wrapped component
        return decoratedCourse.format();
    }
}
