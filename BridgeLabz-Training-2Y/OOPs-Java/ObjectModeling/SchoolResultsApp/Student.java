import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int rollNo;
    private List<Subject> subjects;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
        this.subjects = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }
}