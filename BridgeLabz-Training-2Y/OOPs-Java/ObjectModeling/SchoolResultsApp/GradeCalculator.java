public class GradeCalculator {
    public String calculateGrade(Student student) {
        int total = 0;
        for (Subject subject : student.getSubjects()) {
            total += subject.getMarks();
        }
        double average = (double) total / student.getSubjects().size();

        if (average >= 90) return "A";
        else if (average >= 75) return "B";
        else if (average >= 50) return "C";
        else return "D";
    }
}