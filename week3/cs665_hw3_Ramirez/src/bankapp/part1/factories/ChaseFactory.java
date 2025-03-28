package bankapp.part1.factories;

import bankapp.part1.accounts.ChaseCheckingAccount;
import bankapp.part1.accounts.ChaseSavingsAccount;
import bankapp.part1.accounts.CheckingAccount;
import bankapp.part1.accounts.SavingsAccount;

import bankapp.part1.accounts.*;

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
