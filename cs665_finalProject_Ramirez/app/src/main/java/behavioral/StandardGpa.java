package behavioral;

import model.course.Course;

import java.util.Map;

public class StandardGpa implements GpaStrategy {

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
                default -> 0; // F or unrecognized
            };
            totalPoints += points * 4; // Each course = 4 credits
            totalCredits += 4;
        }

        return totalCredits == 0 ? 0.0 : (double) totalPoints / totalCredits;
    }
}

