package Lab_4;

import java.util.Random;
import java.util.Scanner;

public class Lab4_Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print(
                """
                *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
                Welcome to The Bank Of Punjab
                *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
                
                """
        );

        Bank customer = new Bank();
        boolean running = true;


        while (running) {
            System.out.println("\n========================================");
            System.out.println("              MAIN MENU");
            System.out.println("========================================");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    customer.balance();
                    break;
                case 2:
                    customer.deposit();
                    break;
                case 3:
                    customer.withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using The Bank Of Punjab. Goodbye.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }

    }
}



class Bank {

    static Scanner input = new Scanner(System.in);
    static Random ran = new Random();

    // Data
    private final String acc_name;
    private final int acc_no;
    private final int pin;
    private float amount = 0.0f;

    // Starting Menu
    Bank(){
        System.out.println(
                "==========> Let's Create Your Account First <==========\n" +
                        "-------------------------------------------------------"
        );
        System.out.print("Enter Your Account Name for Your Bank Account\n" +
                "> ");

        acc_name = input.nextLine();
        acc_no = ran.nextInt(100000,1000000);
        pin = PIN();

        input.nextLine();

        Account_Created();

    }

    void Account_Created(){
        System.out.println("\n====> ACCOUNT CREATED SUCCESSFULLY <====");
        System.out.println("\n========================================");
        System.out.println("        ACCOUNT CREATED SUCCESSFULLY");
        System.out.println("========================================\n");

        System.out.printf("Account Name : %s%n", acc_name);
        System.out.printf("Account ID   : %d%n", acc_no);
        System.out.printf("Account PIN  : %d%n             [DON'T SHARE WITH ANYONE]", pin);

        System.out.println("\n========================================");
        System.out.println("⚠ Do NOT share your credentials.");
        System.out.println("========================================\n");
    }

    int PIN(){
        int pin;

        while (true) {

            System.out.print("Enter Four Number PIN for Your Bank Account\n" +
                    "> ");

            pin = input.nextInt();

            if (String.valueOf(pin).length() == 4) {
                return pin;
            }

            input.nextLine();
            System.out.println("---> Please Enter 4 Numbered Pin [4 NUMBERS ONLY]");
        }

    }

    boolean pin_check(){
        int pin;

        for (int i = 1; i < 4; i++) {

            System.out.print("Enter Pin: ");
            pin = input.nextInt();
            input.nextLine();

            if(pin == this.pin){
                return true;
            }
            else {
                System.out.println("Wrong Pin Entered! \nEnter Pin Again.");
            }
        }
        return false;
    }

    // BALANCE
    void balance() {
        if (pin_check()) {
            System.out.println("Current Balance: " + amount + "$");
        }
        else {
            System.out.println("Sorry Wrong Pin");
        }

    }

    // DEPOSIT
    void deposit(){
        float money = 0.0f;
        System.out.println("MINIMUM DEPOSIT [10$]");
        while (true){
            System.out.println("Enter Amount to Deposit: ");
            money = input.nextFloat();
            input.nextLine();

            if (money >= 10.0f){
                if(pin_check()) {
                    this.amount = this.amount + money;
                    break;
                }
                else {
                    System.out.println("Sorry Wrong Pin");
                    return;
                }
            }
            else {
                System.out.println("Enter an amount of 10$ or more");
            }
        }
    }


    // WITHDRAW
    void withdraw(){
        float money = 0.0f;
        while (true){
            System.out.println("Enter Amount to Withdraw: ");
            money = input.nextFloat();
            input.nextLine();

            if (money < 0.0f) {
                System.out.println("Enter a valid positive amount.");
            } else if (this.amount - money < 0) {
                System.out.println("Insufficient Funds.");
            } else {
                if(pin_check()) {
                    this.amount = this.amount - money;
                    break;
                }
                else {
                    System.out.println("Sorry Wrong Pin");
                    return;
                }
            }
        }
    }
}
