package geeks;

import java.util.Scanner;

/**
 * print composite numbers less than given number
 * 
 * @author vsidda
 *
 */
public class CompositeTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        for (int i = 0; i < N; i++) {
            int upper = scan.nextInt();
            findComposites(upper);
            System.out.println("\n");
        }
        scan.close();
    }

    private static void findComposites(int upper) {
        for (int i = 4; i <= upper; i++) {
            if (!isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    private static boolean isPrime(int p) {
        for (int i = 2; i <= p / 2; i++) {
            if (p % i == 0) {
                return false;
            }
        }
        return true;
    }
}