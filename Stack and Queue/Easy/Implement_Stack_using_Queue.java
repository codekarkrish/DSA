import java.util.*;

public class Implement_Stack_using_Queue {

    static class QueueStack {
        private Queue<Integer> q;

        // Constructor
        public QueueStack() {
            q = new LinkedList<>();
        }

        // Push element
        public void push(int x) {
            int size = q.size();
            q.offer(x);

            // Move previous elements behind the new element
            for (int i = 0; i < size; i++) {
                q.offer(q.poll());
            }
        }

        // Pop element
        public int pop() {
            if (isEmpty()) return -1;
            return q.poll();
        }

        // Top element
        public int top() {
            if (isEmpty()) return -1;
            return q.peek();
        }

        // Check if stack is empty
        public boolean isEmpty() {
            return q.isEmpty();
        }
    }

    public static void main(String[] args) {
        QueueStack st = new QueueStack();

        st.push(4);
        st.push(8);

        System.out.println("Top: " + st.top());
        System.out.println("Pop: " + st.pop());
        System.out.println("Top: " + st.top());
        System.out.println("Is Empty: " + st.isEmpty());
    }
}


/*Time Complexity:
Push operation: O(n) (where n is the number of elements in the queue at that time) because every time an element is pushed, all the elements in the queue are popped from the front and pushed in the back again.
Pop operation: O(1) as constant operations are performed.
Top operation: O(1) as constant operations are performed.
IsEmpty operation: O(1) as constant operations are performed.

Space Complexity: O(k) for storing k elements in the queue.
*/