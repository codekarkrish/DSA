 import java.util.*;

public class Subsets_II {

    // Backtracking function to generate unique subsets
    private static void backtrack(int start, int[] nums,
                                  List<Integer> current,
                                  List<List<Integer>> result) {

        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {

            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1])
                continue;

            current.add(nums[i]);

            backtrack(i + 1, nums, current, result);

            current.remove(current.size() - 1);
        }
    }

    // Function to return all unique subsets
    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, nums, new ArrayList<>(), result);

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<List<Integer>> ans = subsetsWithDup(nums);

        System.out.println("Unique Subsets:");

        for (List<Integer> subset : ans) {
            System.out.println(subset);
        }

        sc.close();
    }
}