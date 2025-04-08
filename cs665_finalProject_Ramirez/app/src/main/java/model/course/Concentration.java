package model.course;

import java.util.ArrayList;
import java.util.List;

public class Concentration implements CourseComponent {
    private String name;
    private List<CourseComponent> components = new ArrayList<>();

    public Concentration(String name) {
        this.name = name;
    }

    public void addComponent(CourseComponent component) {
        components.add(component);
    }

    public void removeComponent(CourseComponent component) {
        components.remove(component);
    }

    @Override
    public String format() {
        StringBuilder sb = new StringBuilder();
        sb.append("<h2>").append(name).append("</h2>\n<ul>");
        for (CourseComponent comp : components) {
            sb.append("<li>").append(comp.format()).append("</li>");
        }
        sb.append("</ul>");
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Concentration: " + name;
    }
}

