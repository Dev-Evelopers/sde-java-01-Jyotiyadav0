
abstract class Calculator {
    abstract int add(int a, int b);
}
class Adder extends Calculator {
    @Override
    int add(int a, int b) {
        System.out.println("Adding integers: " + a + " " + b);
        return a + b;
    }
}
class Multiplier {
    int multiply(int a, int b, Calculator calculator) {
        int result = 0;
        for (int i = 0; i < b; i++) {
            result = calculator.add(result, a);
        }
        return result;
    }
}
public class Main {
    public static void main(String[] args) {
        int a = 7, b = 4;

        System.out.println("Testing Addition");
        Adder adder = new Adder();
        int sum = adder.add(a, b);
        System.out.println("Sum = " + sum);

        System.out.println("\nTesting Multiplication");
        Multiplier multiplier = new Multiplier();
        int product = multiplier.multiply(a, b, adder);
        System.out.println("Product = " + product);
    }
}
