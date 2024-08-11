import java.util.Random;
import java.util.Scanner;

public class TheNumberGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int score = 0;
        int roundsWon = 0;

        while (true) {
            int numberToGuess = random.nextInt(100) + 1; // generate a random number between 1 and 100
            int attempts = 0;

            System.out.println("Welcome to the Guessing Game!");
            System.out.println("I'm thinking of a number between 1 and 100.");
            System.out.println("You have 6 attempts to guess it.");

            while (attempts < 6) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println(" Congratulations! You guessed it!");
                    score += 6 - attempts;
                    roundsWon++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (attempts == 6) {
                System.out.println("Sorry, you didn't guess it. The number was " + numberToGuess);
            }

            System.out.print("Do you want to play again? (y/n): ");
            String response = scanner.next();

            if (response.equalsIgnoreCase("n")) {
                break;
            }
        }

        System.out.println("Your final score is " + score + " points.");
        System.out.println("You won " + roundsWon + " rounds.");
    }
}