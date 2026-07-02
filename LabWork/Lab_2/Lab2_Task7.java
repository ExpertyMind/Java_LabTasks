package Lab_2;

import java.util.Scanner;

public class Lab2_Task7 {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the current Hour: ");
        int hour = input.nextInt();


        if ((5 <= hour) && (hour <= 11)) {
            System.out.print("Good Morning");
        }

        else if ((12 <= hour) && (hour <= 17)) {
            System.out.println("Good Afternoon");
        }

        else if ((18 <= hour) && (hour <= 23)) {
            System.out.println("Good Evening");
        }

        else {
            System.out.println("Invalid Hour");
        }

        input.close();
    }

}
