import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Raj", "Eniya", "Ram", "Elena", "Ravi", "Eva");

        Predicate<String> startsWithR = name -> name.startsWith("R");

        Predicate<String> lengthAtLeast4 = name -> name.length() >= 4;

      /*  Predicate<String> combined = startsWithR.and(lengthAtLeast4);

        List<String> filteredNames = names.stream()
                .filter(combined)
                .collect(Collectors.toList());

        System.out.println("Names starting with R and length >= 4: " + filteredNames);


        List<String> orFiltered = names.stream()
                .filter(startsWithR.or(lengthAtLeast4))
                .collect(Collectors.toList());
        System.out.println("Names starting with R OR length >= 4: " + orFiltered);

        List<String> notRNames = names.stream()
                .filter(startsWithR.negate())
                .collect(Collectors.toList());
        System.out.println("Names NOT starting with R: " + notRNames); */
    }
}
