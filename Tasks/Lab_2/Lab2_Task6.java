
package Tasks.Lab_2;

import java.util.*;

public class Lab2_Task6 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int method;
        String greeting = "Hello", firstName, lastName;

        System.out.print("First Name: ");
        firstName = input.next();

        System.out.print("Last Name: ");
        lastName = input.next();

        method = (int) (Math.random() * 2);

        switch (method){
            case 0:
                System.out.println("First Greeting");
                System.out.println(greeting + " " + firstName + " " + lastName);
                break;
            case 1:
                System.out.println("Second Greeting");
                System.out.println(greeting.concat(" ").concat(firstName).concat(" ").concat(lastName));
                break;
        }

        input.close();
    }
}
