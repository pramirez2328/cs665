package bankapp.part3.factorymethod;

public class StandardCustomerFactoryMethod extends CustomerFactoryMethod {
    @Override
    public void describe() {
        System.out.println("**Customer**::StandardCustomer");
    }
}
