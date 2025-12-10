import java.util.Scanner;

public class Ticket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter ticket price: ");
        int price = scanner.nextInt();

        String category;

        if (price <= 0) {
            category = "Invalid price";
        } else if (price <= 1000) {
            category = "General";
        } else if (price >= 2000) {
            category = "Fanpit 1";
        } else {
            category = "Regular"; 
        }

        System.out.println("Ticket Category: " + category);

        scanner.close();
    }
}
