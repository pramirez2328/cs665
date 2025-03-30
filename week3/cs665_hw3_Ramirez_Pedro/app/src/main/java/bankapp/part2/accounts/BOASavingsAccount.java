package bankapp.part2.accounts;

public class BOASavingsAccount extends SavingsAccount {
    @Override
    public void accountType() {
        super.accountType();
        System.out.println("::BankOfAmerica Savings Account");
    }
}
