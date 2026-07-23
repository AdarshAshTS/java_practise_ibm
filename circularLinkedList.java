class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList{
    Node head;
    
    void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            newNode.next = head;
           return;
        }
        Node temp = head;
        while(temp.next != head)
            temp = temp.next;
        temp.next = newNode;
        newNode.next = head;
    }
    
    void print(){
        if(head == null){
            System.out.println("No list");
            return;
        }
        Node temp = head;
        
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

    }
}

class Main {
    public static void main(String[] args) {
        CircularLinkedList listobj = new CircularLinkedList();
        listobj.add(4);
        listobj.add(14);
        listobj.add(44);
        listobj.add(46);
        listobj.print();
    }
}