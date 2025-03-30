package bankapp.part3.simplefactory;

public class StandardCustomerSimpleFactory extends CustomerSimpleFactory {
    @Override
    public void describe() {
        System.out.println("**Customer**::StandardCustomer");
    }
}
