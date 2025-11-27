import java.util.*;

class Question {
    String text;
    public Question(String text) { this.text = text; }
    @Override
    public String toString() { return text; }
}

class Student {
    String id;
    public Student(String id) { this.id = id; }
    @Override
    public String toString() { return id; }
}

public class Q18_OnlineExaminationManagementSystem {

    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Q1"));
        questions.add(new Question("Q2"));
        questions.add(new Question("Q3"));

        // randomize questions
        Collections.shuffle(questions);
        System.out.println("Randomized questions: " + questions);

        Set<String> studentIds = new HashSet<>();
        studentIds.add("S1");
        studentIds.add("S2");
        studentIds.add("S1"); // duplicate ignored

        System.out.println("Unique student IDs: " + studentIds);

        Queue<Student> examQueue = new LinkedList<>();
        examQueue.add(new Student("S1"));
        examQueue.add(new Student("S2"));

        Stack<Question> navigationStack = new Stack<>();
        for (Question q : questions) {
            navigationStack.push(q);
        }

        System.out.println("Serving students in queue:");
        while (!examQueue.isEmpty()) {
            Student s = examQueue.remove();
            System.out.println("Student: " + s + " is taking the test.");
        }

        System.out.println("Navigating questions (stack - LIFO):");
        while (!navigationStack.isEmpty()) {
            System.out.println("Showing: " + navigationStack.pop());
        }
    }
}
