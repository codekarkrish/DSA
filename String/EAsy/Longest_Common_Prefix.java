import java.util.Arrays;

public class Longest_Common_Prefix {

    public static String longestCommonPrefix(String[] str) {

        Arrays.sort(str);

        StringBuilder ans = new StringBuilder();

        String first = str[0];
        String last = str[str.length - 1];

        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {

            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }

            ans.append(first.charAt(i));
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        String[] str = {"interview", "internet", "internal", "interval"};

        System.out.println("Longest Common Prefix: " + longestCommonPrefix(str));
    }
}

/*
Question: Longest Common Prefix

Time Complexity: O(N log N + M)
Reason: Sorting takes O(N log N), then compare the first and last strings in O(M).

Space Complexity: O(M)
Reason: StringBuilder stores the common prefix.
*/