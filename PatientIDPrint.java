import java.util.*;

public class PatientIDPrint {
    public static void main(String[] args) {

        List<String> patientIDs = Arrays.asList(
                "P1001", "P1002", "P1003", "P1004", "P1005"
        );

        System.out.println("=== Patient ID List ===");

        patientIDs.forEach(System.out::println);
    }
}
