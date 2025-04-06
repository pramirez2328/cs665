package bankapp;

import bankapp.part1.main.DecoratorPatternMain;
import bankapp.part2.main.CompositePatternMain;
import bankapp.part3.main.AdapterMain;

public class MasterMain {
    public static void main(String[] args) {
        System.out.println("======== Running Part 1: Decorator Pattern ========");
        DecoratorPatternMain.main(args);

        System.out.println("\n======== Running Part 2: Composite Pattern ========");
        CompositePatternMain.main(args);

        System.out.println("\n======== Running Part 3: Adapter Pattern ========");
        AdapterMain.main(args);
    }
}

