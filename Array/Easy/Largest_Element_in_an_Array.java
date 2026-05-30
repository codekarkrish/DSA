// Given an array of integers nums, return the value of the largest element in the array


// Example 1

// Input: nums = [3, 3, 6, 1]

// Output: 6

// Explanation: The largest element in array is 6

// Example 2

// Input: nums = [3, 3, 0, 99, -40]

// Output: 99

// Explanation: The largest element in array is 99

class Largest_Element_in_an_Array {

    public int largestElement(int[] nums) {
        int max = nums[0];
        int n = nums.length;
        for (int i = 0 ; i<n; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {

        Largest_Element_in_an_Array obj =
                new Largest_Element_in_an_Array();

        int[] nums = {3, 3, 6, 1, 9, 22};

        System.out.println(obj.largestElement(nums));
    }
}



// Thinking process:
// brute force approach is to sort the array and return the last element.
//  This will take O(n log n) time complexity. and space complexity is O(1)

// optimal approach is to iterate through the array and keep track of the maximum element. 
// This will take O(n) time complexity and O(1) space complexity.