import java.util.Random;
import java.util.Scanner;

public class numbergame {
    private static final int MAX_ATTEMPTS = 10;
    private static final int MAX_ROUNDS = 5;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int rounds = 0;
        int totalScore = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        while (rounds < MAX_ROUNDS) {
            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;
            
            System.out.println("\nRound " + (rounds + 1) + ":");
            System.out.println("I have generated a number between 1 and 100. Try to guess it!");
            
            while (attempts < MAX_ATTEMPTS && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    hasGuessedCorrectly = true;
                    totalScore += (MAX_ATTEMPTS - attempts + 1);
                } else if (userGuess < randomNumber) {
                    System.out.println("Your guess is too low, try guess a greater value");
                } else {
                    System.out.println("Your guess is too high, try guess a lower value");
                }
            }
            
            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + randomNumber);
            }
            
            rounds++;
            
            if (rounds < MAX_ROUNDS) {
                System.out.print("Do you want to play another round? (yes/no): ");
                String response = scanner.next();
                if (!response.equalsIgnoreCase("yes")) {
                    break;
                }
            }
        }
        
        System.out.println("\nGame Over!");
        System.out.println("Your total score is: " + totalScore);
        
        scanner.close();
    }
}
