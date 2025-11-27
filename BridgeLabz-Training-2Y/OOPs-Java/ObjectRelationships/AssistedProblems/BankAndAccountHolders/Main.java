public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("HDFC Bank");
        Customer c1 = new Customer("Alice");
        Customer c2 = new Customer("Bob");

        bank.openAccount(c1, 5000);
        bank.openAccount(c2, 3000);

        c1.viewBalance();
        c2.viewBalance();
    }
}