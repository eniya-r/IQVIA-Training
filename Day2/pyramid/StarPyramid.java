import java.util.Scanner;
public class StarPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter pyramid height (rows): ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Height must be a positive integer.");
            scanner.close();
            return;
        }

        printStarPyramid(n);

        scanner.close();
    }

    public static void printStarPyramid(int n) {
        for (int i = 1; i <= n; i++) {

            for (int s = 1; s <= (n - i); s++) {
                System.out.print(" "); 
            }
            

            int stars = 2 * i - 1;
            for (int k = 1; k <= stars; k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
