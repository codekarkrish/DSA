import java.util.*;

public class K_th_Largest_element_in_an_array {

    static class Solution {

        private Random rand = new Random();

        public int kthLargestElement(int[] nums, int k) {

            if (k > nums.length) return -1;

            int left = 0;
            int right = nums.length - 1;

            while (true) {

                int pivotIndex = randomIndex(left, right);

                pivotIndex = partition(nums, pivotIndex, left, right);

                if (pivotIndex == k - 1)
                    return nums[pivotIndex];
                else if (pivotIndex > k - 1)
                    right = pivotIndex - 1;
                else
                    left = pivotIndex + 1;
            }
        }

        private int randomIndex(int left, int right) {
            return rand.nextInt(right - left + 1) + left;
        }

        private int partition(int[] nums, int pivotIndex, int left, int right) {

            int pivot = nums[pivotIndex];

            swap(nums, left, pivotIndex);

            int ind = left + 1;

            for (int i = left + 1; i <= right; i++) {
                if (nums[i] > pivot) {
                    swap(nums, i, ind);
                    ind++;
                }
            }

            swap(nums, left, ind - 1);

            return ind - 1;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {

        Solution obj = new Solution();

        int[] nums = {-5, 4, 1, 2, -3};
        int k = 5;

        int ans = obj.kthLargestElement(nums, k);

        System.out.println("The Kth Largest Element is: " + ans);
    }
}