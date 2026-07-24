class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList{
    Node head;
    
    void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
           return;
        }
        Node temp = head;
        while(temp.next != null)
            temp = temp.next;
        newNode.prev = temp;
        temp.next = newNode;
        newNode.next = null;
    }
    
    void print(){
        if(head == null){
            System.out.println("No list");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }
}

class Main {
    public static void main(String[] args) {
        DoublyLinkedList listobj = new DoublyLinkedList();
        listobj.add(4);
        listobj.add(14);
        listobj.add(44);
        listobj.add(46);
        listobj.print();
    }
}