import java.util.*;

class Solution {

    // Merge two sorted halves and count inversions
    public int merge(int[] arr, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int k = 0;

        int cnt = 0;

        while (left <= mid && right <= high) {

            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];

                // Count inversions
                cnt += (mid - left + 1);
            }
        }

        // Copy remaining elements of left half
        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        // Copy remaining elements of right half
        while (right <= high) {
            temp[k++] = arr[right++];
        }

        // Copy merged array back to original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }

        return cnt;
    }

    // Merge Sort + Inversion Count
    public int mergeSort(int[] arr, int low, int high) {

        if (low >= high) {
            return 0;
        }

        int cnt = 0;
        int mid = low + (high - low) / 2;

        // Count inversions in left half
        cnt += mergeSort(arr, low, mid);

        // Count inversions in right half
        cnt += mergeSort(arr, mid + 1, high);

        // Count cross inversions while merging
        cnt += merge(arr, low, mid, high);

        return cnt;
    }

    // Function to count inversions
    public int numberOfInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }
}

public class Count_inversions_in_an_array {

    public static void main(String[] args) {

        int[] arr = {5, 4, 3, 2, 1};

        Solution obj = new Solution();

        int inversions = obj.numberOfInversions(arr);

        System.out.println("The number of inversions are: " + inversions);
    }
}