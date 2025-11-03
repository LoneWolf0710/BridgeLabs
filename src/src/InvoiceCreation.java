import java.util.*;
import java.util.stream.*;

class Invoice {
    String transactionId;

    Invoice(String transactionId) {
        this.transactionId = transactionId;
    }

    void display() {
        System.out.println("Invoice created for Transaction: " + transactionId);
    }
}

public class InvoiceCreation {
    public static void main(String[] args) {

        List<String> transactionIds = Arrays.asList("TXN101", "TXN102", "TXN103");

        List<Invoice> invoices = transactionIds.stream()
                .map(Invoice::new)
                .toList();

        System.out.println("=== Invoices Generated ===");
        invoices.forEach(Invoice::display);
    }
}
