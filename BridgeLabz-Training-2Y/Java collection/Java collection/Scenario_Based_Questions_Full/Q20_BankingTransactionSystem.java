import java.util.*;

class Transaction {
    String id;
    double amount;
    public Transaction(String id, double amount) { this.id = id; this.amount = amount; }
    @Override
    public String toString() { return "Transaction{" + id + ", " + amount + "}"; }
}

class Account {
    String id;
    public Account(String id) { this.id = id; }
    @Override
    public String toString() { return id; }
}

public class Q20_BankingTransactionSystem {

    public static void main(String[] args) {
        List<Transaction> allTransactions = new ArrayList<>();
        allTransactions.add(new Transaction("T1", 1000));
        allTransactions.add(new Transaction("T2", 2000));

        Queue<Transaction> pending = new LinkedList<>(allTransactions);
        Set<Account> validAccounts = new HashSet<>();
        validAccounts.add(new Account("A1"));
        validAccounts.add(new Account("A2"));

        Stack<Transaction> rollbackStack = new Stack<>();

        System.out.println("Executing transactions sequentially:");
        while (!pending.isEmpty()) {
            Transaction t = pending.remove();
            System.out.println("Processing: " + t);
            rollbackStack.push(t);
        }

        System.out.println("Rolling back last transaction:");
        if (!rollbackStack.isEmpty()) {
            System.out.println("Rollback: " + rollbackStack.pop());
        }
    }
}
