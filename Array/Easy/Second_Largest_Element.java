//second largest element without sorting
// Given an array of integers nums, return the second-largest element in the array.
//  If the second-largest element does not exist, return -1.
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
int n = nums.length;
int largest = nums[0];
int secondLargest = Integer.MIN_VALUE;
        for (int  i = 1; i<n;i++) {
            if( nums[i]> largest){
                secondLargest = largest;
                largest = nums[i];
            }
            else if(nums[i]<largest && nums[i]>secondLargest){
                secondLargest = nums[i];
            }
        }
return secondLargest;
    }

    public static void main(String[] args) {

        Second_Largest_Element obj = new Second_Largest_Element();

        int[] nums = {8, 8, 7,19, 6, 5};

        System.out.println(obj.secondLargestElement(nums));
    }
    }




// Brute force approach is sorting the array the last will be the largest element ,
//  then we will search the elements from n-2 to 0 , if not equal to largest if (arr[i] != largest) then it will be the second largest , and if all elements are equal then return -1 as default , 
// here the time complexity will be O(nlogn) and space complexity will be O(1)

//Better approach is that Find largest in first pass.
// Find second largest in second pass.initially as -1
/* for (int i = 0; i < arr.length; i++) {
    if (arr[i] != largest && arr[i] > secondLargest) {
        secondLargest = arr[i];
    }
} */
// First loop  -> O(n)
// Second loop -> O(n)
// TC: O(2n) = O(n)
// SC:O(1)


// Optimal approach:
// Take arr[0] as largest and -1 as secondLargest.
// Traverse from index 1.
// If arr[i] > largest, update both largest and secondLargest.
// Else if arr[i] lies between largest and secondLargest,
// update secondLargest.
// At the end, secondLargest stores the second largest distinct element.
// TC: O(n), SC: O(1)


// additional we can use the same approach for the smallest and second smallest

// we should use Integer.MAX_VALUE and Integer.MIN_VALUE instead of using -1. because it gives the most generic answer as the may be many negetive interger less then -1 in an array [-20,-10,-30]