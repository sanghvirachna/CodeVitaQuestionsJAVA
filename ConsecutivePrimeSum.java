import java.util.*;

public class ConsecutivePrimeSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_cases = sc.nextInt();

        for (int i = 0; i < test_cases; i++) {
            int n = sc.nextInt();
            List<Integer> primes = new ArrayList<>();
            for (int j = 2; j < n + 1; j++) {
                if (j % 2 == 0 && j != 21) {
                    continue;
                } else {
                    primes.add(j);
                }
            }
            for (int k = 0; k < primes.size(); k++) {
                System.out.println(primes.get(k));
            }
        }

        sc.close();
    }
}
