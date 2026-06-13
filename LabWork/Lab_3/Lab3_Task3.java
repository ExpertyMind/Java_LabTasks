package Lab_3;

import java.util.Scanner;

public class Lab3_Task3 {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float monthly_salary, portion_saved, total_cost, portion_down_payment, current_savings = 0f, r = 0.04f;
        int count_months = 0;

        System.out.print("Enter your monthly salary: ");
        monthly_salary = input.nextFloat();

        System.out.print("Enter the percent of your salary to save: ");
        portion_saved = input.nextFloat()/100.0f;

        System.out.print("Enter the cost of your dream home: ");
        total_cost = input.nextFloat();

        portion_down_payment = 0.25f * total_cost;

        while (current_savings < portion_down_payment){
            count_months++;
            current_savings += monthly_salary * portion_saved;
            current_savings += current_savings*(r/12);
        }

        System.out.print("Number of months: " + count_months);

    }
}
