import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Scanner;

public class HW7P1_Pyakurel {

    public static Set<Integer> sieveOfEratosthenes(int n) {
        Set<Integer> primes = new HashSet<>();

        if (n < 2) {
            return primes;
        }

        for (int i = 2; i <= n; i++) {
            primes.add(i);
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (primes.contains(i)) {
                for (int j = i * 2; j <= n; j += i) {
                    primes.remove(j);
                }
            }
        }

        return primes;
    }

    public static void testSieve() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a positive integer: ");
            int n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("Invalid Input. Please enter a positive integer.");
                return;
            }

            Set<Integer> primeNumbers = sieveOfEratosthenes(n);

            System.out.printf("The prime numbers less than %d are: %s%n", n, primeNumbers);

        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid positive integer.");
        }
    }

    public static void main(String[] args) {
        testSieve();
    }
}