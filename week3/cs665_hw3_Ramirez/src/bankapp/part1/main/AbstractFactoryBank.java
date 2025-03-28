package bankapp.part1.main;

import bankapp.part1.accounts.CheckingAccount;
import bankapp.part1.accounts.SavingsAccount;
import bankapp.part1.factories.AccountFactory;
import bankapp.part1.factories.BOAFactory;
import bankapp.part1.factories.ChaseFactory;


public class AbstractFactoryBank {
    public static void main(String[] args) {
        System.out.println("PART1");

        System.out.println("--Testing Basic version of Accounts--\n");
        AccountFactory baseFactory = new AccountFactory();
        CheckingAccount basicChecking = baseFactory.createCheckingAccount();
        basicChecking.accountType();
        SavingsAccount basicSavings = baseFactory.createSavingsAccount();
        basicSavings.accountType();

        System.out.println("--Testing Bank of America version of Accounts--\n");
        AccountFactory boaFactory = new BOAFactory();
        CheckingAccount boaChecking = boaFactory.createCheckingAccount();
        boaChecking.accountType();
        SavingsAccount boaSavings = boaFactory.createSavingsAccount();
        boaSavings.accountType();

        System.out.println("--Testing Chase version of Accounts--\n");
        AccountFactory chaseFactory = new ChaseFactory();
        CheckingAccount chaseChecking = chaseFactory.createCheckingAccount();
        chaseChecking.accountType();
        SavingsAccount chaseSavings = chaseFactory.createSavingsAccount();
        chaseSavings.accountType();
    }
}
