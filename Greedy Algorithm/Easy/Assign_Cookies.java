import java.util.*;

public class Assign_Cookies {

    // Function to find maximum number of content children
    public static int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;
        int cookie = 0;

        while (child < g.length && cookie < s.length) {

            if (s[cookie] >= g[child]) {
                child++;
            }

            cookie++;
        }

        return child;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of children: ");
        int n = sc.nextInt();

        int[] g = new int[n];
        System.out.println("Enter greed factors:");
        for (int i = 0; i < n; i++) {
            g[i] = sc.nextInt();
        }

        System.out.print("Enter number of cookies: ");
        int m = sc.nextInt();

        int[] s = new int[m];
        System.out.println("Enter cookie sizes:");
        for (int i = 0; i < m; i++) {
            s[i] = sc.nextInt();
        }

        int result = findContentChildren(g, s);

        System.out.println("Maximum number of content children: " + result);

        sc.close();
    }
}