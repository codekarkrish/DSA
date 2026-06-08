import java.util.*;

public class SubarraysWithXorK {

    public int subarraysWithXorK(int[] nums, int k) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        // Prefix XOR 0 occurs once initially
        freq.put(0, 1);

        int prefixXor = 0;
        int count = 0;

        for (int num : nums) {

            prefixXor ^= num;

            int target = prefixXor ^ k;

            if (freq.containsKey(target)) {
                count += freq.get(target);
            }

            freq.put(prefixXor,
                    freq.getOrDefault(prefixXor, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {4, 2, 2, 6, 4};
        int k = 6;

        SubarraysWithXorK obj = new SubarraysWithXorK();

        int ans = obj.subarraysWithXorK(nums, k);

        System.out.println("Number of subarrays with XOR " + k + " = " + ans);
    }
}