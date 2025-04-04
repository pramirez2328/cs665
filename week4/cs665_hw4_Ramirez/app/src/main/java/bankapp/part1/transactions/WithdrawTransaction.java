package bankapp.part1.transactions;

public class WithdrawTransaction implements Transaction {
    @Override
    public String getDescription() {
        return "Transaction::WithdrawTransaction";
    }
}

