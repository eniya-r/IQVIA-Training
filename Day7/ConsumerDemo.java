import java.util.function.Consumer;
import java.util.Arrays;
import java.util.List;

public class ConsumerDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40);

        Consumer<Integer> printNumber = n -> System.out.println("Number: " + n);

        Consumer<Integer> printSquare = n -> System.out.println("Square: " + (n * n));

        Consumer<Integer> combined = printNumber.andThen(printSquare);

        numbers.forEach(combined);
    }
}
