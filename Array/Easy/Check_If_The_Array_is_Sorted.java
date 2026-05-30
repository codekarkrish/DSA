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
// Compare every element with all elements after it.
// If any arr[i] > arr[j] where i < j, the array is not sorted.
// Time Complexity: O(n²)
// Space Complexity: O(1)


// Optimal Approach
// Traverse the array from index 1 to n-1.
// Compare each element with its previous element.
// If arr[i] < arr[i-1], the array is not sorted, so return false.
// If the loop completes, return true.
// Time Complexity: O(n)
// Space Complexity: O(1)

