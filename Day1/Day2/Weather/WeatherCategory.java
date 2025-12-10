import java.util.Scanner;

public class WeatherCategory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter temperature: ");
        int temp = scanner.nextInt();

        String category;

        if (temp < 0 || temp > 40) {
            category = "Out of range";
        } else if (temp <= 20) {         
            category = "Cold";
        } else if (temp <= 25) {          
            category = "Mild";
        } else {                        
            category = "Sunny";
        }

        System.out.println("Weather: " + category);

        scanner.close();
    }
}
