import java.util.*;

public class Q1_ReverseList {

    // Generic reverse method for any List type
    public static <T> void reverse(List<T> list) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Original ArrayList: " + arrayList);
        reverse(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList);

        List<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Original LinkedList: " + linkedList);
        reverse(linkedList);
        System.out.println("Reversed LinkedList: " + linkedList);
    }
}
