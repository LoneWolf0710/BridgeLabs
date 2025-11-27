import java.util.*;

class CircularBuffer {
    private int[] buffer;
    private int head = 0; // points to oldest
    private int size = 0;

    public CircularBuffer(int capacity) {
        buffer = new int[capacity];
    }

    public void add(int value) {
        int tail = (head + size) % buffer.length;
        if (size < buffer.length) {
            buffer[tail] = value;
            size++;
        } else {
            // overwrite oldest element
            buffer[head] = value;
            head = (head + 1) % buffer.length;
        }
    }

    public List<Integer> getElements() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(buffer[(head + i) % buffer.length]);
        }
        return list;
    }
}

public class Q16_CircularBufferSimulation {

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.add(1);
        cb.add(2);
        cb.add(3);
        System.out.println("Buffer: " + cb.getElements());
        cb.add(4);
        System.out.println("After adding 4 (overwrite oldest): " + cb.getElements()); // [2,3,4]
    }
}
