class AbstractandNonabstract{
    public static void main(String[] args) {
        
    }
}

interface TestInterface{
    abstract void method1();
    abstract void method4();
    default void method2(){
        System.out.println("This is method 2");
    }
    default void method3(){
        System.out.println("This is method 3");
    }
}