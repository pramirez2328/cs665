package model.users;

import behavioral.Observer;

public class Chairperson extends Faculty implements Observer {

    private static Chairperson instance;

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
}
