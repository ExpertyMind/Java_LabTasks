// 6. Write a code that takes a number value from user and displays the inverse of it. Number can be of any length.

package Lab_1;

import java.util.Scanner;

public class Lab1_Task6 {

    static int revNum(int n){
        int temp = n, digit, rev = 0;


        while (temp > 0){
            digit = temp % 10;
            rev = rev * 10 + digit;
            temp /= 10;
        }

        return rev;
    }

    static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num;
        System.out.print("Enter a Number to Reverse: ");
        num = input.nextInt();

        if (num >= 0) {
            System.out.println("Inverse: " + revNum(num));
        }
        else
        {
            System.out.println("Inverse: " + revNum(num * -1) * -1);
        }
    }


    // Second Method

    static int rev(int n){
        return rev(n, 0);
    }

    private static int rev(int n, int res){
        if (n <= 0){
            return res;
        }
        return rev(n/10, res * 10 + (n % 10));
    }

}
