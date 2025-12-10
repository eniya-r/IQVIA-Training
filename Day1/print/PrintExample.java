import java.util.Scanner;

public class PrintExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine(); 

        System.out.print("Enter your age (years): ");
        int age = scanner.nextInt(); 

        System.out.print("Enter your marks (out of 100): ");
        double marks = scanner.nextDouble(); 

        System.out.println("\n--- Student Summary ---");
        System.out.printf("Name : %s%n", name);
        System.out.printf("Age  : %d years%n", age);
        System.out.printf("Marks: %.2f / 100%n", marks); 


        scanner.close();
    }
}
