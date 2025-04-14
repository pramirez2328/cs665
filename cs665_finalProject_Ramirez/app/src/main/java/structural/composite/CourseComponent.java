package structural.composite;

/**
 * Component interface in the Composite Design Pattern.
 * Both individual courses (leaves) and concentrations (composites)
 * implement this interface, allowing uniform treatment.
 */
public interface CourseComponent {
    /**
     * Formats the course or concentration into an HTML string.
     *
     * @return HTML representation of the component
     */
    String format();
}
