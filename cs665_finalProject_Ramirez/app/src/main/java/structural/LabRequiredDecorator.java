
package structural;

public class LabRequiredDecorator extends CourseDecorator {

    public LabRequiredDecorator(CourseFormat decoratedCourse) {
        super(decoratedCourse);
    }

    @Override
    public String format() {
        return decoratedCourse.format() + "<p><em>[Lab Required]</em></p>";
    }
}
