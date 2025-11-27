import java.util.*;

public class Q30_CustomerFeedbackAnalysis {

    public static void main(String[] args) {
        List<String> feedbackList = new ArrayList<>();
        feedbackList.add("Good service");
        feedbackList.add("Average experience");
        feedbackList.add("Good service"); // duplicate

        Set<String> uniqueFeedback = new LinkedHashSet<>(feedbackList);
        Queue<String> feedbackQueue = new LinkedList<>(uniqueFeedback);
        Stack<String> recentFeedback = new Stack<>();

        System.out.println("Processing feedback in order:");
        while (!feedbackQueue.isEmpty()) {
            String fb = feedbackQueue.remove();
            System.out.println("Processing: " + fb);
            recentFeedback.push(fb);
        }

        System.out.println("Recent feedbacks (stack): " + recentFeedback);
    }
}
