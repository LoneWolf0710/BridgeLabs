import java.util.*;

class Alert {
    String message;
    String type;

    Alert(String message, String type) {
        this.message = message;
        this.type = type;
    }

    void display() {
        System.out.println(type.toUpperCase() + " ALERT: " + message);
    }
}

public class NotificationFilter {
    public static void main(String[] args) {

        List<Alert> alerts = Arrays.asList(
                new Alert("Patient heart rate abnormal", "critical"),
                new Alert("New lab report available", "lab"),
                new Alert("Time for medication", "medication"),
                new Alert("General notice from hospital", "normal")
        );

        System.out.println("=== Alerts Shown to User ===");
        alerts.stream()
                .filter(alert -> alert.type.equals("critical") || alert.type.equals("medication"))
                .forEach(Alert::display);
    }
}
