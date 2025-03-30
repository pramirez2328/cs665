package bankapp.part2.ui;

public abstract class BankUI {
    public final void createUI() {
        System.out.println("User interface completed as below :");
        createHeader();
        createSidebar();
        createMainPanel();
        createFooter();
    }

    protected abstract void createHeader();
    protected abstract void createSidebar();
    protected abstract void createMainPanel();
    protected abstract void createFooter();
}

