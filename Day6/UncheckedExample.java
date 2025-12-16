class InvalidInputRuntimeException extends RuntimeException {
    public InvalidInputRuntimeException(String message) {
        super(message);
    }
}

public class UncheckedExample {
    public static int parseNonEmptyInt(String s) {

        if (s == null || s.isBlank()) {
            throw new InvalidInputRuntimeException("Input cannot be null or blank.");
        }
        return Integer.parseInt(s.trim());
    }

    public static void main(String[] args) {
        int a = parseNonEmptyInt(" 42 ");
        System.out.println(" Parsed: " + a);

        try {
            int b = parseNonEmptyInt("   ");
            System.out.println("Parsed: " + b);
        } catch (InvalidInputRuntimeException ex) {
            System.out.println(" Caught unchecked exception: " + ex.getMessage());
        }

        try {
            int c = parseNonEmptyInt("hello");
            System.out.println("Parsed: " + c);
        } catch (NumberFormatException ex) {
            System.out.println("Caught NumberFormatException: " + ex.getMessage());
        } finally {
            System.out.println("Finished unchecked example.");
        }
    }
}
