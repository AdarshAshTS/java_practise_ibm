
import java.util.function.Predicate;

class ArrayUsingLambda{
    public static void main(String[] args) {
        int[] arr = {9, 12, 65, 45, 76, 98, 14, 52, 567, 23};

        // using predicate
        for(int numArr : arr){
            Predicate<Integer> check = num -> num%2 == 0;
            System.out.println(numArr + (check.test(numArr) ? " is even" : " is odd"));
        }

        //using lambda
        ArrayCheck isEven = num -> System.out.println(num + (num % 2 == 0 ? " is even" : " is odd"));
        for(int numArr : arr){
            isEven.check(numArr);
        }
    }
}

@FunctionalInterface
interface ArrayCheck{
    void check(int num);
}