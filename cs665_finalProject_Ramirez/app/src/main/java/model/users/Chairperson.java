package model.users;

import behavioral.Observer;
import model.course.Concentration;

import java.util.ArrayList;
import java.util.List;

public class Chairperson extends Faculty implements Observer {

    private static Chairperson instance;
    private List<Concentration> topLevelConcentrations = new ArrayList<>();

    private Chairperson(String id, String name) {
        super(id, name);
    }

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
