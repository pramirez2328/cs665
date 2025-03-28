package bankapp.part1.accounts;

public class ChaseCheckingAccount extends CheckingAccount {
    @Override
    public void accountType() {
        super.accountType();
        System.out.println("::Chase Checking Account");
    }
}
