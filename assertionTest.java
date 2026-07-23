class Test{
    public static void main(String[] args) {
        int age = 1;
        assert age >= 18 : "Age is less";
        System.out.println("age is" + age);

        assert true == false : "There is a problem";
        System.out.println("Hello, world");
    }
}
