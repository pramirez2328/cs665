package bankapp;

import bankapp.part1.main.ObserverMain;
import bankapp.part2.main.StrategyMain;

public class appMain {
    public static void main(String[] args) {
        System.out.println("======== Running Part 1: Decorator Pattern ========");
        ObserverMain.main(args);

        System.out.println("\n======== Running Part 2: Composite Pattern ========");
        StrategyMain.main(args);
    }
}
