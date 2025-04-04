package bankapp.part1.main;

import bankapp.part1.transactions.*;
import bankapp.part1.decorators.*;

public class DecoratorPatternMain {
    public static void main(String[] args) {

        System.out.println("-- Testing Deposit Transaction by itself --");
        Transaction deposit = new DepositTransaction();
        System.out.println(deposit.getDescription());

        System.out.println("\n-- Testing Deposit Transaction with Logging --");
        Transaction depositWithLogging = new LoggingDecorator(deposit);
        System.out.println(depositWithLogging.getDescription());

        System.out.println("\n-- Testing Deposit Transaction with Security --");
        Transaction depositWithSecurity = new SecurityDecorator(deposit);
        System.out.println(depositWithSecurity.getDescription());

        System.out.println("\n-- Testing Deposit Transaction with Logging and Security --");
        Transaction depositWithLoggingAndSecurity = new LoggingDecorator(new SecurityDecorator(deposit));
        System.out.println(depositWithLoggingAndSecurity.getDescription());

        System.out.println("\n-- Testing Withdraw Transaction by itself --");
        Transaction withdraw = new WithdrawTransaction();
        System.out.println(withdraw.getDescription());

        System.out.println("\n-- Testing Withdraw Transaction with Security and Logging --");
        Transaction withdrawWithSecurityAndLogging = new SecurityDecorator(new LoggingDecorator(withdraw));
        System.out.println(withdrawWithSecurityAndLogging.getDescription());
    }
}
