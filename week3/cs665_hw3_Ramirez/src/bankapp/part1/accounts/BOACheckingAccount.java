package bankapp.part1.accounts;

public class BOACheckingAccount extends CheckingAccount {
    @Override
    public void accountType() {
        super.accountType();
        System.out.println("::BankOfAmerica Checking Account");
    }
}
