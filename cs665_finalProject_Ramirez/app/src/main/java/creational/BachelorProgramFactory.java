/**
 * CREATIONAL DESIGN PATTERN — Factory Method
 * <p>
 * This class is a concrete factory for creating Bachelor-level academic programs.
 * It encapsulates the instantiation logic, demonstrating the Factory Method pattern.
 */

package creational;

import model.course.Course;
import model.program.BachelorProgram;
import model.program.Program;

import java.util.List;

public class BachelorProgramFactory implements ProgramFactory {

    // Creates a new BachelorProgram with provided core and elective courses
    @Override
    public Program createProgram(String name, List<Course> coreCourses, List<Course> electives) {
        return new BachelorProgram(name, coreCourses, electives);
    }
}
