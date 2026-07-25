import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

class MethodReferenceDemo {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> max = Math::max;
        System.out.println(max.apply(10, 20));

        Function<String, String> lower = String::toLowerCase;
        System.out.println(lower.apply("HELLO JAVA"));

        Supplier<ArrayList<String>> listRef = ArrayList::new;
        ArrayList<String> list = listRef.get();
        list.add("Java");

        System.out.println(list);
    }
}