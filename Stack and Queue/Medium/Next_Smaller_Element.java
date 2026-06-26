import java.util.*;

public class Next_Smaller_Element {

    static class Solution {
        public int[] nextSmallerElements(int[] arr) {
            int n = arr.length;
            Stack<Integer> st = new Stack<>();
            int[] ans = new int[n];
            Arrays.fill(ans, -1);

            // Traverse from right to left
            for (int i = n - 1; i >= 0; i--) {

                // Remove elements greater than or equal to current
                while (!st.isEmpty() && st.peek() >= arr[i]) {
                    st.pop();
                }

                // Store next smaller element
                if (!st.isEmpty()) {
                    ans[i] = st.peek();
                }

                // Push current element
                st.push(arr[i]);
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input array
        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Solution sol = new Solution();
        int[] ans = sol.nextSmallerElements(arr);

        // Output
        System.out.print("Next Smaller Elements: ");
        for (int x : ans) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}

/*Time Complexity: O(N), since each element is pushed and popped at most once.

Space Complexity: O(N), since stack may hold up to N elements in the worst case.*/