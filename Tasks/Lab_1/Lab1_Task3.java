// 3. Write a Program that takes year as an input from user and determine if it’s a leap year or not.
package Tasks.Lab_1;

import java.util.*;

public class Lab1_Task3 {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year;

        System.out.print("Enter a year: ");
        year = input.nextInt();

        System.out.println(year % 4 == 0 ? "It is a Leap Year" : "It's not a Leap Year");

    }
}
