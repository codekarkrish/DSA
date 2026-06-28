import java.util.*;

public class Maximum_of_Minimums_for_Every_Window_Size {

    public static int[] maxOfMin(int[] arr) {
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();

        // Previous Smaller Element
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Smaller Element
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        int[] ans = new int[n + 1];

        // Maximum of minimums for every window size
        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            ans[len] = Math.max(ans[len], arr[i]);
        }

        // Fill remaining entries
        for (int i = n - 1; i >= 1; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }

        return Arrays.copyOfRange(ans, 1, n + 1);
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 50, 10, 70, 30};

        int[] ans = maxOfMin(arr);

        System.out.println("Maximum of Minimums for Every Window Size:");
        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}

// TC: O(N) – Each element is pushed and popped at most once.
// SC: O(N) – Extra arrays and stack.