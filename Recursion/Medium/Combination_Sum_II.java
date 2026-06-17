import java.util.*;

public class Combination_Sum_II {

    static void findCombination(int ind, int target, int[] arr,
                                List<List<Integer>> ans, List<Integer> ds) {

        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {

            if (i > ind && arr[i] == arr[i - 1]) continue;

            if (arr[i] > target) break;

            ds.add(arr[i]);

            findCombination(i + 1, target - arr[i], arr, ans, ds);

            ds.remove(ds.size() - 1);
        }
    }

    static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();

        findCombination(0, target, candidates, ans, new ArrayList<>());

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> result = combinationSum2(arr, target);

        System.out.println(result);
    }
}