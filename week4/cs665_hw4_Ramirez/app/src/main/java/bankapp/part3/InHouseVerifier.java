package bankapp.part3;

public class InHouseVerifier implements IVerify {
    @Override
    public void verifyCustomer(Customer customer) {
        System.out.println("Doing in house verification for " + customer.getName());
    }
}

