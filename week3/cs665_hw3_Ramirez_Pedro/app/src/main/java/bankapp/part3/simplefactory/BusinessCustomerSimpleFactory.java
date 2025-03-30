package bankapp.part3.simplefactory;

public class BusinessCustomerSimpleFactory extends CustomerSimpleFactory {
    @Override
    public void describe() {
        System.out.println("**Customer**::BusinessCustomer");
    }
}
