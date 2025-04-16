package app.behavioral.strategy.strategy;

import app.model.course.Course;

import java.util.Map;

/**
 * GpaStrategy is the Strategy interface for the GPA calculation logic.
 * Different implementations can provide alternative GPA policies,
 * such as traditional grade-point calculation or pass/fail evaluation.
 */
public interface GpaStrategy {

    /**
     * Calculates the GPA based on a map of courses and letter grades.
     *
     * @param grades a map where the key is a Course and the value is the letter grade (e.g., "A", "B")
     * @return calculated GPA as a decimal value
     */
    double calculate(Map<Course, String> grades);
}
