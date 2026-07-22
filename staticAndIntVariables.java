class Main{
    static int staticNumber = 0;
    static void test(int nonStaticNumber) {
        nonStaticNumber++;
        staticNumber++;
        System.out.println(
            "nonStaticNumber = " + nonStaticNumber +
            ", staticNumber = " + staticNumber
        );
    }

    public static void main(String[] args) {
        int nonStaticNumber = 0;
        for (int i = 0; i < 5; i++) {
            test(nonStaticNumber);
        }
    }
}