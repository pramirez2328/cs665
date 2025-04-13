/**
 * CREATIONAL DESIGN PATTERN — Singleton
 * <p>
 * Chairperson is implemented as a Singleton to ensure only one instance exists within the system.
 * The Chairperson can teach one course per semester, receives observer notifications,
 * and coordinates top-level concentrations.
 */

package creational;

import behavioral.Observer;
import model.course.Concentration;
import model.users.Faculty;

import java.util.ArrayList;
import java.util.List;

public class Chairperson extends Faculty implements Observer {

    private static Chairperson instance; // Singleton instance
    private final List<Concentration> topLevelConcentrations = new ArrayList<>();

    // Private constructor prevents external instantiation
    private Chairperson(String id, String name) {
        super(id, name);
    }

    // Static method to return the single instance
    public static Chairperson getInstance(String id, String name) {
        if (instance == null) {
            instance = new Chairperson(id, name);
        }
        return instance;
    }

    @Override
    public int getMaxCoursesPerSemester() {
        return 1;
    }

    @Override
    public void update(String message) {
        System.out.println("Chairperson Notification: " + message);
    }

    @Override
    public String toString() {
        return "Chairperson: " + name;
    }

    @Override
    public void receiveQuery(String studentName, String question) {
        System.out.printf("📬 Chairperson %s received query from %s: \"%s\"\n", name, studentName, question);
    }

    public void addConcentration(Concentration concentration) {
        topLevelConcentrations.add(concentration);
        System.out.println("\n✅ Chairperson added top-level concentration: " + concentration.getName());
    }
}
