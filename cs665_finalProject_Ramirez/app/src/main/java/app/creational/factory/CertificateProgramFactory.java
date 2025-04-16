/**
 * CREATIONAL DESIGN PATTERN — Factory Method
 * <p>
 * This class implements the Factory Method to create Certificate-level programs.
 * It encapsulates the creation logic for lightweight, non-thesis programs.
 */

package app.creational.factory;

import app.model.course.Course;
import app.model.program.CertificateProgram;
import app.model.program.Program;

import java.util.List;

public class CertificateProgramFactory implements ProgramFactory {

    // Creates a CertificateProgram with the specified core courses
    @Override
    public Program createProgram(String name, List<Course> coreCourses, List<Course> electives) {
        return new CertificateProgram(name, coreCourses, electives);
    }
}
