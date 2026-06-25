import java.util.*;

public class Implement_Queue_using_Stacks {

    static class StackQueue {
        private Stack<Integer> input;
        private Stack<Integer> output;

        public StackQueue() {
            input = new Stack<>();
            output = new Stack<>();
        }

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }

            if (output.isEmpty()) return -1;

            return output.pop();
        }

        public int peek() {
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }

            if (output.isEmpty()) return -1;

            return output.peek();
        }

        public boolean isEmpty() {
            return input.isEmpty() && output.isEmpty();
        }
    }

    public static void main(String[] args) {
        StackQueue q = new StackQueue();

        q.push(3);
        q.push(4);

        System.out.println("Popped: " + q.pop());

        q.push(5);

        System.out.println("Front: " + q.peek());
        System.out.println("Is Empty: " + q.isEmpty());

        System.out.println("Popped: " + q.pop());
        System.out.println("Popped: " + q.pop());

        System.out.println("Is Empty: " + q.isEmpty());
    }
}

//Time Complexity: O(1) for push operation, O(n) for pop and peek operations in the worst case when elements need to be shifted.

//Space Complexity: O(n) for storing elements in the two stacks.