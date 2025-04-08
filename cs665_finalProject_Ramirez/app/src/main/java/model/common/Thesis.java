package model.common;

import model.users.Faculty;

public class Thesis {
    private String title;
    private Faculty advisor;

    public Thesis(String title, Faculty advisor) {
        this.title = title;
        this.advisor = advisor;
    }

    public String getTitle() {
        return title;
    }

    public Faculty getAdvisor() {
        return advisor;
    }

    @Override
    public String toString() {
        return "Thesis: " + title + " (Advisor: " + advisor.getName() + ")";
    }
}
