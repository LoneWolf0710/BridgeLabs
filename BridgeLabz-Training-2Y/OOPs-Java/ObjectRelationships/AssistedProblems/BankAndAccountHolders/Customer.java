public class Customer {
    private String name;
    private double balance;

    public Customer(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void viewBalance() {
        System.out.println(name + "'s Balance: $" + balance);
    }

    public String getName() {
        return name;
    }
}