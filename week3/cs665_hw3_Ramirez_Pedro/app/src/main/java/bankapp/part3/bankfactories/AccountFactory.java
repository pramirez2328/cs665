package bankapp.part3.bankfactories;

import bankapp.part3.accounts.*;


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
