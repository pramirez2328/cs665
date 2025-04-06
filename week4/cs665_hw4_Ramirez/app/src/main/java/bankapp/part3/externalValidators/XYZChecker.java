package bankapp.part3.externalValidators;

public class XYZChecker {
    public static boolean backgroundCheck(String name, String address) {
        System.out.println("XYZ third-party background verification for " + name + ", " + address);

        // Assuming verification has been implemented and it passed
        return true;
    }
}

