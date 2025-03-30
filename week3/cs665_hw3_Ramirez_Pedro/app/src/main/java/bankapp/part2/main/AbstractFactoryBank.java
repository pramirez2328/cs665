package bankapp.part2.main;

import bankapp.part2.accounts.*;
import bankapp.part2.factories.*;
import bankapp.part2.ui.*;


public class AbstractFactoryBank {
    public static void main(String[] args) {
        System.out.println("PART 1");

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

        System.out.println("\n----------------------------------------------\n");

        System.out.println("PART 2");

        System.out.println("\n--Testing Bank of America version of UI--\n");
        BankUI boaUI = new BOAUI();
        boaUI.createUI();

        System.out.println("\n--Testing Chase version of UI--\n");
        BankUI chaseUI = new ChaseUI();
        chaseUI.createUI();
    }
}
