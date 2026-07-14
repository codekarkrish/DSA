import java.util.PriorityQueue;

public class Kth_Largest_Element_in_a_Stream {

    private PriorityQueue<Integer> minHeap;
    private int k;

    // Constructor
    public Kth_Largest_Element_in_a_Stream(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    // Adds a new value and returns the k-th largest element
    public int add(int val) {
        minHeap.offer(val);

        if (minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};

        Kth_Largest_Element_in_a_Stream obj =
                new Kth_Largest_Element_in_a_Stream(3, nums);

        System.out.println(obj.add(3));   // 4
        System.out.println(obj.add(5));   // 5
        System.out.println(obj.add(10));  // 5
        System.out.println(obj.add(9));   // 8
        System.out.println(obj.add(4));   // 8
    }
}

/*
Time Complexity:
Constructor: O(N log K)
add(): O(log K)

Space Complexity: O(K)
*/