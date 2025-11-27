import java.util.*;

public class Q5_NthFromEnd {

    // Find Nth element from end of LinkedList without using size()
    public static <T> T nthFromEnd(LinkedList<T> list, int n) {
        if (n <= 0) throw new IllegalArgumentException("n must be positive");

        Iterator<T> fast = list.iterator();
        Iterator<T> slow = list.iterator();

        for (int i = 0; i < n; i++) {
            if (!fast.hasNext()) {
                throw new IllegalArgumentException("n is larger than list size");
            }
            fast.next();
        }

        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        return slow.next();
    }

    public static void main(String[] args) {
        LinkedList<String> letters = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2;
        String result = nthFromEnd(letters, n);
        System.out.println("List : " + letters);
        System.out.println("N = " + n + ", Nth from end = " + result); // D
    }
}
