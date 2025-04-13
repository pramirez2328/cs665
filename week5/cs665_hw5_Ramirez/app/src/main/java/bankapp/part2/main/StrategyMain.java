package bankapp.part2.main;

import bankapp.part2.strategy.*;

public class StrategyMain {
    public static void main(String[] args) {
        InterestCalculator calculator = new InterestCalculator();
        double balance = 1_000_000;
        double rate = 0.02;

        System.out.println("Using Simple interest");
        calculator.setStrategy(new SimpleInterestStrategy());
        System.out.println(calculator.computeInterest(balance, rate));

        System.out.println("\nUsing Compound interest");
        calculator.setStrategy(new CompoundInterestStrategy());
        System.out.println(calculator.computeInterest(balance, rate));
    }
}
