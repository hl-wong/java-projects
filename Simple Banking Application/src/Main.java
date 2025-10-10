/*
Simple Banking Application is a simple Java project for beginners to start their career in coding.
You'll learn about Scanner class to take inputs, and the basics of strings, loops, methods, and conditional statements.
Here, simple banking operations like deposit, withdrawal, checking balance, exit, etc.

Abstract: In this modernized world, where time is money, everyone has got the habit of doing their tasks online.
Within a click, a task is done. You get this application to make transactions just by sitting in your comfort zone.
Every operation like money transfer and balance inquiry can be done in seconds.
 */

import java.util.Scanner;

public class Main {

    private static int balance;

    public static void main(String[] args) {

        boolean exit = false;

        while (!exit) {
            run();

            Scanner input = new Scanner(System.in);
            System.out.print("\nPlease enter your choice: ");
            int choice = input.nextInt();

            int amount;

            switch (choice) {
                case 1:
                    System.out.print("Please enter your deposit amount: RM");
                    amount = input.nextInt();
                    if (checkNumber(amount)) {
                        deposit(amount);
                    }
                    else {
                        System.out.println("Cannot enter negative number\n");
                    }
                    break;
                case 2:
                    System.out.print("Please enter your withdrawal amount: RM");
                    amount = input.nextInt();
                    if (checkNumber(amount)) {
                        withdrawal(amount);
                    }
                    else {
                        System.out.println("Cannot enter negative number\n");
                    }
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using Simple Banking Application. Bye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.\n");
                    break;
            }
        }
    }

    static void run() {
        System.out.println("Simple Banking Application");
        System.out.println("==========================");
        System.out.println("[1] Deposit");
        System.out.println("[2] Withdrawal");
        System.out.println("[3] Check Balance");
        System.out.println("[4] Exit");
    }

    static void deposit(int amount) {
        balance += amount;
        System.out.println("RM" + amount + " have been deposit to the account\n");
    }

    static void withdrawal(int amount) {
        // if the amount is less than or equal to the balance
        if (amount <= balance) {
            balance -= amount;
            System.out.println("RM" + amount + " have been withdraw from the account\n");
        }
    }

    static void checkBalance() {
        System.out.println("\nMy Balance");
        System.out.println("==========");
        System.out.println("RM" + balance + "\n");
    }

    static boolean checkNumber(int number) {
        if (number > 0) {
            return true;
        }
        else {
            return false;
        }
    }
}