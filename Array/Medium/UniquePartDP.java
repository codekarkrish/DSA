public class UniquePartDP {

    public int uniquePaths(int m, int n) {

        // Previous row
        int[] prev = new int[n];

        // Traverse rows
        for (int i = 0; i < m; i++) {

            // Current row
            int[] temp = new int[n];

            // Traverse columns
            for (int j = 0; j < n; j++) {

                // Base case: starting cell
                if (i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }

                // Ways from above
                int up = (i > 0) ? prev[j] : 0;

                // Ways from left
                int left = (j > 0) ? temp[j - 1] : 0;

                // Total ways
                temp[j] = up + left;
            }

            // Update previous row
            prev = temp;
        }

        return prev[n - 1];
    }

    public static void main(String[] args) {

        int m = 3;
        int n = 2;

        UniquePartDP sol = new UniquePartDP();

        int ans = sol.uniquePaths(m, n);

        System.out.println("Number of unique paths: " + ans);
    }
}

/*
Output:
Number of unique paths: 3

TC: O(m*n) -> Nested loops visit every cell once.
SC: O(n)   -> Only previous and current rows are stored.
*/