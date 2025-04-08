package model.common;

import java.util.Objects;

public class Semester {
    private String name; // e.g., "Fall 2024"

    public Semester(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Semester)) return false;
        Semester other = (Semester) obj;
        return name.equalsIgnoreCase(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
