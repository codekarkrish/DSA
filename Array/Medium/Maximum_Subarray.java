
public class Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum > maxi) {
                maxi = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        return maxi;
    }

    public static void main(String[] args) {
        Maximum_Subarray solution = new Maximum_Subarray();

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int result = solution.maxSubArray(nums);

        System.out.println("Maximum Subarray Sum: " + result);
    }
}
