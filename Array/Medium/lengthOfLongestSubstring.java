import java.util.*;

public class lengthOfLongestSubstring {

    public int lengthOfLongestSubstringFunc(String s) {

        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < n; right++) {

            char ch = s.charAt(right);

            if (map.containsKey(ch) && map.get(ch) >= left) {
                left = map.get(ch) + 1;
            }

            map.put(ch, right);

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        String s = "abcabcbb";

        lengthOfLongestSubstring obj = new lengthOfLongestSubstring();

        int ans = obj.lengthOfLongestSubstringFunc(s);

        System.out.println("Length of longest substring: " + ans);
    }
}