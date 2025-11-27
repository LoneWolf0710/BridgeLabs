import java.util.*;

class Order {
    String orderId;
    String customerName;

    public Order(String orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "Order{" + orderId + ", " + customerName + "}";
    }
}

public class Q17_ECommerceOrderProcessingSystem {

    public static void main(String[] args) {
        List<Order> allOrders = new ArrayList<>();
        allOrders.add(new Order("O1", "Alice"));
        allOrders.add(new Order("O2", "Bob"));
        allOrders.add(new Order("O1", "Alice Duplicate"));

        // Remove duplicates using Set (by orderId)
        Set<String> seenIds = new HashSet<>();
        Queue<Order> orderQueue = new LinkedList<>();
        Stack<Order> failedOrders = new Stack<>();

        for (Order o : allOrders) {
            if (seenIds.add(o.orderId)) {
                orderQueue.add(o);
            } else {
                System.out.println("Duplicate order removed: " + o);
            }
        }

        System.out.println("Processing valid orders in FIFO:");
        while (!orderQueue.isEmpty()) {
            Order o = orderQueue.remove();
            System.out.println("Processing " + o);
            // simulate one failure
            if (o.orderId.equals("O2")) {
                System.out.println("Order failed, pushing to retry stack: " + o);
                failedOrders.push(o);
            }
        }

        System.out.println("Re-processing failed orders:");
        while (!failedOrders.isEmpty()) {
            System.out.println("Retrying " + failedOrders.pop());
        }
    }
}
