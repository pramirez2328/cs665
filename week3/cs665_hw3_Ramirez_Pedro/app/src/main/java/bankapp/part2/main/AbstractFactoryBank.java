package bankapp.part2.main;

import bankapp.part2.accounts.*;
import bankapp.part2.factories.*;


public class AbstractFactoryBank {
    public static void main(String[] args) {
        System.out.println("PART2");

        System.out.println("\n--Testing Basic version of Accounts--\n");
        AccountFactory baseFactory = new AccountFactory();
        CheckingAccount basicChecking = baseFactory.createCheckingAccount();
        basicChecking.accountType();
        SavingsAccount basicSavings = baseFactory.createSavingsAccount();
        basicSavings.accountType();

        System.out.println("\n----------------------------------------------");

        System.out.println("\n--Testing Bank of America version of Accounts--\n");
        AccountFactory boaFactory = new BOAFactory();
        CheckingAccount boaChecking = boaFactory.createCheckingAccount();
        boaChecking.accountType();
        SavingsAccount boaSavings = boaFactory.createSavingsAccount();
        boaSavings.accountType();

        System.out.println("\n----------------------------------------------");

        System.out.println("\n--Testing Chase version of Accounts--\n");
        AccountFactory chaseFactory = new ChaseFactory();
        CheckingAccount chaseChecking = chaseFactory.createCheckingAccount();
        chaseChecking.accountType();
        SavingsAccount chaseSavings = chaseFactory.createSavingsAccount();
        chaseSavings.accountType();
    }
}
