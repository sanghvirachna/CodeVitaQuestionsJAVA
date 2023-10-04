import java.util.*;

public class LexiString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        scanner.nextLine();

        while (test > 0) {
            String P = scanner.nextLine();
            String S = scanner.nextLine();
            List<Integer> list1 = new ArrayList<>();
            for (char c : S.toCharArray()) {
                list1.add(P.indexOf(c));
            }
            Collections.sort(list1);
            for (int i : list1) {
                System.out.print(P.charAt(i));
            }
            if (test > 1) {
                System.out.println();
            }
            test--;
        }

        scanner.close();
    }
}

// Little Jill jumbled up the order of the letters in our dictionary. Now, Jack
// uses this list to find the smallest lexicographical string that can be made
// out of this new order. Can you help him?
// You are given a string P that denotes the new order of letters in the English
// dictionary.

// You need to print the smallest lexicographic string made from the given
// string S.
// Constraints:
// 1 <= T <= 1000
// Length (P) = 261 <= length (S) <= 100
// All characters in the string S, P are in lowercase

// Input Format

// The first line contains number of test cases T
// The second line has the string P
// The third line has the string S

// Output
// Print a single string in a new line for every test case giving the result

// Test Case

// Example 1
// Input
// 2
// polikujmnhytgbvfredcxswqaz
// abcd
// qwryupcsfoghjkldezxvbintma
// ativedoc
// Output
// bdca
// codevita
