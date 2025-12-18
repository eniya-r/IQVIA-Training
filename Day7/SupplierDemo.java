import java.util.function.Supplier;
import java.time.LocalDateTime;

public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<LocalDateTime> currentDateTime = () -> LocalDateTime.now();

        Supplier<Double> randomNumber = () -> Math.random();

        System.out.println("Current DateTime: " + currentDateTime.get());
        System.out.println("Random Number: " + randomNumber.get());
    }
}
