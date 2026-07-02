package Lab_6;
import java.util.Scanner;

public class Lab6_Task4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Total marks: ");
        double total = input.nextDouble();

        System.out.print("Enter Obtained marks: ");
        double obtained = input.nextDouble();

        SimplePercentage calc = new SimplePercentage(total, obtained);
        System.out.println("Your percentage is: " + calc.getFinalResult());
    }
}

class SimplePercentage {
    private double totalMarks;
    private double obtainedMarks;
    private double result;

    public SimplePercentage(double totalMarks, double obtainedMarks) {
        this.totalMarks = totalMarks;
        this.obtainedMarks = obtainedMarks;
        this.result = (obtainedMarks * 100) / totalMarks;
    }

    public double getFinalResult() {
        return result;
    }
}