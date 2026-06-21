import java.util.*;

public class Book_Allocation_Problem {

    public static int countStudents(int[] nums, int pages) {

        int students = 1;
        int sum = 0;

        for (int x : nums) {

            if (sum + x <= pages) {
                sum += x;
            } else {
                students++;
                sum = x;
            }
        }

        return students;
    }

    public static int findPages(int[] nums, int m) {

        int n = nums.length;

        if (m > n) return -1;

        int low = 0, high = 0;

        for (int x : nums) {
            low = Math.max(low, x);
            high += x;
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (countStudents(nums, mid) > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {

        int[] nums = {25, 46, 28, 49, 24};
        int m = 4;

        System.out.println("Minimum pages: " + findPages(nums, m));
    }
}