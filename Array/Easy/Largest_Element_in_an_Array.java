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

        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        Largest_Element_in_an_Array obj =
                new Largest_Element_in_an_Array();

        int[] nums = {3, 3, 6, 1};

        System.out.println(obj.largestElement(nums));
    }
}