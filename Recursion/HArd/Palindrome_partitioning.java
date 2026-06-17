import java.util.*;

public class Palindrome_partitioning {

    static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    static void solve(int index, String s,
                      List<String> path,
                      List<List<String>> ans) {

        if (index == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {

            if (isPalindrome(s, index, i)) {

                path.add(s.substring(index, i + 1));

                solve(i + 1, s, path, ans);

                path.remove(path.size() - 1);
            }
        }
    }

    static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solve(0, s, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {

        String s = "aabaa";

        List<List<String>> result = partition(s);

        System.out.println(result);
    }
}