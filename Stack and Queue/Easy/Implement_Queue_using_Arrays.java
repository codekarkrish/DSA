public class Implement_Queue_using_Arrays {

    static class ArrayQueue {
        private int[] arr;
        private int start, end;
        private int currSize, maxSize;

        // Constructor
        public ArrayQueue() {
            maxSize = 1000;
            arr = new int[maxSize];
            start = -1;
            end = -1;
            currSize = 0;
        }

        // Push element
        public void push(int x) {
            if (currSize == maxSize) {
                return; // Queue Overflow
            }

            if (end == -1) {
                start = 0;
                end = 0;
            } else {
                end = (end + 1) % maxSize;
            }

            arr[end] = x;
            currSize++;
        }

        // Pop element
        public int pop() {
            if (isEmpty()) {
                return -1;
            }

            int popped = arr[start];

            if (currSize == 1) {
                start = -1;
                end = -1;
            } else {
                start = (start + 1) % maxSize;
            }

            currSize--;
            return popped;
        }

        // Get front element
        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return arr[start];
        }

        // Check if queue is empty
        public boolean isEmpty() {
            return currSize == 0;
        }
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();

        queue.push(5);
        queue.push(10);

        System.out.println("Front Element: " + queue.peek());
        System.out.println("Popped Element: " + queue.pop());
        System.out.println("Front Element: " + queue.peek());
        System.out.println("Is Queue Empty? " + queue.isEmpty());
    }
}