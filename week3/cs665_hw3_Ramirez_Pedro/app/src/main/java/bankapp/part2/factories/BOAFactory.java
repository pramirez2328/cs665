package bankapp.part2.factories;

import bankapp.part2.accounts.*;


public class BOAFactory extends AccountFactory {
    @Override
    public CheckingAccount createCheckingAccount() {
        System.out.println("Creating Checking Account");
        return new BOACheckingAccount();
    }

    @Override
    public SavingsAccount createSavingsAccount() {
        System.out.println("Creating Savings Account");
        return new BOASavingsAccount();
    }
}
