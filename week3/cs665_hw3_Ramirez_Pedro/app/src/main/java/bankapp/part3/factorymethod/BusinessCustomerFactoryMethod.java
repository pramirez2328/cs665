package bankapp.part3.factorymethod;

public class BusinessCustomerFactoryMethod extends CustomerFactoryMethod {
    @Override
    public void describe() {
        System.out.println("**Customer**::BusinessCustomer");
    }
}
