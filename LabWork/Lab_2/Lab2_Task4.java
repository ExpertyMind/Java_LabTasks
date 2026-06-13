package Lab_2;

import java.util.Scanner;

public class Lab2_Task4 {

    static Scanner input = new Scanner(System.in);

    static boolean ID_check() {
        System.out.print("Do you have ID? (Yes OR No) \n> ");
        return input.next().equalsIgnoreCase("yes");
    }

    static boolean age() {
        System.out.print("Are you 18 or above? (Yes OR No) \n> ");
        return input.next().equalsIgnoreCase("yes");
    }

    public static void main(String[] args) {
        boolean hasID, isOver18;

        hasID = ID_check();
        isOver18 = age();

        if (hasID && isOver18) {
            System.out.print("Access Granted");
        }

        else if (hasID || isOver18) {
            System.out.print("Special Guest");
        }

        else {
            System.out.print("Sorry! Not Allowed");
        }

        input.close();
    }

}
