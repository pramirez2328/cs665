package bankapp.part3.externalValidators;

public class ABCValidator {
    public static boolean validate(String name, String phone) {
        System.out.println("ABC third-party verification for " + name + ", " + phone);

        // Assuming verification has been implemented and it passed
        return true;
    }
}
