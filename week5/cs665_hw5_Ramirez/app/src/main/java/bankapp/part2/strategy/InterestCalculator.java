package bankapp.part2.strategy;


public class InterestCalculator {
    private InterestStrategy strategy;

    public void setStrategy(InterestStrategy strategy) {
        this.strategy = strategy;
    }

    public double computeInterest(double balance, double rate) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set");
        }
        return strategy.calculateInterest(balance, rate);
    }
}
