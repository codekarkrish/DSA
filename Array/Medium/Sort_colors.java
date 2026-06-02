public class Sort_colors {

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        int n = nums.length;

        int low = 0;
        int mid = 0;
        int high = n - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            }

            else if (nums[mid] == 1) {
                mid++;
            }

            else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public static void main(String[] args) {

        Sort_colors solution = new Sort_colors();

        int[] nums = {2, 0, 2, 1, 1, 0};

        System.out.print("Before Sorting: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        solution.sortColors(nums);

        System.out.println();

        System.out.print("After Sorting: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}