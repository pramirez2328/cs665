package bankapp.part2.strategy;

public class CompoundInterestStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double balance, double rate) {
        return balance * Math.pow((1 + rate / 365), 31) - balance;
    }
}
