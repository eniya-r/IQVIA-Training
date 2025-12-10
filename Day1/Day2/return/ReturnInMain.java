public class ReturnInMain {
    public static void main(String[] args) {
        System.out.println("Start");
        if (true) {
            return; // exit the main method
        }
        System.out.println("End");
    }
}
