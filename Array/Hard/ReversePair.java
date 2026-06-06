public class ReversePair {

    // Merge two sorted halves
    private void merge(int[] arr, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int k = 0;

        while (left <= mid && right <= high) {

            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        while (right <= high) {
            temp[k++] = arr[right++];
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }

    // Count reverse pairs
    private int countPairs(int[] arr, int low, int mid, int high) {

        int right = mid + 1;
        int cnt = 0;

        for (int i = low; i <= mid; i++) {

            while (right <= high &&
                    (long) arr[i] > 2L * arr[right]) {
                right++;
            }

            cnt += (right - (mid + 1));
        }

        return cnt;
    }

    // Merge Sort
    private int mergeSort(int[] arr, int low, int high) {

        if (low >= high) {
            return 0;
        }

        int cnt = 0;
        int mid = (low + high) / 2;

        // Left half
        cnt += mergeSort(arr, low, mid);

        // Right half
        cnt += mergeSort(arr, mid + 1, high);

        // Count reverse pairs
        cnt += countPairs(arr, low, mid, high);

        // Merge sorted halves
        merge(arr, low, mid, high);

        return cnt;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {

        int[] arr = {4, 1, 2, 3, 1};

        ReversePair obj = new ReversePair();

        int count = obj.reversePairs(arr);

        System.out.println("The number of reverse pairs is: " + count);
    }
}

/*
Output:
The number of reverse pairs is: 3

TC: O(N log N) -> Merge sort has logN levels and each level processes N elements.

SC: O(N) -> Temporary array is used during merging.
*/