import java.util.*;

public class Matrix_Median {

    // Count elements <= mid in a sorted row using binary search
    static int countLessEqual(int[] row, int mid) {
        int low = 0, high = row.length - 1;

        while (low <= high) {
            int m = low + (high - low) / 2;

            if (row[m] <= mid)
                low = m + 1;
            else
                high = m - 1;
        }

        return low;
    }

    public static int findMedian(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // find range
        for (int i = 0; i < n; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][m - 1]);
        }

        int required = (n * m) / 2;

        // binary search on answer
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int count = 0;

            for (int i = 0; i < n; i++) {
                count += countLessEqual(matrix[i], mid);
            }

            if (count <= required)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int n = sc.nextInt();

        System.out.print("Enter cols: ");
        int m = sc.nextInt();

        int[][] matrix = new int[n][m];

        System.out.println("Enter matrix elements (row-wise sorted):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int ans = findMedian(matrix);

        System.out.println("Matrix Median: " + ans);

        sc.close();
    }
}