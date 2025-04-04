package bankapp.part1.decorators;

import bankapp.part1.transactions.Transaction;

public abstract class TransactionDecorator implements Transaction {
    protected Transaction transaction;

    public TransactionDecorator(Transaction transaction) {
        this.transaction = transaction;
    }

    public abstract String getDescription();
}
