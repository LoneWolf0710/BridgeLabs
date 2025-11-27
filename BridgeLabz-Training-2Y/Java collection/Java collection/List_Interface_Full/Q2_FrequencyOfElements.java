import java.util.*;

public class Q2_FrequencyOfElements {

    public static Map<String, Integer> findFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String s : list) {
            frequencyMap.put(s, frequencyMap.getOrDefault(s, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> freq = findFrequency(fruits);
        System.out.println("Input : " + fruits);
        System.out.println("Frequency Map : " + freq);
    }
}
