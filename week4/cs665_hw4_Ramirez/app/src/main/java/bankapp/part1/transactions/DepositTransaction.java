package bankapp.part1.transactions;

public class DepositTransaction implements Transaction {
    @Override
    public String getDescription() {

        return "Transaction::DepositTransaction";
    }
}
