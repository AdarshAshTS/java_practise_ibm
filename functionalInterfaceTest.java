
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class FunctionalInterfaceTest{
    public static void main(String[] args) {
        Function<Integer, Double> dollar = ruppee -> ruppee * 90.0;
        System.out.println("amount: " + dollar.apply(1500));

        Predicate<Integer> DivisibleBy5 = num -> num%5 == 0;
        System.out.println(DivisibleBy5.test(18));

        Supplier<String> supplier = () -> "Supplied Value";
        System.out.println(supplier.get());
    }
}

@FunctionalInterface
interface TestInterface{
    void testMethod();
}