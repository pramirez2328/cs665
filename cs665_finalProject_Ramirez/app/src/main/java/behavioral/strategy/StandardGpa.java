package behavioral.strategy;

import model.course.Course;

import java.util.Map;

/**
 * StandardGpa implements GpaStrategy using traditional grade points.
 * Grade Mapping:
 * A = 4, B = 3, C = 2, D = 1, F/other = 0
 * Each course is assumed to be 4 credits.
 */
public class StandardGpa implements GpaStrategy {

    /**
     * Calculates GPA using weighted grade points based on a 4-point scale.
     *
     * @param grades a map of courses and the letter grade earned
     * @return GPA as a decimal
     */
    @Override
    public double calculate(Map<Course, String> grades) {
        int totalPoints = 0;
        int totalCredits = 0;

        for (Map.Entry<Course, String> entry : grades.entrySet()) {
            int points = switch (entry.getValue().toUpperCase()) {
                case "A" -> 4;
                case "B" -> 3;
                case "C" -> 2;
                case "D" -> 1;
                default -> 0; // F or unrecognized grade
            };
            totalPoints += points * 4; // Each course is worth 4 credits
            totalCredits += 4;
        }

        return totalCredits == 0 ? 0.0 : (double) totalPoints / totalCredits;
    }
}
