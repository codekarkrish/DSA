import java.util.*;

public class Permutations_of_a_String {

    private static void generate(String str, String current,
                                 boolean[] used, List<String> result) {

        if (current.length() == str.length()) {
            result.add(current);
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            if (used[i]) continue;

            used[i] = true;
            generate(str, current + str.charAt(i), used, result);
            used[i] = false;
        }
    }

    public static List<String> findPermutations(String str) {

        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[str.length()];

        generate(str, "", used, result);

        return result;
    }

    public static void main(String[] args) {

        String str = "ABC";

        List<String> permutations = findPermutations(str);

        for (String s : permutations) {
            System.out.println(s);
        }
    }
}