import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AssigningGrades {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of students:");
        int n;
        try {
            n = Integer.parseInt(input.nextLine().trim());
            if (n <= 0) { System.out.println("Number of students must be positive."); return; }
        } catch (Exception e) {
            System.out.println("Invalid number."); return;
        }

        System.out.println("Enter the " + n + " scores");
        int[] scores = new int[n];
        String[] grades = new String[n];
        
        int idx = 0;
        while (idx < n) {
            String line = input.nextLine();
            if (line == null || line.trim().isEmpty()) continue;
            String[] parts = line.trim().split("\\s+");
            for (String p : parts) {
                if (idx >= n) break;
                try {
                    scores[idx++] = Integer.parseInt(p);
                } catch (NumberFormatException ex) {}
            }
        }
        
        int best = Integer.MIN_VALUE;
        for (int s : scores) if (s > best) best = s;

        for (int i = 0; i < n; i++) {
            int s = scores[i];
            if (s >= best - 10) grades[i] = "A";
            else if (s >= best - 20) grades[i] = "B";
            else if (s >= best - 30) grades[i] = "C";
            else if (s >= best - 40) grades[i] = "D";
            else grades[i] = "F";
        }

     
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i+1) + " score is " + scores[i] + " and grade is " + grades[i]);
        }
    }
}
