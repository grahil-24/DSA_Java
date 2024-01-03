package LinkedList;

public class CircularLinkedList {
    private Node head;
    private Node tail;

    private int size;

    public CircularLinkedList(){
        this.size = 0;
    }

    public void printList(){
        Node node = head;
        if(head != null){
            do{
                System.out.print(node.value+"->");
                node = node.next;
            }while(node != head);
        }
    }

    public void insert(int val, int index){
        if(index == size){
            insertLast(val);
        }else if(index == 0){
            insertFirst(val);
        }else if(index > size){
            System.out.println("Index out of bounds");
            return;
        }else{
            Node temp_head = head;
            Node node = new Node(val);
            for(int i=0; i<index-1; i++){
                temp_head = temp_head.next;
            }
            node.next = temp_head.next;
            temp_head.next = node;
            size++;
        }
    }

    public void insertLast(int value){
        if(size == 0){
            insertFirst(value);
        }else{
            Node node = new Node(value);
            tail.next = node;
            node.next = head;
            tail = node;
        }
        size++;
    }

    public void insertFirst(int value){
        Node node = new Node(value);
        if(size == 0){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head = node;
            tail.next = head;
        }
        size++;
    }

    public void deleteFirst(){
        if(size == 0){
            return;
        }
        if(size == 1){
            head = null;
            tail = null;
        }else{
            head = head.next;
            tail.next = head;
        }
        size--;
    }

    public void deleteLast(){
        if(size == 0){
            return;
        }
        if(size == 1){
            deleteFirst();
        }else{
            Node temp_head = head;
            while(temp_head.next != tail){
                temp_head = temp_head.next;
            }
            temp_head.next = head;
            size--;
        }
    }

    public int get(int index){
        if(index >= size){
            System.out.println("Index out of bounds");
            return -1;
        }else{
            Node tmp_head = head;
            for(int i =0; i<index; i++){
                tmp_head = tmp_head.next;
            }
            return tmp_head.value;
        }
    }

    private class Node {


        private Node next;
        private int value;

        public Node(int val) {
            this.value = val;
        }

        public Node(Node next, int value) {
            this.next = next;
            this.value = value;
        }

    }

    public static void main(String[] args) {
        CircularLinkedList ll = new CircularLinkedList();
        ll.insertLast(5);
//        ll.insertLast(6);
        ll.insertLast(7);
        ll.insertFirst(4);
        ll.insert(2, 2);
//        ll.insert(4, 2);
        ll.deleteLast();
        ll.deleteFirst();
        ll.printList();
    }
}


