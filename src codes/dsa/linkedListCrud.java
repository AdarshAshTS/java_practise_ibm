class LinkedListCrud{
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.add(1);
        sll.add(2);
        sll.add(56);

        sll.printList();
    }
}

class SinglyLinkedListNode{
    int data;
    SinglyLinkedListNode next;
    public SinglyLinkedListNode(int data){
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList{
    SinglyLinkedListNode head;

    void add(int data){
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        if(head == null){
            head = newNode;
            return;
        }

        SinglyLinkedListNode temp = head;
        while(temp.next != null)
            temp = temp.next;

        temp.next = newNode;
    }
    
    void printList() {
            SinglyLinkedListNode temp = head;

            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }

            System.out.println("null");
        }

}