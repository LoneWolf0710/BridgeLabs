import java.util.*;

class PatientRecord {
    String name;
    public PatientRecord(String name) { this.name = name; }
    @Override
    public String toString() { return name; }
}

public class Q26_HospitalPatientManagementSystem {

    public static void main(String[] args) {
        Set<PatientRecord> admitted = new HashSet<>();
        Queue<PatientRecord> waiting = new LinkedList<>();
        Stack<PatientRecord> dischargedStack = new Stack<>();
        List<PatientRecord> history = new ArrayList<>();

        PatientRecord p1 = new PatientRecord("Alice");
        PatientRecord p2 = new PatientRecord("Bob");

        admitted.add(p1);
        admitted.add(p2);
        waiting.add(p1);
        waiting.add(p2);

        System.out.println("Treating patients in order of arrival:");
        while (!waiting.isEmpty()) {
            PatientRecord p = waiting.remove();
            System.out.println("Treating: " + p);
            dischargedStack.push(p);
            history.add(p);
        }

        System.out.println("Recently discharged: " + dischargedStack);

        System.out.println("Re-admitting last discharged:");
        if (!dischargedStack.isEmpty()) {
            PatientRecord last = dischargedStack.pop();
            admitted.add(last);
            waiting.add(last);
            System.out.println("Re-admitted: " + last);
        }

        System.out.println("Total patient history: " + history);
    }
}
