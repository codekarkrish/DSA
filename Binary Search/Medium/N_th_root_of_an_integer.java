import java.util.*;

public class N_th_root_of_an_integer {

    // Function to check power with overflow control
    static long power(int base, int exp, int m) {
        long result = 1;

        for (int i = 0; i < exp; i++) {
            result *= base;

            // Early stop if exceeds m
            if (result > m) return result;
        }

        return result;
    }

    // Binary search function
    public static int nthRoot(int n, int m) {
        int low = 1, high = m;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long val = power(mid, n, m);

            if (val == m) return mid;
            else if (val < m) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n (root): ");
        int n = sc.nextInt();

        System.out.print("Enter m (number): ");
        int m = sc.nextInt();

        int result = nthRoot(n, m);

        System.out.println("Nth root result: " + result);

        sc.close();
    }
}