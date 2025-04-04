package bankapp.part2.statements;

public class MonthlyStatement extends Statement {
    private final String month;
    private final int year;

    public MonthlyStatement(String month, int year) {
        this.month = month;
        this.year = year;
    }

    @Override
    public void printStatement() {
        System.out.println("** Monthly Statement for " + month + ", " + year);
    }
}
