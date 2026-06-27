import java.util.*;

public class Largest_rectangle_in_a_histogram {

    static class Solution {
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            Stack<Integer> st = new Stack<>();
            int[] leftsmall = new int[n];
            int[] rightsmall = new int[n];

            // Nearest Smaller to Left
            for (int i = 0; i < n; i++) {
                while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                    st.pop();
                }
                leftsmall[i] = st.isEmpty() ? 0 : st.peek() + 1;
                st.push(i);
            }

            st.clear();

            // Nearest Smaller to Right
            for (int i = n - 1; i >= 0; i--) {
                while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                    st.pop();
                }
                rightsmall[i] = st.isEmpty() ? n - 1 : st.peek() - 1;
                st.push(i);
            }

            int maxArea = 0;

            // Calculate maximum area
            for (int i = 0; i < n; i++) {
                int width = rightsmall[i] - leftsmall[i] + 1;
                maxArea = Math.max(maxArea, heights[i] * width);
            }

            return maxArea;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of bars: ");
        int n = sc.nextInt();

        int[] heights = new int[n];
        System.out.print("Enter heights: ");
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        System.out.println("Largest Rectangle Area = " + obj.largestRectangleArea(heights));

        sc.close();
    }
}

/*
Time Complexity: O(N)
Space Complexity: O(3N)   // Stack + Left array + Right array
*/