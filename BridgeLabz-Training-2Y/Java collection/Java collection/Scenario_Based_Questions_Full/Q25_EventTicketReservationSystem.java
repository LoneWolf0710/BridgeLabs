import java.util.*;

class Booking {
    String userId;
    boolean vip;
    public Booking(String userId, boolean vip) { this.userId = userId; this.vip = vip; }
    @Override
    public String toString() { return userId + (vip ? " (VIP)" : ""); }
}

public class Q25_EventTicketReservationSystem {

    public static void main(String[] args) {
        List<Booking> bookings = new ArrayList<>();
        Set<String> registeredUsers = new HashSet<>();
        Queue<Booking> bookingQueue = new LinkedList<>();
        PriorityQueue<Booking> vipQueue =
                new PriorityQueue<>(Comparator.comparing(b -> !b.vip)); // VIP first

        Booking b1 = new Booking("U1", false);
        Booking b2 = new Booking("U2", true);
        Booking b3 = new Booking("U1", true); // duplicate user

        if (registeredUsers.add(b1.userId)) {
            bookingQueue.add(b1);
            bookings.add(b1);
        }
        if (registeredUsers.add(b2.userId)) {
            bookingQueue.add(b2);
            bookings.add(b2);
        } else {
            System.out.println("Duplicate user ignored: " + b3.userId);
        }

        vipQueue.addAll(bookings);

        System.out.println("VIP priority processing:");
        while (!vipQueue.isEmpty()) {
            System.out.println("Confirming: " + vipQueue.poll());
        }

        System.out.println("All bookings list: " + bookings);
    }
}
