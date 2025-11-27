import java.util.*;

public class Q3_RotateList {

    public static <T> void rotate(List<T> list, int k) {
        int n = list.size();
        if (n == 0) return;
        k = k % n;
        if (k < 0) k += n; // handle negative rotations

        List<T> rotated = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            rotated.add(list.get((i + k) % n));
        }
        // copy back
        for (int i = 0; i < n; i++) {
            list.set(i, rotated.get(i));
        }
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("Original List: " + nums);
        rotate(nums, 2);
        System.out.println("Rotated by 2   : " + nums); // [30, 40, 50, 10, 20]
    }
}
