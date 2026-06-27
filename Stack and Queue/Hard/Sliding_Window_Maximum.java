import java.util.*;

public class Sliding_Window_Maximum {

    static class Solution {
        public int[] maxSlidingWindow(int[] arr, int k) {
            Deque<Integer> dq = new LinkedList<>();
            int n = arr.length;
            int[] ans = new int[n - k + 1];
            int idx = 0;

            for (int i = 0; i < n; i++) {
                // Remove indices outside the current window
                if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                    dq.pollFirst();
                }

                // Remove smaller elements from the back
                while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
                    dq.pollLast();
                }

                // Add current index
                dq.offerLast(i);

                // Store maximum of current window
                if (i >= k - 1) {
                    ans[idx++] = arr[dq.peekFirst()];
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter window size (k): ");
        int k = sc.nextInt();

        Solution obj = new Solution();
        int[] ans = obj.maxSlidingWindow(arr, k);

        System.out.println("Sliding Window Maximums:");
        for (int x : ans) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}

/*
Time Complexity: O(N)
Space Complexity: O(K)
*/