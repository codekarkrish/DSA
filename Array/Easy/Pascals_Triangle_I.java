import java.util.*;

public class Pascals_Triangle_I {

    static class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();

            for (int row = 0; row < numRows; row++) {
                List<Integer> current = new ArrayList<>();

                long value = 1;
                current.add(1);

                for (int col = 1; col <= row; col++) {
                    value = value * (row - col + 1) / col;
                    current.add((int) value);
                }

                result.add(current);
            }

            return result;
        }
    }

    public static void main(String[] args) {
        int numRows = 5;

        Solution sol = new Solution();
        List<List<Integer>> result = sol.generate(numRows);

        for (List<Integer> row : result) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}