public class Implement_Stack_using_Arrays {

    static class ArrayStack {
        private int[] stack;
        private int top;
        private int capacity;

        // Constructor
        public ArrayStack() {
            capacity = 1000;
            stack = new int[capacity];
            top = -1;
        }

        // Push element
        public void push(int x) {
            if (top == capacity - 1) {
                System.out.println("Stack Overflow");
                return;
            }
            stack[++top] = x;
        }

        // Pop element
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack Underflow");
                return -1;
            }
            return stack[top--];
        }

        // Get top element
        public int top() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            return stack[top];
        }

        // Check if stack is empty
        public boolean isEmpty() {
            return top == -1;
        }
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();

        stack.push(5);
        stack.push(10);

        System.out.println("Top Element: " + stack.top());
        System.out.println("Popped Element: " + stack.pop());
        System.out.println("Top Element: " + stack.top());
        System.out.println("Is Stack Empty? " + stack.isEmpty());
    }
}