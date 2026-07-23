class LambdaCalculator{
    public static void main(String[] args) {
        Calculator add = (a, b) -> a + b;
        Calculator subtract = (a, b) -> a - b;
        Calculator multiply = (a, b) -> a * b;
        Calculator divide = (a, b) -> (float)a / b;
        Calculator modulo = (a, b) -> a % b;

        System.out.println(add.calculate(6, 7));
        System.out.println(subtract.calculate(10, 3));
        System.out.println(multiply.calculate(2, 4));
        System.out.println(divide.calculate(18, 4));
        System.out.println(modulo.calculate(28, 3));
    }
}

@FunctionalInterface
interface Calculator{
    float calculate(int a, int b);
}