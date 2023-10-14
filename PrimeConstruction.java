import java.util.Scanner;

public class PrimeConstruction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputParts = input.split(" ");
        long[] numbers = new long[inputParts.length];

        for (int i = 0; i < inputParts.length; i++) {
            numbers[i] = Long.parseLong(inputParts[i]);
        }

        long smallestPrime = findSmallestPrime(numbers);
        System.out.println(smallestPrime);
    }

    public static long findSmallestPrime(long[] numbers) {
        long q = Long.MAX_VALUE;
        for (long num : numbers) {
            if (num < q) {
                q = num;
            }
        }

        // Find the greatest common divisor (GCD) of all numbers (except q)
        long gcd = q;
        for (long num : numbers) {
            if (num != q) {
                gcd = gcd(gcd, num);
            }
        }

        for (long p = q + 1; p < 10000000000L; p += gcd) {
            if (isPrime(p)) {
                boolean isPrimeCandidate = true;
                for (long num : numbers) {
                    if (num != q && p % num != q) {
                        isPrimeCandidate = false;
                        break;
                    }
                }
                if (isPrimeCandidate) {
                    return p;
                }
            }
        }

        return -1;
    }

    public static boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
