import java.util.*;

class Student {
    String name;
    int marks;
    public Student(String name, int marks) { this.name = name; this.marks = marks; }
    @Override
    public String toString() { return name + " (" + marks + ")"; }
}

public class Q23_CollegeAdmissionSystem {

    public static void main(String[] args) {
        List<Student> applicants = new ArrayList<>();
        applicants.add(new Student("Alice", 90));
        applicants.add(new Student("Bob", 75));
        applicants.add(new Student("Charlie", 85));

        Set<Student> shortlisted = new HashSet<>();
        for (Student s : applicants) {
            if (s.marks >= 80) shortlisted.add(s);
        }

        Queue<Student> interviewQueue = new LinkedList<>(shortlisted);

        TreeSet<Student> meritList = new TreeSet<>(Comparator.comparingInt(s -> -s.marks));
        meritList.addAll(shortlisted);

        System.out.println("Applicants: " + applicants);
        System.out.println("Shortlisted: " + shortlisted);
        System.out.println("Interview queue: " + interviewQueue);
        System.out.println("Final merit list: " + meritList);
    }
}
