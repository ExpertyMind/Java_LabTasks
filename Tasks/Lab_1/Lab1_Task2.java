// Change the Series_Generator such that it can generate both increasing series or decreasing series depending on the starting and ending values.
package Tasks.Lab_1;

import java.util.*;

public class Lab1_Task2 {
    static void dec(int s, int e){
        for(; s >= e; s--) {
            System.out.print(s + " ");
        }
    }

    static void inc(int s, int e) {
        for(; s <= e; s++) {
            System.out.print(s + " ");
        }
    }

    static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int start, end;

        System.out.print("Enter a Starting number: ");
        start = input.nextInt();

        System.out.print("Enter Ending number: ");
        end = input.nextInt();

        if (start < end){
            inc(start, end);
        }
        else if (start > end) {
            dec(start, end);
        }
        else {
            System.out.print(start);
        }

    }
}
