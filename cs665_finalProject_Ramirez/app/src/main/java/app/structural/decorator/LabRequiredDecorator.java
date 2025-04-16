package app.structural.decorator;

/**
 * LabRequiredDecorator adds a "[Lab Required]" label to the course format.
 * This class extends CourseDecorator to enhance the base formatting behavior.
 */
public class LabRequiredDecorator extends CourseDecorator {

    public LabRequiredDecorator(CourseFormat decoratedCourse) {
        super(decoratedCourse);
    }

    @Override
    public String format() {
        // Appends lab requirement info to the existing course format
        return decoratedCourse.format() + "<p><em>[Lab Required]</em></p>";
    }
}
