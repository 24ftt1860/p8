import java.util.Scanner;

public class ShiftingElementByInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("How many numbers are there?");
        int n;
        try {
            n = Integer.parseInt(input.nextLine().trim());
        } catch (Exception e) {
            System.out.println("Invalid number.");
            return;
        }

        System.out.println("Enter the " + n + " numbers:");
        int[] arr = new int[n];
        int idx = 0;
        while (idx < n) {
            String line = input.nextLine();
            if (line == null || line.trim().isEmpty()) continue;
            String[] parts = line.trim().split("\\s+");
            for (String p : parts) {
                if (idx >= n) break;
                try {
                    arr[idx++] = Integer.parseInt(p);
                } catch (NumberFormatException ignored) {}
            }
        }

        System.out.println("Enter number of left shift:");
        int k;
        try {
            k = Integer.parseInt(input.nextLine().trim());
        } catch (Exception e) {
            System.out.println("Invalid shift.");
            return;
}

        if (n == 0) {
            System.out.println("The shifted arrangement is:");
            return;
        }

        k = ((k % n) + n) % n; // normalize shift
        int[] shifted = new int[n];
        for (int i = 0; i < n; i++) {
            shifted[i] = arr[(i + k) % n];
        }

        System.out.println("The shifted arrangement is:");
        for (int i = 0; i < n; i++) {
            System.out.print(shifted[i]);
            if (i < n - 1) System.out.print(" ");
        }
        System.out.println();
    }
}            