package bankapp.part2.strategy;

public class SimpleInterestStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double balance, double rate) {
        return (balance * rate / 12.0);
    }
}

