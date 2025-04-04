package bankapp.part2.main;

import bankapp.part2.statements.ComboStatement;
import bankapp.part2.statements.MonthlyStatement;
import bankapp.part2.statements.Statement;

public class CompositePatternMain {
    public static void main(String[] args) {
        System.out.println("-- Testing Monthly Statement by itself --");
        Statement jan2024 = new MonthlyStatement("January", 2024);
        jan2024.printStatement();

        System.out.println("\n-- Testing Quarterly Statement (Q1 2024) --");
        ComboStatement q1_2024 = new ComboStatement("Quarterly Statement for Q1 2024");
        q1_2024.add(new MonthlyStatement("January", 2024));
        q1_2024.add(new MonthlyStatement("February", 2024));
        q1_2024.add(new MonthlyStatement("March", 2024));
        q1_2024.printStatement();

        System.out.println("\n-- Testing Quarterly Statement (Q2 2024) --");
        ComboStatement q2_2024 = new ComboStatement("Quarterly Statement for Q2 2024");
        q2_2024.add(new MonthlyStatement("April", 2024));
        q2_2024.add(new MonthlyStatement("May", 2024));
        q2_2024.add(new MonthlyStatement("June", 2024));
        q2_2024.printStatement();

        System.out.println("\n-- Testing Half yearly Statement (First Half 2024) --");
        ComboStatement firstHalf2024 = new ComboStatement("First Half yearly Statement for 2024");
        firstHalf2024.add(q1_2024);
        firstHalf2024.add(q2_2024);
        firstHalf2024.printStatement();
    }
}
