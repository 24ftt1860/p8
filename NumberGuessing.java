import java.util.Random;
import java.util.Scanner;
import java.util.HashSet;

public class NumberGuessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) arr[i] = i;

        // Fisher-Yates shuffle once
        Random rnd = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        int chances = 10;
        while (chances > 0) {
            System.out.println("Guess 4 numbers (no duplicates):");
            String line = sc.nextLine().trim();
            if (line.isEmpty()) { continue; }

            String[] parts = line.split("\\s+");
            if (parts.length != 4) {
                System.out.println("Please enter exactly 4 numbers separated by spaces.");
                continue;
 }

            int[] guess = new int[4];
            boolean bad = false;
            HashSet<Integer> seen = new HashSet<>();
            for (int i = 0; i < 4; i++) {
                try {
                    guess[i] = Integer.parseInt(parts[i]);
                    if (guess[i] < 0 || guess[i] > 9) { bad = true; break; }
                    if (!seen.add(guess[i])) { bad = true; break; } // duplicate in guess
                } catch (NumberFormatException e) { bad = true; break; }
            }
            if (bad) {
                System.out.println("Invalid input (ensure 4 distinct integers 0-9). Try again.");
                continue;
            }

            int score = 0;
            for (int i = 0; i < 4; i++) {
                if (guess[i] == arr[i]) score++;
            }

            if (score == 4) {
                System.out.println("You Won! You got the actual number!");
                return;
            }

            chances--;
            System.out.println("You have score " + score + " out of the 4 numbers. You have " + chances + " chances left.");

            if (chances == 0) {
                System.out.print("The actual number is ");
                System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + ". You Lose.");
                return;
            }
        }
    }
}               