import java.util.*;

class Parcel {
    String id;
    int priority; // higher -> more urgent
    public Parcel(String id, int priority) { this.id = id; this.priority = priority; }
    @Override
    public String toString() { return id + "(priority=" + priority + ")"; }
}

public class Q28_CourierDeliveryRoutingSystem {

    public static void main(String[] args) {
        PriorityQueue<Parcel> priorityQueue =
                new PriorityQueue<>(Comparator.comparingInt(p -> -p.priority));
        Set<String> assignedIds = new HashSet<>();
        List<Parcel> completed = new ArrayList<>();
        Queue<Parcel> normalQueue = new LinkedList<>();

        Parcel p1 = new Parcel("P1", 5);
        Parcel p2 = new Parcel("P2", 2);
        Parcel p3 = new Parcel("P3", 4);

        priorityQueue.add(p1);
        normalQueue.add(p2);
        priorityQueue.add(p3);

        while (!priorityQueue.isEmpty()) {
            Parcel p = priorityQueue.poll();
            if (assignedIds.add(p.id)) {
                completed.add(p);
                System.out.println("High priority delivered: " + p);
            }
        }

        while (!normalQueue.isEmpty()) {
            Parcel p = normalQueue.poll();
            if (assignedIds.add(p.id)) {
                completed.add(p);
                System.out.println("Normal delivered: " + p);
            }
        }

        System.out.println("Completed deliveries: " + completed);
    }
}
