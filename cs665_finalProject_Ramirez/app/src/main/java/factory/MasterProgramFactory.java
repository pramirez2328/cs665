package factory;

import model.course.Course;
import model.program.MasterProgram;
import model.program.Program;

import java.util.List;

public class MasterProgramFactory implements ProgramFactory {
    @Override
    public Program createProgram(String name, List<Course> coreCourses, List<Course> electives) {
        return new MasterProgram(name, coreCourses, electives);
    }
}
