 import java.util.*;

public class Permutation_Sequence {

    static String getPermutation(int n, int k) {

        int fact = 1;
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);

        StringBuilder ans = new StringBuilder();
        k--;

        while (true) {

            ans.append(numbers.get(k / fact));
            numbers.remove(k / fact);

            if (numbers.isEmpty()) {
                break;
            }

            k = k % fact;
            fact = fact / numbers.size();
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        int n = 3;
        int k = 3;

        String result = getPermutation(n, k);

        System.out.println("The Kth permutation sequence is " + result);
    }
}