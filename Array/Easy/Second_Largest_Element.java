// Given an array of integers nums, return the second-largest element in the array. If the second-largest element does not exist, return -1.


// Example 1

// Input: nums = [8, 8, 7, 6, 5]

// Output: 7

// Explanation:

// The largest value in nums is 8, the second largest is 7

// Example 2

// Input: nums = [10, 10, 10, 10, 10]

// Output: -1

// Explanation:

// The only value in nums is 10, so there is no second largest value, thus -1 is returned

class Second_Largest_Element {

    public int secondLargestElement(int[] nums) {

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : nums) {

            if (num > largest) {
                secondLargest = largest;
                largest = num;
            }

            else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        return secondLargest == Integer.MIN_VALUE
                ? -1
                : secondLargest;
    }

    public static void main(String[] args) {

        Second_Largest_Element obj =
                new Second_Largest_Element();

        int[] nums = {8, 8, 7, 6, 5};

        System.out.println(
                obj.secondLargestElement(nums)
        );
    }
}