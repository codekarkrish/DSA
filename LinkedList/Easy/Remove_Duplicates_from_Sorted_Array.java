import java.util.*;

public class Remove_Duplicates_from_Sorted_Array {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int k = removeDuplicates(nums);

        System.out.println("Unique count = " + k);

        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

/*
Algorithm:
1. Use two pointers i and j.
2. i keeps track of the last unique element.
3. j traverses the array.
4. When nums[j] != nums[i], move i forward and copy nums[j].
5. Return i + 1 as the count of unique elements.

Time Complexity: O(N)
Space Complexity: O(1)
*/