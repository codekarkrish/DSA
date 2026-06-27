import java.util.*;

public class Implement_Min_Stack {

    static class MinStack {
        private Stack<Integer> st;
        private int mini;

        public MinStack() {
            st = new Stack<>();
        }

        public void push(int val) {
            if (st.isEmpty()) {
                mini = val;
                st.push(val);
            } else if (val > mini) {
                st.push(val);
            } else {
                st.push(2 * val - mini);
                mini = val;
            }
        }

        public void pop() {
            if (st.isEmpty()) return;

            int x = st.pop();

            if (x < mini) {
                mini = 2 * mini - x;
            }
        }

        public int top() {
            if (st.isEmpty()) return -1;

            int x = st.peek();

            if (x < mini) {
                return mini;
            }

            return x;
        }

        public int getMin() {
            if (st.isEmpty()) return -1;
            return mini;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MinStack stack = new MinStack();

        System.out.print("Enter number of operations: ");
        int n = sc.nextInt();

        System.out.println("Operations:");
        System.out.println("1 x -> Push x");
        System.out.println("2   -> Pop");
        System.out.println("3   -> Top");
        System.out.println("4   -> Get Min");

        for (int i = 0; i < n; i++) {
            int op = sc.nextInt();

            switch (op) {
                case 1:
                    int x = sc.nextInt();
                    stack.push(x);
                    break;

                case 2:
                    stack.pop();
                    break;

                case 3:
                    System.out.println("Top = " + stack.top());
                    break;

                case 4:
                    System.out.println("Min = " + stack.getMin());
                    break;

                default:
                    System.out.println("Invalid Operation");
            }
        }

        sc.close();
    }
}

/*
Time Complexity:
push()   -> O(1)
pop()    -> O(1)
top()    -> O(1)
getMin() -> O(1)

Space Complexity: O(N)
*/