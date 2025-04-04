package bankapp.part3.main;

import bankapp.part3.internal.*;
import bankapp.part3.Customer;
import bankapp.part3.IVerify;
import bankapp.part3.InHouseVerifier;

public class AdapterMain {
    public static void main(String[] args) {
        Customer alice = new Customer("Alice", "222-333-4444", "123 Main St, Boston, MA");

        IVerify inHouse = new InHouseVerifier();
        IVerify abcAdapter = new ABCAdapter();
        IVerify xyzAdapter = new XYZAdapter();

        inHouse.verifyCustomer(alice);
        abcAdapter.verifyCustomer(alice);
        xyzAdapter.verifyCustomer(alice);
    }
}
