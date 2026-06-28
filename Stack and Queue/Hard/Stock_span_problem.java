import java.util.*;

public class Stock_span_problem {

    public static int[] stockSpan(int[] arr, int n) {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = i + 1;
            } else {
                ans[i] = i - st.peek();
            }

            st.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {120, 100, 60, 80, 90, 110, 115};
        int n = arr.length;

        int[] ans = stockSpan(arr, n);

        System.out.println("Stock Span:");
        for (int span : ans) {
            System.out.print(span + " ");
        }
    }
}


// TC: O(N) – Each index is pushed and popped at most once.
// SC: O(N) – Stack stores indices.