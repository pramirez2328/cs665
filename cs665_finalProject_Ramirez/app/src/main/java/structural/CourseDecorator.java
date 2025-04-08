package structural;

public abstract class CourseDecorator implements CourseFormat {
    protected CourseFormat decoratedCourse;

    public CourseDecorator(CourseFormat decoratedCourse) {
        this.decoratedCourse = decoratedCourse;
    }

    @Override
    public String format() {
        return decoratedCourse.format();
    }
}
