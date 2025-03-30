package bankapp.part3.factorymethod;

public class BankCustomerStore extends CustomerStore {
    @Override
    protected CustomerFactoryMethod createCustomer(String type) {
        System.out.println("Creating " + capitalize(type) + " Customer...");
        return switch (type.toLowerCase()) {
            case "standard" -> new StandardCustomerFactoryMethod();
            case "preferred" -> new PreferredCustomerFactoryMethod();
            case "business" -> new BusinessCustomerFactoryMethod();
            default -> throw new IllegalArgumentException("Unknown customer type: " + type);
        };
    }

    private String capitalize(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}
