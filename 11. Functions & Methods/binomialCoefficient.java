//! Binomial Coefficient: Java

public class binomialCoefficient {
    public static int calculateFactorial(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

    public static int calculateBinomialCoefficient(int n, int r) {
        int n_fact = calculateFactorial(n);
        int r_fact = calculateFactorial(r);
        int nMn_fact = calculateFactorial(n - r);

        int binomialCoefficient = n_fact / (r_fact * nMn_fact);

        return binomialCoefficient;
    }

    public static void main(String[] args) {
        System.out.println(calculateBinomialCoefficient(5, 2));
    }
}
