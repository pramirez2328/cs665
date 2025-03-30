package bankapp.part1.accounts;

public class ChaseSavingsAccount extends SavingsAccount {
    @Override
    public void accountType() {
        super.accountType();
        System.out.println("::Chase Savings Account");
    }
}
