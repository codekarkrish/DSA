import java.util.Scanner;

public class Kth_element_of_2_sorted_arrays {

    public static int kthElement(int[] a, int[] b, int k) {

        int m = a.length;
        int n = b.length;

        // Always binary search on the smaller array
        if (m > n)
            return kthElement(b, a, k);

        int low = Math.max(0, k - n);
        int high = Math.min(k, m);

        while (low <= high) {

            int cut1 = (low + high) / 2;
            int cut2 = k - cut1;

            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : a[cut1 - 1];
            int right1 = (cut1 == m) ? Integer.MAX_VALUE : a[cut1];

            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : b[cut2 - 1];
            int right2 = (cut2 == n) ? Integer.MAX_VALUE : b[cut2];

            if (left1 <= right2 && left2 <= right1) {
                return Math.max(left1, left2);
            } 
            else if (left1 > right2) {
                high = cut1 - 1;
            } 
            else {
                low = cut1 + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first array: ");
        int m = sc.nextInt();

        int[] a = new int[m];
        System.out.println("Enter elements of first sorted array:");
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
        }

        System.out.print("Enter size of second array: ");
        int n = sc.nextInt();

        int[] b = new int[n];
        System.out.println("Enter elements of second sorted array:");
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        System.out.print("Enter k (1 to " + (m + n) + "): ");
        int k = sc.nextInt();

        if (k < 1 || k > m + n) {
            System.out.println("Invalid k!");
        } else {
            System.out.println("K-th Element = " + kthElement(a, b, k));
        }

        sc.close();
    }
}