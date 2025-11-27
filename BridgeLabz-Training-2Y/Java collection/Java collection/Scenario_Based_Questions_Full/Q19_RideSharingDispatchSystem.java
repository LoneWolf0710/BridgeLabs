import java.util.*;

class RideRequest {
    String id;
    int priority; // higher -> more urgent
    public RideRequest(String id, int priority) { this.id = id; this.priority = priority; }
    @Override
    public String toString() { return id + "(priority=" + priority + ")"; }
}

class Driver {
    String name;
    public Driver(String name) { this.name = name; }
    @Override
    public String toString() { return name; }
}

class Ride {
    RideRequest request;
    Driver driver;
    public Ride(RideRequest request, Driver driver) { this.request = request; this.driver = driver; }
    @Override
    public String toString() { return "Ride{" + request + " -> " + driver + "}"; }
}

public class Q19_RideSharingDispatchSystem {

    public static void main(String[] args) {
        Queue<RideRequest> normalQueue = new LinkedList<>();
        PriorityQueue<RideRequest> priorityQueue =
                new PriorityQueue<>(Comparator.comparingInt(r -> -r.priority));

        normalQueue.add(new RideRequest("R1", 1));
        normalQueue.add(new RideRequest("R2", 2));

        priorityQueue.add(new RideRequest("R3", 5));
        priorityQueue.add(new RideRequest("R4", 3));

        Set<Driver> drivers = new HashSet<>();
        drivers.add(new Driver("D1"));
        drivers.add(new Driver("D2"));

        List<Ride> completedRides = new ArrayList<>();

        Iterator<Driver> driverIterator = drivers.iterator();

        System.out.println("Handling high-priority requests first:");
        while (!priorityQueue.isEmpty() && driverIterator.hasNext()) {
            RideRequest req = priorityQueue.poll();
            Driver d = driverIterator.next();
            Ride ride = new Ride(req, d);
            completedRides.add(ride);
            System.out.println("Assigned " + ride);
        }

        System.out.println("Completed rides: " + completedRides);
    }
}
