package app.model.program;

import app.model.course.Course;

import java.util.List;

public class MasterProgram extends Program {
    public MasterProgram(String name, List<Course> core, List<Course> electives) {
        super(name, core, electives);
    }

    @Override
    public boolean requiresThesis() {
        return true; // as per project description
    }

    @Override
    public String format() {
        return "<h2>" + name + "</h2><p>Degree: Master's</p>";
    }

}
