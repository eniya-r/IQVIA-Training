abstract class Animal1 {
    abstract void makeSound();

    void sleep() {
        System.out.println("Animal Sleeping...");
    }
}

class Dog1 extends Animal1 {
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal1 {
    @Override
    void makeSound() {
        System.out.println("Cat meows");
    }
}

public class AbstractExample {
    public static void main(String[] args) {
        Animal1 a1 = new Dog1();
        Animal1 a2 = new Cat();

        a1.makeSound();
        a1.sleep();

        a2.makeSound();
        a2.sleep();
    }

}