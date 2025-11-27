import java.util.*;

public class Q12_ReverseQueue {

    public static <T> void reverse(Queue<T> queue) {
        Stack<T> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        System.out.println("Original queue: " + q);
        reverse(q);
        System.out.println("Reversed queue: " + q); // [30,20,10]
    }
}
