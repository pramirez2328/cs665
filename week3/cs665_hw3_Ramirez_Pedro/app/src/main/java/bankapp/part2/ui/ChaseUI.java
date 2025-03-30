package bankapp.part2.ui;

public class ChaseUI extends BankUI {
    @Override
    protected void createHeader() {
        System.out.println("  Step  1: Creating Chase Header...");
    }

    @Override
    protected void createSidebar() {
        System.out.println("  Step  2: Creating Chase Sidebar...");
    }

    @Override
    protected void createMainPanel() {
        System.out.println("  Step  3: Creating Chase Main Panel...");
    }

    @Override
    protected void createFooter() {
        System.out.println("  Step  4: Creating Chase Footer...");
    }
}

