package bankapp.part3.factorymethod;

public class PreferredCustomerFactoryMethod extends CustomerFactoryMethod {
    @Override
    public void describe() {
        System.out.println("**Customer**::PreferredCustomer");
    }
}

