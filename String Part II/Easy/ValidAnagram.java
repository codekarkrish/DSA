public class ValidAnagram {

    static class Solution {
        public boolean isAnagram(String s, String t) {
            // If lengths differ, they cannot be anagrams
            if (s.length() != t.length()) {
                return false;
            }

            int[] freq = new int[26];

            // Count characters in first string
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 'a']++;
            }

            // Decrease count using second string
            for (int i = 0; i < t.length(); i++) {
                freq[t.charAt(i) - 'a']--;
            }

            // Check if all frequencies are zero
            for (int count : freq) {
                if (count != 0) {
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "anagram";
        String t = "nagaram";

        if (solution.isAnagram(s, t)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}

/*
Time Complexity: O(N), where N is the length of the strings. Each string is traversed once, and the frequency array is checked in constant time (26 iterations).

Space Complexity: O(1), as a fixed-size array of 26 elements is used regardless of the input size.
*/