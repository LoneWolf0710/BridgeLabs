import java.util.ArrayList;
abstract class RHVehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    public RHVehicle(String vehicleId,String driverName,double ratePerKm){this.vehicleId=vehicleId;this.driverName=driverName;this.ratePerKm=ratePerKm;}
    public String getVehicleId(){return vehicleId;}
    public String getDriverName(){return driverName;}
    public double getRatePerKm(){return ratePerKm;}
    public abstract double calculateFare(double distance);
    public String getVehicleDetails(){ return vehicleId+" "+driverName+" "+ratePerKm; }
}
interface GPS { String getCurrentLocation(); void updateLocation(String loc); }
class CarRide extends RHVehicle implements GPS {
    private String loc="Unknown";
    public CarRide(String id,String driver,double rate){ super(id,driver,rate); }
    public double calculateFare(double distance){ return getRatePerKm()*distance; }
    public String getCurrentLocation(){ return loc; }
    public void updateLocation(String l){ loc=l; }
}
class BikeRide extends RHVehicle implements GPS {
    private String loc="Unknown";
    public BikeRide(String id,String driver,double rate){ super(id,driver,rate); }
    public double calculateFare(double distance){ return getRatePerKm()*distance*0.7; }
    public String getCurrentLocation(){ return loc; }
    public void updateLocation(String l){ loc=l; }
}
class AutoRide extends RHVehicle implements GPS {
    private String loc="Unknown";
    public AutoRide(String id,String driver,double rate){ super(id,driver,rate); }
    public double calculateFare(double distance){ return getRatePerKm()*distance*0.6; }
    public String getCurrentLocation(){ return loc; }
    public void updateLocation(String l){ loc=l; }
}
public class RideHailingApp {
    public static void main(String[] args){
        ArrayList<RHVehicle> rides=new ArrayList<>();
        CarRide c=new CarRide("V1","Kiran",15);
        BikeRide b=new BikeRide("V2","Tina",10);
        AutoRide a=new AutoRide("V3","Deep",8);
        c.updateLocation("MG Road");
        b.updateLocation("Park");
        a.updateLocation("Station");
        rides.add(c); rides.add(b); rides.add(a);
        for(RHVehicle r:rides) System.out.println(r.getVehicleId()+" fare(10km):"+r.calculateFare(10));
    }
}
