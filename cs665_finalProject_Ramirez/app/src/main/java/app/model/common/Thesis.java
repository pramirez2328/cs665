package app.model.common;

import app.model.users.Faculty;

import java.util.ArrayList;
import java.util.List;

public class Thesis {
    private final String title;
    private final Faculty advisor;
    private String summary;
    private List<String> keywords = new ArrayList<>();

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

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "Thesis: " + title + " (Advisor: " + advisor.getName() + ")" +
                (summary != null ? "\n  Summary: " + summary : "") +
                (!keywords.isEmpty() ? "\n  Keywords: " + String.join(", ", keywords) : "");
    }
}
