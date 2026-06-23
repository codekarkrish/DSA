import java.util.*;

public class Merge_K_Sorted_Arrays {

    static class Node {
        int value;
        int row;
        int col;

        Node(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    static class Solution {

        public List<Integer> mergeKSortedArrays(int[][] arr, int k) {

            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.value - b.value);

            // Add first element of each array
            for (int i = 0; i < k; i++) {
                pq.offer(new Node(arr[i][0], i, 0));
            }

            List<Integer> ans = new ArrayList<>();

            while (!pq.isEmpty()) {
                Node curr = pq.poll();
                ans.add(curr.value);

                // Add next element from the same array
                if (curr.col + 1 < k) {
                    pq.offer(new Node(arr[curr.row][curr.col + 1], curr.row, curr.col + 1));
                }
            }

            return ans;
        }
    }

    // Driver Code
    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int k = arr.length;

        Solution obj = new Solution();
        List<Integer> result = obj.mergeKSortedArrays(arr, k);

        System.out.println(result);
    }
}

// Time Complexity: O(k² log k)
// Reason: There are k² total elements. Each element is inserted and removed
// from the min-heap once, and each heap operation takes O(log k).

// Space Complexity: O(k)
// Reason: The min-heap stores at most one element from each of the k arrays.