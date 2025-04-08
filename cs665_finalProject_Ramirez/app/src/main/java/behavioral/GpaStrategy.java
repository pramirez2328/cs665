package behavioral;

import model.course.Course;

import java.util.Map;

public interface GpaStrategy {
    double calculate(Map<Course, String> grades);
}

