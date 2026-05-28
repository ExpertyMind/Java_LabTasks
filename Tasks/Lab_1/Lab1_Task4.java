// 4. You are interested in calculating your electricity bill of your home. You know the unit consumption of your home. Billing criteria for electric company is that it charges 5 Rs/ unit for first 100 units, next 100 units are charged at 7 Rs/unit and above that charge is 15 Rs/unit. As input, you get total_Units consumed and generate bill.
package Tasks.Lab_1;

import java.util.*;

public class Lab1_Task4 {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float bill, units;

        System.out.print("Enter a Units Consumed: ");
        units = input.nextFloat();

        if (units >= 0) {
            if (units < 100.0f) {
                bill = units * 5.0f;
            }

            else if (units <= 200 && units >= 100.0) {
                bill = 100.0f * 5.0f + (units - 100) * 7.0f;
            }

            else {
                bill = 100.0f * 5.0f + 100 * 7.0f + (units - 200.0f) * 15.0f;
            }

            System.out.println("Bill: " + bill);
        }

        else {
            System.out.println("Negative Numbers are not allowed");
        }

    }
}
