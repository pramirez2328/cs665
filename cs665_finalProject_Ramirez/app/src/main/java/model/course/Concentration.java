package model.course;

import java.util.ArrayList;
import java.util.List;

import model.users.FullTimeFaculty;

public class Concentration implements CourseComponent {
    private String name;
    private FullTimeFaculty coordinator;
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
        sb.append("<h2>").append(name).append("</h2>");
        if (coordinator != null) {
            sb.append("<p><em>Coordinator: ").append(coordinator.getName()).append("</em></p>");
        }
        sb.append("<ul>");
        for (CourseComponent component : components) {
            sb.append("<li>").append(component.format()).append("</li>");
        }
        sb.append("</ul>");
        return sb.toString();
    }


    @Override
    public String toString() {
        return "Concentration: " + name;
    }

    public void setCoordinator(FullTimeFaculty coordinator) {
        this.coordinator = coordinator;
    }

    public FullTimeFaculty getCoordinator() {
        return coordinator;
    }

    public String getName() {
        return name;
    }

}

