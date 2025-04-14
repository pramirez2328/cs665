package behavioral.observer;

/**
 * Subject interface for the Observer Design Pattern.
 * <p>
 * Any class (e.g., Course) that needs to notify observers (e.g., Chairperson)
 * about changes will implement this interface.
 */
public interface Subject {

    /**
     * Registers an observer to receive updates.
     *
     * @param observer the observer to add
     */
    void registerObserver(Observer observer);

    /**
     * Removes an observer so it no longer receives updates.
     *
     * @param observer the observer to remove
     */
    void removeObserver(Observer observer);

    /**
     * Notifies all registered observers with a given message.
     *
     * @param message the message to send to observers
     */
    void notifyObservers(String message);
}
