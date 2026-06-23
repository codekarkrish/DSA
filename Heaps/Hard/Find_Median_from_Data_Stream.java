import java.util.*;

public class Find_Median_from_Data_Stream {

    static class MedianFinder {

        // Max-heap for smaller half
        private PriorityQueue<Integer> maxHeap;

        // Min-heap for larger half
        private PriorityQueue<Integer> minHeap;

        // Constructor
        public MedianFinder() {
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>();
        }

        // Add a number
        public void addNum(int num) {
            // Add to max-heap
            maxHeap.offer(num);

            // Move largest element to min-heap
            minHeap.offer(maxHeap.poll());

            // Balance the heaps
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        // Find median
        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
            return maxHeap.peek();
        }
    }

    // Driver Code
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();

        mf.addNum(1);
        mf.addNum(2);
        System.out.println("Median: " + mf.findMedian()); // 1.5

        mf.addNum(3);
        System.out.println("Median: " + mf.findMedian()); // 2.0

        mf.addNum(4);
        System.out.println("Median: " + mf.findMedian()); // 2.5

        mf.addNum(5);
        System.out.println("Median: " + mf.findMedian()); // 3.0
    }
}