package Lab_2;

import java.util.Scanner;

public class Lab2_Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String fullName, Capital_Name;
        int len;

        System.out.print("Enter Your Full Name: ");
        fullName = input.nextLine().trim();

        len = fullName.length();

        System.out.println("Length: " + len);

        Capital_Name = fullName.toUpperCase();
        System.out.println(Capital_Name);

        System.out.println("Space at your name is: " + fullName.indexOf(" "));

        input.close();
    }
}
