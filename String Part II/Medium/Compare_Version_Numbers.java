public class Compare_Version_Numbers {

    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        int n = version1.length(), m = version2.length();

        while (i < n || j < m) {
            int num1 = 0, num2 = 0;

            // Read current revision from version1
            while (i < n && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (version1.charAt(i) - '0');
                i++;
            }

            // Read current revision from version2
            while (j < m && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (version2.charAt(j) - '0');
                j++;
            }

            if (num1 < num2) return -1;
            if (num1 > num2) return 1;

            i++;
            j++;
        }

        return 0;
    }

    public static void main(String[] args) {
        Compare_Version_Numbers obj = new Compare_Version_Numbers();

        String version1 = "1.2";
        String version2 = "1.10";

        System.out.println(obj.compareVersion(version1, version2));
    }
}

/*
Time Complexity: O(N + M)
Space Complexity: O(1)

N = version1.length(), M = version2.length()
*/