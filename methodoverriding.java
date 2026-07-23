class MethodOverriding{
    public static void main(String[] args) {
        ChildClass child = new ChildClass();
        child.printParentClass();
    }
}

class ParentClass{
    void printParentClass(){
        System.out.println("This is parent class");
    }
}

class ChildClass extends ParentClass{
    void printParentClass(){
        System.out.println("This is child class");
    }
}