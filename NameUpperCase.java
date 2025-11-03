import java.util.*;

public class NameUpperCase {
    public static void main(String[] args) {

        List<String> employees = Arrays.asList(
                "Amit", "Sahana", "Rohan", "Isha", "Kunal"
        );

        System.out.println("=== Employee Names in Uppercase ===");

        employees.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
