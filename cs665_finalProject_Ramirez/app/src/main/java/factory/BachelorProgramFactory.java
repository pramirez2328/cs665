package factory;

import model.course.Course;
import model.program.BachelorProgram;
import model.program.Program;

import java.util.List;

public class BachelorProgramFactory implements ProgramFactory {
    @Override
    public Program createProgram(String name, List<Course> coreCourses, List<Course> electives) {
        return new BachelorProgram(name, coreCourses, electives);
    }
}
