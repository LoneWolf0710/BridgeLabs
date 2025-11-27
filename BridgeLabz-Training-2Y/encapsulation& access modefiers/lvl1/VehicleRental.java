import java.util.ArrayList;
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    public Vehicle(String vehicleNumber,String type,double rentalRate){this.vehicleNumber=vehicleNumber;this.type=type;this.rentalRate=rentalRate;}
    public String getVehicleNumber(){return vehicleNumber;}
    public String getType(){return type;}
    public double getRentalRate(){return rentalRate;}
    public void setRentalRate(double r){ if(r>=0) rentalRate=r; }
    public abstract double calculateRentalCost(int days);
}
interface Insurable { double calculateInsurance(); String getInsuranceDetails(); }
class Car extends Vehicle implements Insurable {
    private String policy;
    public Car(String num,double rate,String policy){ super(num,"Car",rate); this.policy=policy; }
    public double calculateRentalCost(int days){ return getRentalRate()*days; }
    public double calculateInsurance(){ return 1000; }
    public String getInsuranceDetails(){ return policy; }
}
class Bike extends Vehicle {
    public Bike(String num,double rate){ super(num,"Bike",rate); }
    public double calculateRentalCost(int days){ return getRentalRate()*days*0.6; }
}
class Truck extends Vehicle implements Insurable {
    private String policy;
    public Truck(String num,double rate,String policy){ super(num,"Truck",rate); this.policy=policy; }
    public double calculateRentalCost(int days){ return getRentalRate()*days*1.5; }
    public double calculateInsurance(){ return 3000; }
    public String getInsuranceDetails(){ return policy; }
}
public class VehicleRental {
    public static void main(String[] args){
        ArrayList<Vehicle> v=new ArrayList<>();
        v.add(new Car("KA01",2000,"POL123"));
        v.add(new Bike("KA02",800));
        v.add(new Truck("KA03",5000,"POL999"));
        for(Vehicle veh:v){
            System.out.println(veh.getVehicleNumber()+" "+veh.getType()+" rent:"+veh.calculateRentalCost(3));
            if(veh instanceof Insurable) System.out.println("Ins:"+((Insurable)veh).calculateInsurance());
        }
    }
}
