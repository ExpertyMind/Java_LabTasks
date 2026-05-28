package Tasks.Lab_2;

import java.util.Scanner;

public class Lab2_Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double radius, area;

        System.out.print("Radius of circle: ");
        radius = input.nextDouble();
        area = Math.PI * Math.pow(radius, 2);

        System.out.printf("Area = %.4f\n", area);
        System.out.println("Area (in integer) = " + (int) area);


        input.close();
    }
}