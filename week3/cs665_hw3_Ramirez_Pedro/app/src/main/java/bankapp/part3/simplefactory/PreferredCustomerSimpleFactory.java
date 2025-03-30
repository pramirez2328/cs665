package bankapp.part3.simplefactory;

public class PreferredCustomerSimpleFactory extends CustomerSimpleFactory {
    @Override
    public void describe() {
        System.out.println("**Customer**::PreferredCustomer");
    }
}
