import java.util.ArrayList;
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;
    public FoodItem(String itemName,double price,int quantity){this.itemName=itemName;this.price=price;this.quantity=quantity;}
    public String getItemName(){return itemName;}
    public double getPrice(){return price;}
    public int getQuantity(){return quantity;}
    public void setQuantity(int q){ if(q>=0) quantity=q; }
    public String getItemDetails(){ return itemName+" "+price+" "+quantity; }
    public abstract double calculateTotalPrice();
}
interface Discountable { double applyDiscount(); String getDiscountDetails(); }
class VegItem extends FoodItem implements Discountable {
    public VegItem(String n,double p,int q){ super(n,p,q); }
    public double calculateTotalPrice(){ return getPrice()*getQuantity(); }
    public double applyDiscount(){ return calculateTotalPrice()*0.05; }
    public String getDiscountDetails(){ return "VegDiscount 5%"; }
}
class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String n,double p,int q){ super(n,p,q); }
    public double calculateTotalPrice(){ return getPrice()*getQuantity()+50; }
    public double applyDiscount(){ return calculateTotalPrice()*0.03; }
    public String getDiscountDetails(){ return "NonVegDiscount 3%"; }
}
public class FoodDelivery {
    public static void main(String[] args){
        ArrayList<FoodItem> order=new ArrayList<>();
        order.add(new VegItem("Paneer",150,2));
        order.add(new NonVegItem("Chicken",200,1));
        for(FoodItem f:order){
            double total=f.calculateTotalPrice();
            double disc=(f instanceof Discountable)?((Discountable)f).applyDiscount():0;
            System.out.println(f.getItemName()+" final:"+ (total-disc));
        }
    }
}
