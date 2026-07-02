public class Count_and_Say {

    public String countAndSay(int n) {
        String result = "1";

        // Generate the sequence up to the nth term
        for (int i = 1; i < n; i++) {
            StringBuilder current = new StringBuilder();
            int count = 1;

            // Traverse the previous result
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    current.append(count).append(result.charAt(j - 1));
                    count = 1;
                }
            }

            // Append the last group
            current.append(count).append(result.charAt(result.length() - 1));

            result = current.toString();
        }

        return result;
    }

    public static void main(String[] args) {
        Count_and_Say obj = new Count_and_Say();

        int n = 5;
        System.out.println(obj.countAndSay(n));
    }
}

/*
Time Complexity: O(n * 2^n)
Space Complexity: O(2^n)
*/