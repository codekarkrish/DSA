import java.util.*;

public class KMP_Algorithm_or_LPS_array {

    // Compute LPS (Longest Prefix Suffix) Array
    public static int[] computeLPS(String pattern) {

        int[] lps = new int[pattern.length()];
        int len = 0;
        int i = 1;

        while (i < pattern.length()) {

            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {

                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    // KMP Pattern Searching
    public static List<Integer> KMP(String text, String pattern) {

        List<Integer> result = new ArrayList<>();

        if (pattern.length() == 0) {
            result.add(0);
            return result;
        }

        int[] lps = computeLPS(pattern);

        int i = 0, j = 0;

        while (i < text.length()) {

            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == pattern.length()) {
                result.add(i - j);
                j = lps[j - 1];
            } else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {

                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String text = "ababcababcabc";
        String pattern = "abc";

        List<Integer> matches = KMP(text, pattern);

        System.out.println("Pattern found at indices: " + matches);

        int[] lps = computeLPS(pattern);
        System.out.println("LPS Array: " + Arrays.toString(lps));
    }
}

/*
Time Complexity: O(n + m)
Space Complexity: O(m)
*/