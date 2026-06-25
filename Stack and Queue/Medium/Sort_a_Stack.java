import java.util.*;

public class Sort_a_Stack {

    // Insert element in sorted order
    public static void insert(Stack<Integer> st, int x) {
        if (st.isEmpty() || st.peek() <= x) {
            st.push(x);
            return;
        }

        int temp = st.pop();
        insert(st, x);
        st.push(temp);
    }

    // Sort the stack using recursion
    public static void sortStack(Stack<Integer> st) {
        if (st.isEmpty()) return;

        int temp = st.pop();
        sortStack(st);
        insert(st, temp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter stack elements:");
        for (int i = 0; i < n; i++) {
            st.push(sc.nextInt());
        }

        sortStack(st);

        System.out.println("Sorted Stack (Top to Bottom):");
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }

        sc.close();
    }
}


/*Time Complexity: O(n2), where n is the number of elements in the stack.

Space Complexity: O(n), due to the recursion stack. */