import java.util.ArrayList;
abstract class Product {
    private String productId;
    private String name;
    private double price;
    public Product(String productId,String name,double price){this.productId=productId;this.name=name;this.price=price;}
    public String getProductId(){return productId;}
    public String getName(){return name;}
    public double getPrice(){return price;}
    public void setPrice(double p){ if(p>=0) price=p; }
    public abstract double calculateDiscount();
}
interface Taxable { double calculateTax(); String getTaxDetails(); }
class Electronics extends Product implements Taxable {
    public Electronics(String id,String name,double price){ super(id,name,price); }
    public double calculateDiscount(){ return getPrice()*0.10; }
    public double calculateTax(){ return getPrice()*0.18; }
    public String getTaxDetails(){ return "GST 18%"; }
}
class Clothing extends Product implements Taxable {
    public Clothing(String id,String name,double price){ super(id,name,price); }
    public double calculateDiscount(){ return getPrice()*0.15; }
    public double calculateTax(){ return getPrice()*0.05; }
    public String getTaxDetails(){ return "GST 5%"; }
}
class Groceries extends Product {
    public Groceries(String id,String name,double price){ super(id,name,price); }
    public double calculateDiscount(){ return getPrice()*0.02; }
}
public class ECommercePlatform {
    public static void printFinalPrice(Product p){
        double tax = (p instanceof Taxable)? ((Taxable)p).calculateTax():0;
        double discount = p.calculateDiscount();
        double finalPrice = p.getPrice() + tax - discount;
        System.out.println(p.getName()+" "+finalPrice);
    }
    public static void main(String[] args){
        ArrayList<Product> list=new ArrayList<>();
        list.add(new Electronics("E01","Phone",20000));
        list.add(new Clothing("C01","Shirt",1000));
        list.add(new Groceries("G01","Rice",200));
        for(Product p:list) printFinalPrice(p);
    }
}
