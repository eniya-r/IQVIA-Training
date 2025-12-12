interface Printer {
    void print(String message);
}

interface Calculator {
    void calculator(int a, int b);
}



class HpPrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println("Printing: " + message);
    }
}

class Epson implements Printer, Calculator {
    @Override
    public void print(String message) {
        System.out.println("Epson is Printing: " + message);
    }

    @Override
    public void calculator(int a, int b) {
        System.out.println("Epson is Adding: " + (a+b));
    }
}


public class InterfaceSimpleExample {
    public static void main(String[] args) {
        HpPrinter hp = new HpPrinter();
        hp.print("Print This");

        Printer epsonPrinter = new Epson();
        Epson epson = new Epson();
        epson.print("Print This");
        epson.calculator(2,3);

//        p.print("Hello, Eniya!");
    }
}
