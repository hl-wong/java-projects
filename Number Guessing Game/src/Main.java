import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int numOfAttempt = 5;
        int randomNum = (int) (Math.random() * 100 + 1);

        while (numOfAttempt != 0) {
            System.out.print("Please enter 1-100 to guess the number (" + numOfAttempt + " attempts): ");
            Scanner input = new Scanner(System.in);
            int guess = input.nextInt();
            if (guess == randomNum) {
                System.out.println("Congratulations! You guessed the correct number!");
                break;
            }
            // if the guess less than the random number
            if (guess < randomNum) {
                System.out.println("Too Low!\n");
            }
            // if the guess is greater than the random number
            if (guess > randomNum) {
                System.out.println("Too High!\n");
            }
            numOfAttempt--;
        }

        if (numOfAttempt == 0) {
            System.out.println("You have failed to guess the number.");
            System.out.println("The correct answer is " + randomNum);
        }
    }
}