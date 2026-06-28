import java.util.*;

public class Celebrity_Problem {

    // Function to find the celebrity
    public static int celebrity(int[][] M) {
        int n = M.length;

        int top = 0, down = n - 1;

        // Find potential celebrity
        while (top < down) {
            if (M[top][down] == 1) {
                top++;
            } else if (M[down][top] == 1) {
                down--;
            } else {
                top++;
                down--;
            }
        }

        if (top > down) return -1;

        // Verify the candidate
        for (int i = 0; i < n; i++) {
            if (i == top) continue;

            if (M[top][i] == 1 || M[i][top] == 0) {
                return -1;
            }
        }

        return top;
    }

    public static void main(String[] args) {

        int[][] M = {
            {0, 1, 1, 0},
            {0, 0, 0, 0},
            {1, 1, 0, 0},
            {0, 1, 1, 0}
        };

        int ans = celebrity(M);

        if (ans == -1) {
            System.out.println("No Celebrity Found");
        } else {
            System.out.println("Celebrity Index: " + ans);
        }
    }
}

// TC: O(N) – Candidate elimination and verification each take O(N).
// SC: O(1) – Only constant extra space is used.