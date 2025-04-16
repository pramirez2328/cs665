package app.creational.builder;

import app.model.common.Thesis;
import app.model.users.Faculty;

import java.util.ArrayList;
import java.util.List;

/**
 * CREATIONAL DESIGN PATTERN — Builder
 * This class implements the Builder Pattern for constructing Thesis objects step-by-step.
 * It allows optional fields to be set without complex constructors or telescoping parameters.
 */

public class ThesisBuilder {
    private String title;
    private Faculty advisor;
    private String summary;
    private List<String> keywords = new ArrayList<>();

    public ThesisBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public ThesisBuilder setAdvisor(Faculty advisor) {
        this.advisor = advisor;
        return this;
    }

    public ThesisBuilder setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public ThesisBuilder addKeyword(String keyword) {
        this.keywords.add(keyword);
        return this;
    }

    public ThesisBuilder addKeywords(List<String> keywords) {
        this.keywords.addAll(keywords);
        return this;
    }

    public Thesis build() {
        Thesis thesis = new Thesis(title, advisor);
        thesis.setSummary(summary);
        thesis.setKeywords(keywords);
        return thesis;
    }
}

