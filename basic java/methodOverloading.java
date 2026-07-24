class MethodOverloadingTest{

    public static void main(String[] args) {
        MethodOverloadingClass moc = new MethodOverloadingClass();
        double methodTestNumber1 = 10;
        int methodTestNumber2 = 56;
        char methodCharacter = 'A';
        moc.methodTest(methodTestNumber2);
        moc.methodTest(methodTestNumber2, methodTestNumber1);
        moc.methodTest(methodTestNumber1);
        moc.methodTest(methodTestNumber1, methodTestNumber2);
        moc.methodTest(methodCharacter, methodTestNumber2, methodTestNumber1);
    }
}

class MethodOverloadingClass{
    static void methodTest(char methodCharacter, int methodNumber1, double  methodNumber2){
        System.out.println("this is method with number parameter: " + methodCharacter + "" + methodNumber1 + "" + methodNumber2);
    }

    static void methodTest(int methodNumber1){
        System.out.println("this is method 1: " + methodNumber1);
    }

    static void methodTest(double methodNumber1){
        System.out.println("this is method 2: " + methodNumber1);
    }

    static void methodTest(int methodNumber1, double methodNumber2){
        System.out.println("this is method 1: " + methodNumber1 + "," + methodNumber2);
    }

    static void methodTest(double methodNumber1, int methodNumber2){
        System.out.println("this is method 2: " + methodNumber1 + "," + methodNumber2);
    }
}