public class Reverse_every_word_in_a_string {

    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();

        int i = s.length() - 1;

        while (i >= 0) {

            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            if (i < 0) break;

            int end = i;

            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            if (result.length() > 0) {
                result.append(" ");
            }

            result.append(s.substring(i + 1, end + 1));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "  amazing coding skills  ";

        System.out.println("Original String : " + s);
        System.out.println("Reversed Words  : " + reverseWords(s));
    }
}

/*
Question: Reverse Words in a String

Time Complexity: O(N)
Reason: Traverse the string once from right to left.

Space Complexity: O(1)
Reason: Ignoring the output string, only a few variables are used.
*/