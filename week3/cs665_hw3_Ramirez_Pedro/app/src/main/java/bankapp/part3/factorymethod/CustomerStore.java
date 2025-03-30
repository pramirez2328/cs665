package bankapp.part3.factorymethod;

public abstract class CustomerStore {
    public CustomerFactoryMethod orderCustomer(String type) {
        CustomerFactoryMethod customer = createCustomer(type);
        customer.describe();
        return customer;
    }

    protected abstract CustomerFactoryMethod createCustomer(String type);
}
