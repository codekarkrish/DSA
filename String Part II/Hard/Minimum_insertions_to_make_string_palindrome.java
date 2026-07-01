import java.util.*;

public class Minimum_insertions_to_make_string_palindrome {

    // Function to find minimum insertions to make a string palindrome
    public static int minInsertion(String s) {

        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();

        int[] prev = new int[n + 1];
        int[] cur = new int[n + 1];

        // Find Longest Palindromic Subsequence using LCS
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n; j++) {

                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    cur[j] = 1 + prev[j - 1];
                } else {
                    cur[j] = Math.max(prev[j], cur[j - 1]);
                }
            }

            prev = cur.clone();
        }

        // Minimum Insertions = Length - LPS
        return n - prev[n];
    }

    public static void main(String[] args) {

        String s = "abcaa";

        System.out.println("String: " + s);
        System.out.println("Minimum Insertions: " + minInsertion(s));
    }
}

/*
Time Complexity: O(N²)
Space Complexity: O(N)
*/