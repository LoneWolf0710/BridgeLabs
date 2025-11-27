public class Main {
    public static void main(String[] args) {
        Student student = new Student("John", 101);
        student.addSubject(new Subject("Maths", 90));
        student.addSubject(new Subject("Science", 85));

        GradeCalculator calculator = new GradeCalculator();
        String grade = calculator.calculateGrade(student);

        System.out.println("Student: " + student.getName());
        System.out.println("Roll No: " + student.getRollNo());
        for (Subject s : student.getSubjects()) {
            System.out.println("Subject: " + s.getName() + ", Marks: " + s.getMarks());
        }
        System.out.println("Final Grade: " + grade);
    }
}