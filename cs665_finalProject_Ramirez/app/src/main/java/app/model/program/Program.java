package app.model.program;

import app.model.course.Course;

import java.util.List;

public abstract class Program {
    protected String name;
    protected List<Course> coreCourses;
    protected List<Course> electives;

    public abstract String format();

    public Program(String name, List<Course> coreCourses, List<Course> electives) {
        this.name = name;
        this.coreCourses = coreCourses;
        this.electives = electives;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCoreCourses() {
        return coreCourses;
    }

    public List<Course> getElectives() {
        return electives;
    }

    public abstract boolean requiresThesis();

    @Override
    public String toString() {
        return format();
    }
}
