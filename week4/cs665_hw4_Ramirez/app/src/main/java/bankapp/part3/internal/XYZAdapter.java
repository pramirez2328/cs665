package bankapp.part3.internal;

import bankapp.part3.Customer;
import bankapp.part3.IVerify;
import bankapp.part3.external.XYZChecker;

public class XYZAdapter implements IVerify {
    @Override
    public void verifyCustomer(Customer customer) {
        XYZChecker.backgroundCheck(customer.getName(), customer.getAddress());
    }
}

