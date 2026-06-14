import java.util.*;

public class Trapping_Rain_Water {

    public static int trap(int[] height) {
        int n = height.length;

        int left = 0;
        int right = n - 1;

        int maxLeft = 0;
        int maxRight = 0;

        int totalWater = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {

                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    totalWater += maxLeft - height[left];
                }

                left++;
            } else {

                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    totalWater += maxRight - height[right];
                }

                right--;
            }
        }

        return totalWater;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int result = trap(height);

        System.out.println("Trapped Rainwater: " + result);
    }
}

/*
Algorithm: Two Pointer Approach
1. Keep two pointers (left and right).
2. Maintain leftMax and rightMax.
3. If left height <= right height:
      - Update leftMax.
      - Water trapped = leftMax - current height.
4. Otherwise:
      - Update rightMax.
      - Water trapped = rightMax - current height.
5. Add trapped water and move pointers.

Time Complexity: O(N)
Space Complexity: O(1)
*/