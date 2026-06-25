import java.util.*;

public class Next_Greater_Element {

    // Function to find Next Greater Element
    public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] ans = nextGreaterElement(arr);

        System.out.println("Next Greater Elements:");
        for (int x : ans) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}

/*Time Complexity: O(N), we traverse the entire array once and find next greater element in linear time.
Space Complexity: O(N), additional space used for resultant array and stack.*/