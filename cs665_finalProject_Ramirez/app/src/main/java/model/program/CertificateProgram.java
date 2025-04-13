package model.program;

import model.course.Course;

import java.util.List;

public class CertificateProgram extends Program {

    public CertificateProgram(String name, List<Course> coreCourses, List<Course> electives) {
        super(name, coreCourses, electives);
    }

    @Override
    public String format() {
        return "<h2>" + getName() + "</h2><p>Type: Certificate Program</p>";
    }

    @Override
    public boolean requiresThesis() {
        return false;
    }
}
