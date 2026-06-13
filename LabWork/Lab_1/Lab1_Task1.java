// 1. Change the Factorial code discussed in class so that it shows proper messaging in case of negative numbers.

package Lab_1;

import java.util.Scanner;

public class Lab1_Task1 {
    static int fac(int n) {

        int result = 1;
        int i = 1;

        while (i <= n){
            result = result * i;
            ++i;
        }

        return result;
        // SECOND METHOD
//        if (n == 0 || n == 1) {
//            return 1.0F;
//        }
//
//        return n * (n - 1.0f);

    }

    static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int user_input;
        System.out.print("Enter a number to calculate the factorial: ");
        user_input = input.nextInt();

        if (user_input < 0) {
            System.out.print("There's No Factorial for Negative");
            return;
        };

        System.out.println("Factorial of " + user_input + " is: " + fac(user_input));

    }
}