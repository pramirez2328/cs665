package model.course;

public class SingleCourse implements CourseComponent {
    private Course course;

    public SingleCourse(Course course) {
        this.course = course;
    }

    @Override
    public String format() {
        return course.format();
    }

    @Override
    public String toString() {
        return course.getTitle();
    }
}

