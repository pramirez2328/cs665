package bankapp.part1.decorators;

import bankapp.part1.transactions.Transaction;

import java.util.Date;

public class SecurityDecorator extends TransactionDecorator {

    public SecurityDecorator(Transaction transaction) {
        super(transaction);
    }

    @Override
    public String getDescription() {

        return "Security check @" + new Date() + "->" + transaction.getDescription();
    }
}
