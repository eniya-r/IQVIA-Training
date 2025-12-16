class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CheckedExample {
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 1 || age > 120) {
            throw new InvalidAgeException("Age " + age + " is invalid. Allowed range is 1..120.");
        }
        System.out.println(" Age " + age + " is valid.");
    }

    public static void main(String[] args) {
        try {
            validateAge(25);

            validateAge(150);
            System.out.println("This line won't run because the previous call throws.");
        } catch (InvalidAgeException ex) {
            System.out.println(" Caught checked exception: " + ex.getMessage());
        } finally {
            System.out.println(" Finished checked example.");
        }
    }

}