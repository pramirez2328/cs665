package behavioral;

import model.course.Course;

import java.util.Map;

public class PassFailGpa implements GpaStrategy {

    @Override
    public double calculate(Map<Course, String> grades) {
        int passed = 0;
        int total = grades.size();

        for (String grade : grades.values()) {
            if (grade.equalsIgnoreCase("A") ||
                    grade.equalsIgnoreCase("B") ||
                    grade.equalsIgnoreCase("C"))
                passed++;
        }

        return total == 0 ? 0.0 : (double) passed / total;
    }
}
