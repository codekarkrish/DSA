import java.util.*;

// Fractional Knapsack
public class Fractional_Knapsack {

    // Item class
    static class Item {
        int value;
        int weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    static class Solution {

        // Function to find maximum value in knapsack
        public double fractionalKnapsack(int[] val, int[] wt, long cap) {

            int n = val.length;

            // Create item array
            Item[] items = new Item[n];
            for (int i = 0; i < n; i++) {
                items[i] = new Item(val[i], wt[i]);
            }

            // Sort by value/weight ratio in descending order
            Arrays.sort(items, (a, b) ->
                    Double.compare(
                            (double) b.value / b.weight,
                            (double) a.value / a.weight));

            double maxValue = 0.0;
            long currentWeight = 0;

            // Pick items greedily
            for (Item item : items) {

                // Take whole item if possible
                if (currentWeight + item.weight <= cap) {
                    currentWeight += item.weight;
                    maxValue += item.value;
                } else {
                    // Take fractional part
                    long remain = cap - currentWeight;

                    maxValue +=
                            ((double) item.value / item.weight) * remain;

                    break;
                }
            }

            return maxValue;
        }
    }

    public static void main(String[] args) {

        int[] val = {100, 60, 120};
        int[] wt = {20, 10, 30};
        long cap = 50;

        Solution sol = new Solution();

        double result = sol.fractionalKnapsack(val, wt, cap);

        System.out.printf("Maximum Value: %.2f%n", result);
    }
}

/*
Problem: Fractional Knapsack

Approach: Greedy (Sort by Value/Weight Ratio)

TC: O(N log N)   // Sorting items
SC: O(N)         // Extra Item array
*/