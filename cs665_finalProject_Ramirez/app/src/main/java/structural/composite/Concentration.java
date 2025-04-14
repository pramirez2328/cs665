package structural.composite;

import java.util.ArrayList;
import java.util.List;

import model.users.FullTimeFaculty;

/**
 * Composite class in the Composite Design Pattern.
 * A Concentration can contain individual courses (leaves)
 * or other concentrations (sub-composites).
 */
public class Concentration implements CourseComponent {
    private final String name;
    private FullTimeFaculty coordinator;
    private final List<CourseComponent> components = new ArrayList<>();

    /**
     * Creates a new concentration area with the given name.
     *
     * @param name The name of the concentration (e.g., "Data Science")
     */
    public Concentration(String name) {
        this.name = name;
    }

    /**
     * Adds a component (either a course or another concentration).
     *
     * @param component The CourseComponent to add
     */
    public void addComponent(CourseComponent component) {
        components.add(component);
    }

    /**
     * Removes a component from the concentration.
     *
     * @param component The CourseComponent to remove
     */
    public void removeComponent(CourseComponent component) {
        components.remove(component);
    }

    /**
     * Recursively formats the concentration and its children into HTML.
     *
     * @return HTML-formatted string representing the concentration structure
     */
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
