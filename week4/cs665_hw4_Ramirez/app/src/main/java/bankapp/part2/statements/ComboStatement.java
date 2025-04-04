package bankapp.part2.statements;

import java.util.ArrayList;
import java.util.List;

public class ComboStatement extends Statement {
    private final List<Statement> statements = new ArrayList<>();
    private final String description;

    public ComboStatement(String description) {
        this.description = description;
    }

    public void add(Statement stmt) {
        statements.add(stmt);
    }

    public void remove(Statement stmt) {
        statements.remove(stmt);
    }

    @Override
    public void printStatement() {
        System.out.println("** Combo Statement of " + description);
        for (Statement stmt : statements) {
            stmt.printStatement();
        }
    }
}
