class StackTest{
    public static void main(String[] args) {
        StackOperations so = new StackOperations();
        so.push(5);
        so.pop();
        so.pop();
        so.push(61);
        so.push(67);
        so.push(63);
        so.display();
    }
}

class MyStack{
    int data;
    MyStack next;
    public MyStack(int data) {
        this.data = data;
        this.next = null;
    }
}

class StackOperations{
    private MyStack top;
    
    boolean isEmpty() {
        return top == null;
    }

    void push(int data){
        MyStack newnode = new MyStack(data);
        newnode.next = top;
        top = newnode;
        System.out.println("Added: " + data);
    }
    
    int pop(){
        if(isEmpty()){
            System.out.println("Stack Empty");
            return 0;
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    void display() {
        MyStack temp = top;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}