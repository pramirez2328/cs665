/**
 * CREATIONAL DESIGN PATTERN — Factory Method
 * <p>
 * This concrete factory creates Master-level academic programs.
 * Demonstrates the Factory Method pattern by encapsulating object creation logic
 * for programs that typically include a thesis requirement.
 */

package app.creational.factory;

import app.model.course.Course;
import app.model.program.MasterProgram;
import app.model.program.Program;

import java.util.List;

public class MasterProgramFactory implements ProgramFactory {

    // Produces a MasterProgram with core and elective courses
    @Override
    public Program createProgram(String name, List<Course> coreCourses, List<Course> electives) {
        return new MasterProgram(name, coreCourses, electives);
    }
}
