package bankapp.part3.main;

import bankapp.part3.adapters.*;
import bankapp.part3.Customer;
import bankapp.part3.IVerify;
import bankapp.part3.InHouseVerifier;

public class AdapterMain {
    public static void main(String[] args) {
        Customer alice = new Customer("Alice", "222-333-4444", "123 Main St, Boston, MA");

        IVerify[] verifiers = {
                new InHouseVerifier(),
                new ABCAdapter(),
                new XYZAdapter()
        };

        for (IVerify verifier : verifiers) {
            boolean result = verifier.verifyCustomer(alice);

            String className = verifier.getClass().getSimpleName();
            System.out.println("    - Verification " + (result ? "passed" : "failed") + " using " + className + "\n");
        }
    }
}
