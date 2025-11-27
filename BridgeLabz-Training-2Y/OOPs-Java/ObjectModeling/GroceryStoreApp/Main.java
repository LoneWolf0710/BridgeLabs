public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Alice");
        customer.addProduct(new Product("Apples", 3.0, 2)); // 2 kg @ $3
        customer.addProduct(new Product("Milk", 2.0, 1));   // 1 liter @ $2

        BillGenerator billGen = new BillGenerator();
        double totalBill = billGen.generateBill(customer);

        System.out.println("Customer: " + customer.getName());
        for (Product p : customer.getProducts()) {
            System.out.println("Product: " + p.getName() + 
                               ", Qty: " + p.getQuantity() + 
                               ", Price per unit: $" + p.getPrice() + 
                               ", Total: $" + p.getTotalPrice());
        }
        System.out.println("Final Bill: $" + totalBill);
    }
}