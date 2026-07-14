import java.util.*;

public class Find_Median_in_a_Stream {

    // Returns median after every insertion
    public List<Double> getMedian(int[] arr) {

        // Max Heap for left half
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Min Heap for right half
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        List<Double> result = new ArrayList<>();

        for (int num : arr) {

            // Insert into appropriate heap
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            // Balance the heaps
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }

            // Calculate median
            if (maxHeap.size() == minHeap.size()) {
                result.add((maxHeap.peek() + minHeap.peek()) / 2.0);
            } else {
                result.add((double) maxHeap.peek());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Find_Median_in_a_Stream obj = new Find_Median_in_a_Stream();

        int[] arr = {5, 15, 1, 3, 2, 8};

        List<Double> medians = obj.getMedian(arr);

        System.out.println(medians);
    }
}

/*
Time Complexity: O(N log N)
Space Complexity: O(N)
*/