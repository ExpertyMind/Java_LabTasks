package Lab_Work.LAB_1;

class StudentRecord {
    private String fullName;
    private int studentId;

    public StudentRecord(String fullName, int studentId) {
        this.fullName = fullName;
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}

public class Lab1_Task1 {
    public static void main(String[] args) {
        StudentRecord student = new StudentRecord("Hashim Ahmed", 134);
        System.out.println("Name: " + student.getFullName() + " <|> ID: " + student.getStudentId());

        student.setFullName("Fahad");
        student.setStudentId(155);
        System.out.println("Name: " + student.getFullName() + " <|> ID: " + student.getStudentId());
    }
}