package bankapp.part3.adapters;

import bankapp.part3.Customer;
import bankapp.part3.IVerify;
import bankapp.part3.externalValidators.ABCValidator;

public class ABCAdapter implements IVerify {
    @Override
    public boolean verifyCustomer(Customer customer) {

        return ABCValidator.validate(customer.getName(), customer.getPhone());
    }
}

