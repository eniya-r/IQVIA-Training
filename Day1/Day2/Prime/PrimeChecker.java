import java.util.Scanner;
public class PrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        boolean prime = isPrime(n);

        if (prime) {
            System.out.println(n + " is a prime number.");
        } else {
            System.out.println(n + " is NOT a prime number.");
        }

        scanner.close();
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false; 
        if (n == 2) return true;  
        if (n % 2 == 0) return false; 

        int limit = (int) Math.sqrt(n); 
        for (int i = 3; i <= limit; i += 2) { 
            if (n % i == 0) {
                return false; 
            }
        }
        return true;
    }
}
