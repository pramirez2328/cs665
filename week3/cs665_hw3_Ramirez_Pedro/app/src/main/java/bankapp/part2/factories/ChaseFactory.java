package bankapp.part2.factories;

import bankapp.part2.accounts.*;

// Chase Factory
public class ChaseFactory extends AccountFactory {
    @Override
    public CheckingAccount createCheckingAccount() {
        System.out.println("Creating Checking Account");
        return new ChaseCheckingAccount();
    }

    @Override
    public SavingsAccount createSavingsAccount() {
        System.out.println("Creating Savings Account");
        return new ChaseSavingsAccount();
    }
}
