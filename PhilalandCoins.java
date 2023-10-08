import java.util.Scanner;

class Philaland {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_cases = sc.nextInt();

        for (int i = 0; i < test_cases; i++) {
            int n = sc.nextInt();

            int count = 0;
            int denomination = 1;

            while (denomination <= n) {
                denomination *= 2;
                count++;
            }

            System.out.println(count);
        }
        sc.close();
    }
}
// The problem solvers have found a new Island for coding and named it as
// Philaland. These smart people were given a task to make purchase of items at
// the Island easier by distributing various coins with different value. Manish
// has come up with a solution that if we make coins category starting from $1
// till the maximum price of item present on Island, then we can purchase any
// item easily. He added following example to prove his point.

// Lets suppose the maximum price of an item is 5$ then we can make coins of
// {$1, $2, $3, $4, $5} to purchase any item ranging from $1 till $5. Now
// Manisha, being a keen observer suggested that we could actually minimize the
// number of coins required and gave following distribution {$1, $2, $3}.
// According to him any item can be purchased one time ranging from $1 to $5.
// Everyone was impressed with both of them.

// Your task is to help Manisha come up with minimum number of denominations for
// any arbitrary max price in Philaland.Input: N = 10
// Output: 4
// Explanation:
// According to Manish {$1, $2, $3, … $10} must be distributed.
// But as per Manisha only {$1, $2, $3, $4} coins are enough to purchase any
// item ranging from $1 to $10. Hence minimum is 4. Likewise denominations could
// also be {$1, $2, $3, $5}. Hence answer is still 4.

// Input: N = 5
// Output: 3
// Explanation:
// According to Manish {$1, $2, $3, $4, $5} must be distributed.
// But as per Manisha only {$1, $2, $3} coins are enough to purchase any item
// ranging from $1 to $5. Hence minimum is 3. Likewise denominations could also
// be {$1, $2, $4}. Hence answer is still 3......what is wrong in code