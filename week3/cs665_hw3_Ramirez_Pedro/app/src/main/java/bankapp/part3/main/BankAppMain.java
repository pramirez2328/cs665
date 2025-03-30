package bankapp.part3.main;

import bankapp.part3.accounts.*;
import bankapp.part3.bankfactories.*;
import bankapp.part3.factorymethod.*;
import bankapp.part3.simplefactory.*;
import bankapp.part3.ui.*;


public class BankAppMain {
    public static void main(String[] args) {
        System.out.println("PART 1");

        System.out.println("\n--Testing Basic version of Accounts--\n");
        AccountFactory baseFactory = new AccountFactory();
        CheckingAccount basicChecking = baseFactory.createCheckingAccount();
        basicChecking.accountType();
        SavingsAccount basicSavings = baseFactory.createSavingsAccount();
        basicSavings.accountType();

        System.out.println("\n\n--Testing Bank of America version of Accounts--\n");
        AccountFactory boaFactory = new BOAFactory();
        CheckingAccount boaChecking = boaFactory.createCheckingAccount();
        boaChecking.accountType();
        SavingsAccount boaSavings = boaFactory.createSavingsAccount();
        boaSavings.accountType();

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

        System.out.println("\n----------------------------------------------\n");

        System.out.println("PART 3");
        System.out.println("Part3: First version using SimpleFactory\n");

        SimpleCustomerFactory factory = new SimpleCustomerFactory();
        CustomerManager manager = new CustomerManager(factory);

        CustomerSimpleFactory c1 = manager.processCustomer("standard");
        c1.describe();

        CustomerSimpleFactory c2 = manager.processCustomer("preferred");
        c2.describe();

        CustomerSimpleFactory c3 = manager.processCustomer("business");
        c3.describe();

        System.out.println("\nPart3: Second version using FactoryMethod\n");

        CustomerStore store = new BankCustomerStore();

        CustomerFactoryMethod f1 = store.orderCustomer("standard");
        CustomerFactoryMethod f2 = store.orderCustomer("preferred");
        CustomerFactoryMethod f3 = store.orderCustomer("business");
    }
}
