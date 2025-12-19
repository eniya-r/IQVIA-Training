import java.util.*;
import java.util.stream.Collectors;

public class StreamPipelineDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Raj", "Eniya", "Ram", "Elena", "Ravi");

        List<String> result = names.stream()
                .filter(n -> n.startsWith("R"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Filtered and transformed names: " + result);
    }
}
