import java.util.HashMap;

public class Roman_to_Integer {

    public static int romanToInt(String s) {
        int res = 0;

        HashMap<Character, Integer> roman = new HashMap<>();

        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        for (int i = 0; i < s.length() - 1; i++) {

            if (roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                res -= roman.get(s.charAt(i));
            } else {
                res += roman.get(s.charAt(i));
            }
        }

        return res + roman.get(s.charAt(s.length() - 1));
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";

        System.out.println("Roman Numeral : " + s);
        System.out.println("Integer Value : " + romanToInt(s));
    }
}

/*
Question: Roman to Integer

Time Complexity: O(N)
Reason: Traverse the string once.

Space Complexity: O(1)
Reason: Uses a fixed-size map of Roman numerals.
*/