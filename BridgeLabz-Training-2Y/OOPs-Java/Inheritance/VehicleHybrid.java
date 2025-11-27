interface Refuelable {
    void refuel();
}

class VehicleH {
    int maxSpeed;
    String model;

    VehicleH(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }
}

class ElectricVehicle extends VehicleH {
    ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    void charge() {
        System.out.println(model + " is charging.");
    }
}

class PetrolVehicle extends VehicleH implements Refuelable {
    PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    public void refuel() {
        System.out.println(model + " is refueling.");
    }
}

public class VehicleHybrid {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle(160, "Tesla");
        PetrolVehicle pv = new PetrolVehicle(180, "Honda");

        ev.charge();
        pv.refuel();
    }
}
