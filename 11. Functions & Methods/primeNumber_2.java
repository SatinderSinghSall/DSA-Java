//! Check of a number is Prime or not: Java

public class primeNumber_2 {
    public static boolean isPrime(int n) {
        boolean isPrime = true;
        for (int i = 2; i <= n - 1; i++) {
            if (n % i == 0) { // cmp div
                isPrime = false;
                break;
            } else {
                isPrime = true;
            }
        }
        return isPrime;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(12));
    }
}
