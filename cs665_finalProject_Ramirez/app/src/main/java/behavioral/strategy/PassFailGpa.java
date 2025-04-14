package behavioral.strategy;

import model.course.Course;

import java.util.Map;

/**
 * PassFailGpa implements GpaStrategy for a simple pass/fail system.
 * <p>
 * Grades A, B, and C are considered passing.
 * Grades D and F are considered failing.
 * <p>
 * The GPA is represented as a decimal: number of passed courses / total courses.
 */
public class PassFailGpa implements GpaStrategy {

    /**
     * Calculates pass/fail GPA as a ratio of passed courses to total courses.
     *
     * @param grades a map of courses and the letter grade earned
     * @return decimal value between 0.0 and 1.0 representing pass rate
     */
    @Override
    public double calculate(Map<Course, String> grades) {
        int passed = 0;
        int total = grades.size();

        for (String grade : grades.values()) {
            if (grade.equalsIgnoreCase("A") ||
                    grade.equalsIgnoreCase("B") ||
                    grade.equalsIgnoreCase("C")) {
                passed++;
            }
        }

        return total == 0 ? 0.0 : (double) passed / total;
    }
}

