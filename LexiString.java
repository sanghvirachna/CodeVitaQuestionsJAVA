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
