package structural.decorator;

/**
 * CapstoneCourseDecorator adds "[Capstone Course]" label to a course.
 * It extends CourseDecorator and appends capstone-specific formatting.
 */
public class CapstoneCourseDecorator extends CourseDecorator {

    public CapstoneCourseDecorator(CourseFormat decoratedCourse) {
        super(decoratedCourse);
    }

    @Override
    public String format() {
        // Adds capstone marker to the original course format
        return decoratedCourse.format() + "<p><strong>[Capstone Course]</strong></p>";
    }
}
