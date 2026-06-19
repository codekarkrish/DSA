import java.util.*;

public class Word_Break {

    // Recursive function with memoization
    static boolean solve(String s, Set<String> dict, int start, Boolean[] dp) {

        // If we've reached the end, the string can be segmented
        if (start == s.length()) {
            return true;
        }

        // Return previously computed result
        if (dp[start] != null) {
            return dp[start];
        }

        // Try every possible substring
        for (int end = start + 1; end <= s.length(); end++) {

            String word = s.substring(start, end);

            if (dict.contains(word) && solve(s, dict, end, dp)) {
                dp[start] = true;
                return true;
            }
        }

        // Store and return false
        dp[start] = false;
        return false;
    }

    // Function to check if the string can be segmented
    static boolean wordBreak(String s, List<String> wordDict) {

        Set<String> dict = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()];

        return solve(s, dict, 0, dp);
    }

    public static void main(String[] args) {

        String s = "leetcode";

        List<String> wordDict = Arrays.asList(
                "leet",
                "code"
        );

        if (wordBreak(s, wordDict)) {
            System.out.println("The string can be segmented.");
        } else {
            System.out.println("The string cannot be segmented.");
        }
    }
}