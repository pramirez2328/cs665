/**
 * CREATIONAL DESIGN PATTERN — Factory Method (Interface)
 * <p>
 * This interface defines the factory method for creating academic programs.
 * It enables clients to create different types of programs (Bachelor, Master, Certificate)
 * without coupling them to specific implementation classes.
 */

package app.creational.factory;

import app.model.course.Course;
import app.model.program.Program;

import java.util.List;

public interface ProgramFactory {
    Program createProgram(String name, List<Course> coreCourses, List<Course> electives);
}
