class Vehicle {
    int maxSpeed;
    String fuelType;

    Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    void displayInfo() {
        System.out.println("Vehicle -> Speed: " + maxSpeed + " km/h, Fuel: " + fuelType);
    }
}

class Car extends Vehicle {
    int seatCapacity;

    Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Car Seat Capacity: " + seatCapacity);
    }
}

class Truck extends Vehicle {
    int cargoCapacity;

    Truck(int maxSpeed, String fuelType, int cargoCapacity) {
        super(maxSpeed, fuelType);
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Truck Cargo Capacity: " + cargoCapacity + " tons");
    }
}

class Motorcycle extends Vehicle {
    String type;

    Motorcycle(int maxSpeed, String fuelType, String type) {
        super(maxSpeed, fuelType);
        this.type = type;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Motorcycle Type: " + type);
    }
}

public class VehicleSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car(180, "Petrol", 5),
            new Truck(120, "Diesel", 10),
            new Motorcycle(150, "Petrol", "Sport")
        };

        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println();
        }
    }
}
