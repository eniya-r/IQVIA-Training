interface MyInterface {
    static void staticMethod() {
        System.out.println("This is a static method in interface");
    }
}

public class StaticMethodDemo {
    public static void main(String[] args) {
        MyInterface.staticMethod();
    }
}
