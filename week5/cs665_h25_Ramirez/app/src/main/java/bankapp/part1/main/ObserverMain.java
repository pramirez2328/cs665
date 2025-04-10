package bankapp.part1.main;

import bankapp.part1.observer.Observer;
import bankapp.part1.observer.SimpleObserver;
import bankapp.part1.observer.SimpleSubject;

public class ObserverMain {
    public static void main(String[] args) {
        SimpleSubject subject1 = new SimpleSubject();
        SimpleSubject subject2 = new SimpleSubject();

        // product information alerts
        Observer charlie = new SimpleObserver("Charlie");
        Observer dave = new SimpleObserver("Dave");
        subject1.registerObserver(charlie);
        subject1.registerObserver(dave);

        // promotional offers
        Observer alice = new SimpleObserver("Alice");
        Observer bob = new SimpleObserver("Bob");
        subject2.registerObserver(alice);
        subject2.registerObserver(bob);

        System.out.println("Product Info Message by subject1");
        subject1.notifyObservers("Interest rate being increased...");

        System.out.println("Promotional Info Message by subject2");
        subject2.notifyObservers("New products for Auto Loans...");
    }
}

