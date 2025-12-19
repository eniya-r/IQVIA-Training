import java.util.*;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class EmployeeListOperationsDemo {

    static class Employee {
        private final String name;
        private final String department;
        private final boolean active;
        private final int age;

        Employee(String name, String department, boolean active, int age) {
            this.name = name;
            this.department = department;
            this.active = active;
            this.age = age;
        }

        public String getName() { return name; }
        public String getDepartment() { return department; }
        public boolean isActive() { return active; }
        public int getAge() { return age; }

        @Override
        public String toString() {
            return String.format("%s(%s, active=%s, age=%d)", name, department, active, age);
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Raj",   "IT",      true,  28),
                new Employee("Eniya", "HR",      true,  26),
                new Employee("Ram",   "IT",      false, 31),
                new Employee("Elena", "Finance", true,  33),
                new Employee("Ravi",  "IT",      true,  24),
                new Employee("Eva",   "HR",      false, 29),
                new Employee("Rita",  "Finance", true,  30)
        );

        Predicate<Employee> isActive = Employee::isActive;
        Predicate<Employee> nameStartsWithR = e -> e.getName().startsWith("R");

        Consumer<Employee> printEmployee = e -> System.out.println(" - " + e);


        List<Employee> activeR = employees.stream()
                .filter(isActive.and(nameStartsWithR))
                .collect(Collectors.toList());

        System.out.println("Active employees whose names start with 'R':");
        activeR.forEach(printEmployee);

        List<Employee> sortedActive = employees.stream()
                .filter(isActive)
                .sorted(Comparator
                        .comparingInt(Employee::getAge)
                        .thenComparing(Employee::getName))
                .collect(Collectors.toList());

        System.out.println("\nActive employees sorted by age, then name:");
        sortedActive.forEach(printEmployee);

        Map<String, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("\n Employees grouped by department:");
        byDept.forEach((dept, list) -> {
            System.out.println(dept + ":");
            list.forEach(printEmployee);
        });
    }
}
