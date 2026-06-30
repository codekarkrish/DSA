public class String_to_Integer_atoi {

    public static int myAtoi(String input) {

        int i = 0;
        int n = input.length();

        while (i < n && input.charAt(i) == ' ') {
            i++;
        }

        if (i == n) return 0;

        int sign = 1;

        if (input.charAt(i) == '+' || input.charAt(i) == '-') {
            if (input.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        long num = 0;

        while (i < n && Character.isDigit(input.charAt(i))) {

            num = num * 10 + (input.charAt(i) - '0');

            if (sign == 1 && num > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if (sign == -1 && -num < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            i++;
        }

        return (int) (sign * num);
    }

    public static void main(String[] args) {

        String s1 = "42";
        String s2 = "   -042";
        String s3 = "1337c0d3";
        String s4 = "0-1";
        String s5 = "words and 987";

        System.out.println("Input: \"" + s1 + "\" -> " + myAtoi(s1));
        System.out.println("Input: \"" + s2 + "\" -> " + myAtoi(s2));
        System.out.println("Input: \"" + s3 + "\" -> " + myAtoi(s3));
        System.out.println("Input: \"" + s4 + "\" -> " + myAtoi(s4));
        System.out.println("Input: \"" + s5 + "\" -> " + myAtoi(s5));
    }
}

/*
Question: String to Integer (atoi)

Time Complexity: O(N)
Reason: Traverse the string once.

Space Complexity: O(1)
Reason: Uses only constant extra variables.
*/