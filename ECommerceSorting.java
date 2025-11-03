import java.util.*;

class Product {
    String name;
    double price;
    double rating;
    double discount;

    Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    void display() {
        System.out.println(name + " | Price: " + price + " | Rating: " + rating + " | Discount: " + discount + "%");
    }
}

public class ECommerceSorting {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Shoes", 1200, 4.3, 10));
        products.add(new Product("Watch", 2500, 4.8, 25));
        products.add(new Product("Bag", 900, 4.1, 15));
        products.add(new Product("Headphones", 1500, 4.5, 5));

        System.out.println("=== Sort by Price (Low to High) ===");
        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        products.forEach(Product::display);

        System.out.println("\n=== Sort by Rating (High to Low) ===");
        products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));
        products.forEach(Product::display);

        System.out.println("\n=== Sort by Discount (High to Low) ===");
        products.sort((p1, p2) -> Double.compare(p2.discount, p1.discount));
        products.forEach(Product::display);
    }
}
