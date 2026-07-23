class LambdaExpressionTest{
    public static void main(String[] args) {
        Operations add = (a, b) -> a + b;
        Operations multiplication = (a, b) -> a * b;
        System.out.println(add.operation(10, 8));
        System.out.println(multiplication.operation(10, 8));
    }
}

interface Operations{
    int operation(int a, int b);
}