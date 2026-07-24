class ClassAndMethods{
    public static void main(String[] args){
        grandparentClass gpc = new grandparentClass();
        childClass cc = new childClass();
        parentClass pc = new parentClass();
        System.out.println(gpc.age);
        System.out.println(cc.age);
        System.out.println(pc.age);
    }
}

class grandparentClass{
    int age = 80;
    private int height = 170;
    protected int weight = 76;
    public int hands = 2;
}

class parentClass extends grandparentClass{
    parentClass(){
        this.age = super.age - 20;
    } 
}

class childClass extends parentClass{
    childClass(){
        this.age = super.age - 20;
    }
}