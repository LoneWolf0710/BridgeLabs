import java.util.*;

class Product {
    String name;
    double price;
    int stock;
    public Product(String name, double price, int stock) { this.name = name; this.price = price; this.stock = stock; }
    @Override
    public String toString() { return name + " (stock=" + stock + ")"; }
}

public class Q22_InventoryRestockManagementSystem {

    public static void main(String[] args) {
        Set<String> productNames = new HashSet<>();
        List<Product> products = new ArrayList<>();
        Queue<Product> restockQueue = new LinkedList<>();
        Stack<Product> restockedStack = new Stack<>();

        Product p1 = new Product("Milk", 50, 2);
        Product p2 = new Product("Bread", 30, 10);

        if (productNames.add(p1.name)) products.add(p1);
        if (productNames.add(p2.name)) products.add(p2);

        for (Product p : products) {
            if (p.stock < 5) {
                restockQueue.add(p);
            }
        }

        System.out.println("Products needing restock: " + restockQueue);
        while (!restockQueue.isEmpty()) {
            Product p = restockQueue.remove();
            p.stock += 10;
            restockedStack.push(p);
            System.out.println("Restocked: " + p);
        }

        System.out.println("Undo last restock:");
        if (!restockedStack.isEmpty()) {
            Product last = restockedStack.pop();
            last.stock -= 10;
            System.out.println("After undo: " + last);
        }
    }
}
