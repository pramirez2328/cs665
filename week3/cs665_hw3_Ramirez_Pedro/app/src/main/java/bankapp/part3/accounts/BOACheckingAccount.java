package bankapp.part3.accounts;

public class BOACheckingAccount extends CheckingAccount {
    @Override
    public void accountType() {
        super.accountType();
        System.out.println("::BankOfAmerica Checking Account");
    }
}
