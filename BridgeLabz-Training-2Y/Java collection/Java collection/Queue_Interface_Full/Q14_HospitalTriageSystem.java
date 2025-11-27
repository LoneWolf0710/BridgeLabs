import java.util.*;

class Patient {
    private String name;
    private int severity; // higher value = more severe

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String getName() { return name; }
    public int getSeverity() { return severity; }

    @Override
    public String toString() {
        return name + " (severity=" + severity + ")";
    }
}

public class Q14_HospitalTriageSystem {

    public static void main(String[] args) {
        PriorityQueue<Patient> triageQueue =
                new PriorityQueue<>(Comparator.comparingInt(Patient::getSeverity).reversed());

        triageQueue.add(new Patient("John", 3));
        triageQueue.add(new Patient("Alice", 5));
        triageQueue.add(new Patient("Bob", 2));

        System.out.println("Patients will be treated in this order:");
        while (!triageQueue.isEmpty()) {
            System.out.println(triageQueue.poll());
        }
    }
}
