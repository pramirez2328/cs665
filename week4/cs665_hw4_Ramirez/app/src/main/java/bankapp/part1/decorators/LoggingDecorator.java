package bankapp.part1.decorators;

import bankapp.part1.transactions.Transaction;
import java.util.Date;

public class LoggingDecorator extends TransactionDecorator {
    public LoggingDecorator(Transaction transaction) {
        super(transaction);
    }

    @Override
    public String getDescription() {
        return "Logging @" + new Date() + "->" + transaction.getDescription();
    }
}
