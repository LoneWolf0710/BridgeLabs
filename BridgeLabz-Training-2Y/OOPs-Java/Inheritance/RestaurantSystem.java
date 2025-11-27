interface Worker {
    void performDuties();
}

class PersonR {
    String name;
    int id;

    PersonR(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class Chef extends PersonR implements Worker {
    Chef(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println(name + " cooks food.");
    }
}

class Waiter extends PersonR implements Worker {
    Waiter(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println(name + " serves customers.");
    }
}

public class RestaurantSystem {
    public static void main(String[] args) {
        Worker c = new Chef("Rahul", 1);
        Worker w = new Waiter("Sita", 2);

        c.performDuties();
        w.performDuties();
    }
}
