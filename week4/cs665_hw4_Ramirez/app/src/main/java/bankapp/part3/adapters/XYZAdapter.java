package bankapp.part3.adapters;

import bankapp.part3.Customer;
import bankapp.part3.IVerify;
import bankapp.part3.externalValidators.XYZChecker;

public class XYZAdapter implements IVerify {
    @Override
    public boolean verifyCustomer(Customer customer) {

        return XYZChecker.backgroundCheck(customer.getName(), customer.getAddress());
    }
}

