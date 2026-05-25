package Lab_Work.LAB_1;
import java.util.Scanner;

public class Lab1_Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Total marks: ");
        double total = input.nextDouble();

        System.out.print("Enter Obtained marks: ");
        double obtained = input.nextDouble();

        GradeCalculator calc = new GradeCalculator(total, obtained);
        System.out.println("Your Percentage is: " + calc.getPercentage());
        calc.printGrade();

    }
}

class GradeCalculator {
    private double totalMarks;
    private double obtainedMarks;
    private double percentage;

    public GradeCalculator(double totalMarks, double obtainedMarks) {
        this.totalMarks = totalMarks;
        this.obtainedMarks = obtainedMarks;
        this.percentage = (obtainedMarks * 100) / totalMarks;
    }

    public double getPercentage() {
        return percentage;
    }

    public void printGrade() {
        if (percentage >= 90) System.out.println("Your grade is: A");
        else if (percentage >= 85) System.out.println("Your grade is: A-");
        else if (percentage >= 80) System.out.println("Your grade is: B+");
        else if (percentage >= 75) System.out.println("Your grade is: B");
        else if (percentage >= 70) System.out.println("Your grade is: B-");
        else if (percentage > 65) System.out.println("Your grade is: C+");
        else if (percentage > 60) System.out.println("Your grade is: C");
        else if (percentage > 55) System.out.println("Your grade is: C-");
        else if (percentage > 50) System.out.println("Your grade is: D");
        else System.out.println("Your grade is: F");
    }
}