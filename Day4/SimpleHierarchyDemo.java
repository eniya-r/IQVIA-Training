class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    void work() {
        System.out.println(name + " works on tasks.");
    }

    double bonus() {
        return 10000;
    }
}

class Manager extends Employee {
    Manager(String name) {
        super(name);
    }

    @Override
    void work() {
        System.out.println(name + " manages the team and plans work.");
    }

    @Override
    double bonus() {
        return 20000;
    }
}

class Developer extends Manager {
    Developer(String name) {
        super(name);
    }

    @Override
    void work() {
        System.out.println(name + " writes code and fixes bugs.");
    }

    @Override
    double bonus() {
        return 30000;
    }
}

public class SimpleHierarchyDemo {
    public static void main(String[] args) {
        Employee e = new Employee("Alex");
        e.work();
        System.out.println("Employee bonus: ₹" + e.bonus());
        System.out.println();

        Manager m = new Manager("Kiran");
        m.work();
        System.out.println("Manager bonus: ₹" + m.bonus());
        System.out.println();


        Developer d = new Developer("Eniya");
        d.work();
        System.out.println("Developer bonus: ₹" + d.bonus());
        System.out.println();

//        To demonstrate polymorphism
        Employee poly = new Developer("Ravi");
        poly.work();
        System.out.println("Polymorphic bonus: ₹" + poly.bonus());
    }
}
