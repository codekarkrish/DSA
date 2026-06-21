import java.util.*;

public class Median_of_Two_Sorted_Arrays {

    public static double median(int[] arr1, int[] arr2) {

        // Binary search on smaller array
        if (arr1.length > arr2.length)
            return median(arr2, arr1);

        int m = arr1.length;
        int n = arr2.length;

        int low = 0, high = m;

        while (low <= high) {

            int cut1 = (low + high) / 2;
            int cut2 = (m + n + 1) / 2 - cut1;

            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int right1 = (cut1 == m) ? Integer.MAX_VALUE : arr1[cut1];

            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int right2 = (cut2 == n) ? Integer.MAX_VALUE : arr2[cut2];

            // Correct partition found
            if (left1 <= right2 && left2 <= right1) {

                if ((m + n) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }

            }
            // Move left
            else if (left1 > right2) {
                high = cut1 - 1;
            }
            // Move right
            else {
                low = cut1 + 1;
            }
        }

        return 0.0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first array: ");
        int m = sc.nextInt();

        int[] arr1 = new int[m];
        System.out.println("Enter elements of first sorted array:");
        for (int i = 0; i < m; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.print("Enter size of second array: ");
        int n = sc.nextInt();

        int[] arr2 = new int[n];
        System.out.println("Enter elements of second sorted array:");
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

        System.out.println("Median = " + median(arr1, arr2));

        sc.close();
    }
}