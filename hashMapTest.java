import java.util.HashMap;

class HashMapTest{
    public static void main(String[] args) {
        HashMap<Integer, String> nameSet = new HashMap<>();
        nameSet.put(1, "adarsh");
        System.out.print(nameSet.get(1));
    }
}