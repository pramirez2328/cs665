package bankapp.part1.observer;

public class SimpleObserver implements Observer {
    private final String name;

    public SimpleObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Message received by " + name + " : " + message);
    }
}
