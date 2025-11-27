import java.time.*;
import java.util.*;

class Policy {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate,
                  String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public String getPolicyholderName() { return policyholderName; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }
    public double getPremiumAmount() { return premiumAmount; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        Policy policy = (Policy) o;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "number='" + policyNumber + ''' +
                ", name='" + policyholderName + ''' +
                ", expiry=" + expiryDate +
                ", coverage='" + coverageType + ''' +
                ", premium=" + premiumAmount +
                '}';
    }
}

public class Q11_InsurancePolicyManagementSystem {

    public static void main(String[] args) {
        // Sample policies
        Policy p1 = new Policy("P001", "Alice", LocalDate.now().plusDays(10), "Health", 5000);
        Policy p2 = new Policy("P002", "Bob", LocalDate.now().plusDays(40), "Auto", 3000);
        Policy p3 = new Policy("P003", "Charlie", LocalDate.now().plusDays(20), "Home", 4500);
        Policy p4 = new Policy("P001", "Alice Duplicate", LocalDate.now().plusDays(15), "Health", 5200);

        // 1. Store in different sets
        Set<Policy> hashSet = new HashSet<>();
        Set<Policy> linkedHashSet = new LinkedHashSet<>();
        Set<Policy> treeSet = new TreeSet<>(Comparator.comparing(Policy::getExpiryDate));

        List<Policy> all = Arrays.asList(p1, p2, p3, p4);

        // measure performance roughly
        addAll("HashSet", hashSet, all);
        addAll("LinkedHashSet", linkedHashSet, all);
        addAll("TreeSet", treeSet, all);

        System.out.println("\nAll unique policies (HashSet):");
        hashSet.forEach(System.out::println);

        // 2.a Policies expiring within 30 days
        System.out.println("\nPolicies expiring within 30 days (TreeSet by expiry):");
        LocalDate now = LocalDate.now();
        for (Policy p : treeSet) {
            long days = Duration.between(now.atStartOfDay(), p.getExpiryDate().atStartOfDay()).toDays();
            if (days <= 30) {
                System.out.println(p);
            }
        }

        // 2.b Policies with specific coverage type
        String coverageType = "Health";
        System.out.println("\nPolicies with coverage type = " + coverageType + ":");
        for (Policy p : hashSet) {
            if (p.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(p);
            }
        }

        // 2.c Duplicate policies based on policy number
        System.out.println("\nDuplicate policies based on policy number:");
        Map<String, Integer> countByNumber = new HashMap<>();
        for (Policy p : all) {
            countByNumber.put(p.getPolicyNumber(), countByNumber.getOrDefault(p.getPolicyNumber(), 0) + 1);
        }
        for (Map.Entry<String, Integer> e : countByNumber.entrySet()) {
            if (e.getValue() > 1) {
                System.out.println("Policy number " + e.getKey() + " appears " + e.getValue() + " times");
            }
        }
    }

    private static void addAll(String name, Set<Policy> set, List<Policy> policies) {
        long start = System.nanoTime();
        for (Policy p : policies) {
            set.add(p);
        }
        long end = System.nanoTime();
        System.out.println(name + " - time to add: " + (end - start) + " ns, size: " + set.size());
    }
}
