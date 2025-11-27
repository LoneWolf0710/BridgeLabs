import java.util.*;

public class Q8_SymmetricDifference {

    public static <T> Set<T> symmetricDifference(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        for (T x : b) {
            if (!result.add(x)) {
                // if already present, remove it → means it was in both
                result.remove(x);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        Set<Integer> symDiff = symmetricDifference(set1, set2);
        System.out.println("Set1 : " + set1);
        System.out.println("Set2 : " + set2);
        System.out.println("Symmetric difference: " + symDiff); // [1, 2, 4, 5]
    }
}
