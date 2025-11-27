import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void openAccount(Customer customer, double balance) {
        customer.setBalance(balance);
        customers.add(customer);
        System.out.println("Account opened for " + customer.getName() + " in " + name);
    }

    public String getName() {
        return name;
    }
}