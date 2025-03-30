package bankapp.part3.simplefactory;

public class CustomerManager {
    SimpleCustomerFactory factory;

    public CustomerManager(SimpleCustomerFactory factory) {
        this.factory = factory;
    }

    public CustomerSimpleFactory processCustomer(String type) {
        return factory.createCustomer(type);
    }
}
