package bankapp.part3.simplefactory;

public class SimpleCustomerFactory {
    public CustomerSimpleFactory createCustomer(String type) {
        System.out.println("Creating " + capitalize(type) + " Customer...");
        return switch (type.toLowerCase()) {
            case "standard" -> new StandardCustomerSimpleFactory();
            case "preferred" -> new PreferredCustomerSimpleFactory();
            case "business" -> new BusinessCustomerSimpleFactory();
            default -> throw new IllegalArgumentException("Unknown customer type: " + type);
        };
    }

    private String capitalize(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}
