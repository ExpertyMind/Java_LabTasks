// 5. Write a program that takes an integer n from command-line arguments and uses a while loop to compute the number of times you need to divide n by 2 until it is strictly less than 1. Print the error message "Illegal input" if n is negative.
package Lab_1;

import java.util.Scanner;

public class Lab1_Task5 {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float n, temp;
        int count = 0;

        System.out.print("Enter a num: ");
        n = input.nextFloat();
        temp = n;

        if (n < 0) {
            System.out.println("Illegal input");
            return;
        }

        while (temp >= 1){
            temp = temp/2;
            ++count;
        }

        System.out.println("Div: " + count);

    }
}