class WrapperClass{
    public static void main(String[] args) {
        int x = 10;
        Integer y = 10;
        System.out.println("x is: " + x + "\ny is: " + y);
        y = x;
        System.out.println("x is: " + x + "\ny is: " + y);
    }
}