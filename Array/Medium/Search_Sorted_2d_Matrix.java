import java.util.*;

// Class containing the search logic
public class Search_Sorted_2d_Matrix {

    // Function to search target in a 2D matrix
    public boolean searchMatrix(int[][] matrix, int target) {

        // Number of rows
        int n = matrix.length;

        // Number of columns
        int m = matrix[0].length;

        // Binary search range on virtual 1D array
        int low = 0;
        int high = n * m - 1;

        while (low <= high) {

            // Middle index
            int mid = low + (high - low) / 2;

            // Convert 1D index to 2D coordinates
            int row = mid / m;
            int col = mid % m;

            // Target found
            if (matrix[row][col] == target) {
                return true;
            }

            // Search right half
            else if (matrix[row][col] < target) {
                low = mid + 1;
            }

            // Search left half
            else {
                high = mid - 1;
            }
        }

        // Target not found
        return false;
    }

    // Driver code
    public static void main(String[] args) {

        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        Search_Sorted_2d_Matrix obj = new Search_Sorted_2d_Matrix();

        int target = 8;

        if (obj.searchMatrix(matrix, target)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}