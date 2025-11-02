import java.util.*;

class Light {
    void turnOn() {
        System.out.println("Light is ON");
    }
    void turnOff() {
        System.out.println("Light is OFF");
    }
    void dim() {
        System.out.println("Light is dimmed to 30%");
    }
    void partyMode() {
        System.out.println("Party Mode: Flashing Lights!");
    }
}

public class SmartHome {
    public static void main(String[] args) {

        Light light = new Light();

        Map<String, Runnable> actions = new HashMap<>();

        actions.put("motion", () -> {
            System.out.println("[Trigger: Motion]");
            light.turnOn();
        });

        actions.put("evening", () -> {
            System.out.println("[Trigger: Time = Evening]");
            light.dim();
        });

        actions.put("voice_party", () -> {
            System.out.println("[Trigger: Voice Command: Party]");
            light.partyMode();
        });

        actions.put("no_motion", () -> {
            System.out.println("[Trigger: No motion]");
            light.turnOff();
        });


        actions.get("motion").run();
        actions.get("evening").run();
        actions.get("voice_party").run();
        actions.get("no_motion").run();
    }
}
