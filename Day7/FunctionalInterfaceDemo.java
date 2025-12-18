@FunctionalInterface
interface Calculator {
    int operate(int a, int b);

   default int add(int x, int y) {
        return x + y;
    }

    static int square(int x) {
        return x * x;
    }
}

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        Calculator sum = (a, b) -> a + b;

        Calculator multiply = (a, b) -> a * b;

        System.out.println("5 + 3 = " + sum.operate(5, 3));
        System.out.println("5 * 3 = " + multiply.operate(5, 3));

        System.out.println("add(5, 3) via default method = " + sum.add(5, 3));
        System.out.println("square(6) via static method = " + Calculator.square(6));
    }
}
