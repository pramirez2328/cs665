package bankapp.part3;

public class InHouseVerifier implements IVerify {
    @Override
    public boolean verifyCustomer(Customer customer) {
        System.out.println("Doing in house verification for " + customer.getName());

        // Assuming verification has been implemented and it passed
        return true;
    }
}

