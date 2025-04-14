package structural.decorator;

/**
 * Component interface in the Decorator Pattern.
 * Defines a method for formatting course output (e.g., as HTML).
 * Both the base formatter and decorators implement this interface.
 */
public interface CourseFormat {
    /**
     * Returns an HTML-formatted representation of the course.
     */
    String format();
}
