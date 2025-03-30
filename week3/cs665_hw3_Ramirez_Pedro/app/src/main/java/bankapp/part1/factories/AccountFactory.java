package bankapp.part1.factories;

import bankapp.part1.accounts.*;

public class AccountFactory {
    public CheckingAccount createCheckingAccount() {
        System.out.println("Creating Checking Account");
        return new CheckingAccount();
    }

    public SavingsAccount createSavingsAccount() {
        System.out.println("\nCreating Savings Account");
        return new SavingsAccount();
    }
}
