import java.util.ArrayList;
import java.util.List;

public class Rabin_Karp_Algorithm {

    public static List<Integer> search(String pat, String txt) {

        List<Integer> ans = new ArrayList<>();

        int m = pat.length();
        int n = txt.length();

        int[] lps = new int[m];
        buildLPS(pat, lps);

        int i = 0;
        int j = 0;

        while (i < n) {

            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                ans.add(i - j); // 0-based indexing
                j = lps[j - 1];
            } else if (i < n && txt.charAt(i) != pat.charAt(j)) {

                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return ans;
    }

    private static void buildLPS(String pat, int[] lps) {

        int len = 0;
        int i = 1;

        while (i < pat.length()) {

            if (pat.charAt(i) == pat.charAt(len)) {
                lps[i++] = ++len;
            } else {

                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i++] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        String pat = "abc";
        String txt = "ababcabcababc";

        System.out.println("Pattern: " + pat);
        System.out.println("Text: " + txt);
        System.out.println("Occurrences: " + search(pat, txt));
    }
}

/*
Question: Pattern Searching (KMP Algorithm)

Time Complexity: O(N + M)
Reason: Build the LPS array in O(M) and search the text in O(N).

Space Complexity: O(M)
Reason: LPS array of size M.
*/