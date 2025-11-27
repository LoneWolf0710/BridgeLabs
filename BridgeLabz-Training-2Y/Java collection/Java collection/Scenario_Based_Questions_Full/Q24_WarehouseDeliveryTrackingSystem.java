import java.util.*;

class PackageItem {
    String id;
    boolean delivered;
    boolean returned;
    public PackageItem(String id) { this.id = id; }
    @Override
    public String toString() { return id + " (delivered=" + delivered + ", returned=" + returned + ")"; }
}

public class Q24_WarehouseDeliveryTrackingSystem {

    public static void main(String[] args) {
        Queue<PackageItem> pending = new LinkedList<>();
        Set<String> packageIds = new HashSet<>();
        List<PackageItem> deliveredList = new ArrayList<>();
        Stack<PackageItem> returnedStack = new Stack<>();

        PackageItem p1 = new PackageItem("PKG1");
        PackageItem p2 = new PackageItem("PKG2");

        if (packageIds.add(p1.id)) pending.add(p1);
        if (packageIds.add(p2.id)) pending.add(p2);

        while (!pending.isEmpty()) {
            PackageItem p = pending.remove();
            // simulate: first delivered, second returned
            if (p.id.equals("PKG1")) {
                p.delivered = true;
                deliveredList.add(p);
            } else {
                p.returned = true;
                returnedStack.push(p);
            }
        }

        System.out.println("Delivered: " + deliveredList);
        System.out.println("Returned stack: " + returnedStack);
    }
}
