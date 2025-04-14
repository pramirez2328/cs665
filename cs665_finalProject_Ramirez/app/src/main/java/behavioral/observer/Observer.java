package behavioral.observer;

/**
 * Observer interface for the Observer Design Pattern.
 * Classes that need to receive updates from a Subject (e.g., Chairperson receiving
 * course enrollment notifications) will implement this interface.
 */
public interface Observer {

    /**
     * Called by the Subject to notify the observer of a change or event.
     *
     * @param message the update message sent by the Subject
     */
    void update(String message);
}
