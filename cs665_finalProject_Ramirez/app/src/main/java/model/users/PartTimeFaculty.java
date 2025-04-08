package model.users;

public class PartTimeFaculty extends Faculty {
    public PartTimeFaculty(String id, String name) {
        super(id, name);
    }

    @Override
    public int getMaxCoursesPerSemester() {
        return 1;
    }

    @Override
    public String toString() {
        return "Part-Time Faculty: " + name;
    }
}
