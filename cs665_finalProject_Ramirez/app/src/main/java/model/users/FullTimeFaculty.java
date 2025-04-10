package model.users;

public class FullTimeFaculty extends Faculty {
    private static FullTimeFaculty gradAdvisor;
    private static FullTimeFaculty undergradAdvisor;

    public FullTimeFaculty(String id, String name) {
        super(id, name);
    }

    public static void assignGraduateAdvisor(FullTimeFaculty faculty) {
        if (gradAdvisor == null) {
            gradAdvisor = faculty;
            System.out.println("✅ " + faculty.getName() + " assigned as Graduate Advisor.");
        } else {
            System.out.println("❌ Graduate Advisor already assigned: " + gradAdvisor.getName());
        }
    }

    public static void assignUndergraduateAdvisor(FullTimeFaculty faculty) {
        if (undergradAdvisor == null) {
            undergradAdvisor = faculty;
            System.out.println("✅ " + faculty.getName() + " assigned as Undergraduate Advisor.");
        } else {
            System.out.println("❌ Undergraduate Advisor already assigned: " + undergradAdvisor.getName());
        }
    }

    public static FullTimeFaculty getGraduateAdvisor() {
        return gradAdvisor;
    }

    public static FullTimeFaculty getUndergraduateAdvisor() {
        return undergradAdvisor;
    }

    @Override
    public int getMaxCoursesPerSemester() {
        return 3;
    }
}
