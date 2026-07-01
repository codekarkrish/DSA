public class ShortestPalindrome {

    // Function to find the shortest palindrome
    public static String shortestPalindrome(String s) {

        String rev = new StringBuilder(s).reverse().toString();

        // Build string for KMP
        String str = s + "#" + rev;

        int[] lps = new int[str.length()];
        int len = 0;

        // Compute LPS array
        for (int i = 1; i < str.length();) {

            if (str.charAt(i) == str.charAt(len)) {
                lps[i++] = ++len;
            } else {

                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i++] = 0;
                }
            }
        }

        // Add remaining reversed characters in front
        return rev.substring(0, s.length() - lps[str.length() - 1]) + s;
    }

    public static void main(String[] args) {

        String s1 = "aacecaaa";
        String s2 = "abcd";

        System.out.println("Input: " + s1);
        System.out.println("Shortest Palindrome: " + shortestPalindrome(s1));

        System.out.println();

        System.out.println("Input: " + s2);
        System.out.println("Shortest Palindrome: " + shortestPalindrome(s2));
    }
}

/*
Time Complexity: O(N)
Space Complexity: O(N)
*/