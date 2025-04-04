package bankapp.part3.internal;

import bankapp.part3.Customer;
import bankapp.part3.IVerify;
import bankapp.part3.external.ABCValidator;

public class ABCAdapter implements IVerify {
    @Override
    public void verifyCustomer(Customer customer) {
        ABCValidator.validate(customer.getName(), customer.getPhone());
    }
}

