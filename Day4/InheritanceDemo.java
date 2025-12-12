class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    void sound() {
        System.out.println(name + " makes a sound.");
    }

    void eat() {
        System.out.println(name + " eats food.");
    }
}

class Dog extends Animal {
    String breed;

    Dog(String name) {
        super(name);
        this.breed = breed;
    }

    @Override
    void sound() {
        System.out.println(name + " barks!" );
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Animal a = new Animal("Alexa");
        a.sound();
        a.eat();

        Dog d = new Dog("Buddy");
        d.sound();
        d.eat();
    }
}
