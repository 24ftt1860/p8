import java.util.Scanner;

public class EliminateDuplicate {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] nums = new int[10];

        System.out.println("Enter ten numbers:");
        int idx = 0;
        while (idx < 10) {
            String line = input.nextLine();
            if (line == null || line.trim().isEmpty()) continue;
            String[] parts = line.trim().split("\\s+");
            for (String p : parts) {
                if (idx >= 10) break;
                try {
                    int v = Integer.parseInt(p);
                    if (v < 1 || v > 9) {
                        continue;
                    }
                    nums[idx++] = v;
                } catch (NumberFormatException ignored) { }
            }
        }

        // eliminate duplicates: when duplicate found set later occurrence to 0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) nums[j] = 0;
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) min = j;
            }
            int tmp = nums[i]; nums[i] = nums[min]; nums[min] = tmp;
        }

        // print distinct (skip zeros)
        System.out.print("The distinct numbers are:");
        boolean first = true;
        for (int v : nums) {
            if (v == 0) continue;
            if (first) { System.out.print(" " + v); first = false; }
            else System.out.print(" " + v);
        }
        System.out.println();
    }
}