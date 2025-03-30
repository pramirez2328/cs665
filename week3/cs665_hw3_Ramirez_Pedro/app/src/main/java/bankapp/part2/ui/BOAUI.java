package bankapp.part2.ui;

public class BOAUI extends BankUI {
    @Override
    protected void createHeader() {
        System.out.println("  Step  1: Creating Bank of America Header...");
    }

    @Override
    protected void createSidebar() {
        System.out.println("  Step  2: Creating Bank of America Sidebar...");
    }

    @Override
    protected void createMainPanel() {
        System.out.println("  Step  3: Creating Bank of America Main Panel...");
    }

    @Override
    protected void createFooter() {
        System.out.println("  Step  4: Creating Bank of America Footer...");
    }
}

