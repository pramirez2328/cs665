package structural;

public class CapstoneCourseDecorator extends CourseDecorator {

    public CapstoneCourseDecorator(CourseFormat decoratedCourse) {
        super(decoratedCourse);
    }

    @Override
    public String format() {
        return decoratedCourse.format() + "<p><strong>[Capstone Course]</strong></p>";
    }
}
