class Check_If_The_Array_is_Sorted {
    public boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Check_If_The_Array_is_Sorted solution = new Check_If_The_Array_is_Sorted();
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 3, 2, 1};
        int[] arr3 = {1, 2, 2, 3, 4};

        System.out.println(solution.isSorted(arr1)); // true
        System.out.println(solution.isSorted(arr2)); // false
        System.out.println(solution.isSorted(arr3)); // true
    }
}

// Brute Force Approach
// Generate all possible rotations of the array
// and check if any rotation is sorted.
// Time Complexity: O(n²)
// Space Complexity: O(n)



// Optimal Approach
// Count how many times nums[i] > nums[(i+1)%n].
// A sorted and rotated array can have
// at most one breaking point.
// If count <= 1 return true,
// otherwise return false.
// Time Complexity: O(n)
// Space Complexity: O(1)