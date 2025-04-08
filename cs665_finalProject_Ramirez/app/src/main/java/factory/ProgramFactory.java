package factory;

import model.program.Program;
import java.util.List;
import model.course.Course;

public interface ProgramFactory {
    Program createProgram(String name, List<Course> coreCourses, List<Course> electives);
}
