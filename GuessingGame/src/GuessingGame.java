import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0; 
        boolean playAgain;

        do {
            int mystery_number = random.nextInt(100) + 1;
            int max_attempts = 5;  
            int attempts = 0;
            boolean hasGuessed = false;
            int score = 0; 

            System.out.println("Unlock the mystery! Enter a number between 1 and 100:");

            while (attempts < max_attempts && !hasGuessed) {
                System.out.print("Attempt " + (attempts + 1) + ": ");
                int player_guess = scanner.nextInt();
                attempts++;

                if (player_guess < mystery_number) {
                    System.out.println("Oops, that's a bit low! But you're almost there-try a larger number and keep going!");
                } else if (player_guess > mystery_number) {
                    System.out.println("Oops, that's a bit high! But you're almost there-try a smaller number and keep going!");
                } else {
                    System.out.println("Amazing! You've solved the mystery!");
                    hasGuessed = true;
                    score = max_attempts - attempts + 1; 
                    System.out.println("Your score for this round is: " + score);
                }
            }

            if (!hasGuessed) {
                System.out.println("Sorry, you've run out of attempts! The mystery number was: " + mystery_number);
            }
            totalScore += score;
            System.out.println("Your total score is: " + totalScore);
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Thanks for playing! Your final score is: " + totalScore);
    }
}
