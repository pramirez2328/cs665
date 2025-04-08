package model.users;

public class FullTimeFaculty extends Faculty {
    public FullTimeFaculty(String id, String name) {
        super(id, name);
    }

    @Override
    public int getMaxCoursesPerSemester() {
        return 3;
    }

    @Override
    public String toString() {
        return "Full-Time Faculty: " + name;
    }
}
