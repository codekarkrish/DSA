// Class containing power calculation logic
class Power_Raised {

    // Recursive function to calculate x^n
    private double power(double x, long n) {

        // Base case:
        // Kisi bhi number ki power 0 ho to answer 1 hota hai
        if (n == 0) {
            return 1.0;
        }

        // Agar exponent even hai
        if (n % 2 == 0) {

            // x^n = (x*x)^(n/2)
            return power(x * x, n / 2);
        }

        // Agar exponent odd hai
        // x^n = x * (x*x)^(n/2)
        return x * power(x * x, n / 2);
    }

    // Main function
    public double myPow(double x, int n) {

        // int ki range se bachne ke liye
        // n ko long me convert kar rahe hain
        long N = n;

        // Negative exponent handle karna
        if (N < 0) {

            // x^(-n) = 1 / x^n
            return 1.0 / power(x, -N);
        }

        return power(x, N);
    }

    public static void main(String[] args) {

        // Object creation
        Power_Raised sol = new Power_Raised();

        // Test Case 1
        double x1 = 2.0;
        int n1 = 10;
        System.out.println(x1 + "^" + n1 + " = " + sol.myPow(x1, n1));

        // Test Case 2
        double x2 = 2.0;
        int n2 = -2;
        System.out.println(x2 + "^" + n2 + " = " + sol.myPow(x2, n2));

        // Test Case 3
        double x3 = 2.1;
        int n3 = 3;
        System.out.println(x3 + "^" + n3 + " = " + sol.myPow(x3, n3));
    }
}